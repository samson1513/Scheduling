package com.am.scheduling.domain.repositories.ga;

import android.os.Environment;

import com.am.scheduling.chapter5.Class;
import com.am.scheduling.chapter5.GeneticAlgorithm;
import com.am.scheduling.chapter5.Group;
import com.am.scheduling.chapter5.Population;
import com.am.scheduling.chapter5.Timeslot;
import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.dao.TimeslotDao;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.presentation.utils.DateUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class GenRepoImpl implements GenRepo {

    @Inject
    RoomDao mRoomDao;
    @Inject
    TimeslotDao mTimeslotDao;
    @Inject
    GroupDao groupDao;

    @Inject
    public GenRepoImpl() {
    }

    @Override
    public Single<File> generate(Timetable timetable) {
        return Single.zip(Single.just(mRoomDao.get()),
                Single.just(timetable),
                (rooms, timetable1) -> {
                    for (Room r : rooms) {
                        timetable1.addRoom(r.id, r.name, r.capacity);
                    }
                    return executeGA(timetable);
                })
                .map(classes -> {

                    File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

                    if (!directory.exists()) {
                        if (!directory.mkdirs()) {
                            throw new IllegalAccessException("Directory was not created");
                        }
                    }

                    String stamp = DateUtil.toString(new Date(), DateUtil.PATTERN_TIMESTAMP);
                    String fileName = "Schedule-" + stamp + ".xls";

                    File file = new File(directory, fileName);


                    Group[] groups = timetable.getGroupsAsArray();
                    Timeslot[] timeslots = timetable.getTimeslotsAsArray();


                    WritableWorkbook workbook = Workbook.createWorkbook(file, new WorkbookSettings());

                    WritableSheet sheet = workbook.createSheet("Schedule", 0);

                    for (int i = 0; i < groups.length; i++) {
                        sheet.addCell(new Label(i + 1, 0, groupDao.get(groups[i].getGroupId()).name));
                        sheet.getColumnView(i + 1).setAutosize(true);
                    }

                    for (int i = 0; i < timeslots.length; i++) {
                        sheet.addCell(new Label(0, i + 1, timeslots[i].getTimeslot()));
                    }

                    for (Class bestClass : classes) {


                        int indexGroup = 0;
                        for (int i = 0; i < groups.length; i++) {
                            if (bestClass.getGroupId() == groups[i].getGroupId()) {
                                indexGroup = i;
                                break;
                            }
                        }

                        int indexTimeSlot = 0;
                        for (int j = 0; j < timeslots.length; j++) {
                            if (bestClass.getTimeslotId() == timeslots[j].getTimeslotId()) {
                                indexTimeSlot = j;
                                break;
                            }
                        }

                        String cell = String.format("(%s) %s\n%s",
                                timetable.getRoom(bestClass.getRoomId()).getRoomNumber(),
                                timetable.getModule(bestClass.getModuleId()).getModuleName(),
                                timetable.getProfessor(bestClass.getProfessorId()).getProfessorName()
                        );
                        System.out.println((indexGroup + 1) + "|" + (indexTimeSlot + 1) + "|" + cell);
                        sheet.addCell(new Label(indexGroup + 1, indexTimeSlot + 1, cell));

                    }

                    workbook.write();
                    workbook.close();

                    return file;
                });
    }

    private List<Class> executeGA(Timetable timetable) {

        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);

        // Initialize population
        Population population = ga.initPopulation(timetable);

        // Evaluate population
        ga.evalPopulation(population, timetable);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (!ga.isTerminationConditionMet(generation, 1000)
                && !ga.isTerminationConditionMet(population)) {
            // Print fitness
            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        // Print fitness
        timetable.createClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + timetable.calcClashes());

        // Print classes
        System.out.println();
        Class classes[] = timetable.getClasses();
        int classIndex = 1;
        for (Class bestClass : classes) {
            System.out.println("Class " + classIndex + ":");
            System.out.println("Module: " +
                    timetable.getModule(bestClass.getModuleId()).getModuleName());
            System.out.println("Group: " +
                    timetable.getGroup(bestClass.getGroupId()).getGroupId());
            System.out.println("Room: " +
                    timetable.getRoom(bestClass.getRoomId()).getRoomNumber());
            System.out.println("Professor: " +
                    timetable.getProfessor(bestClass.getProfessorId()).getProfessorName());
            System.out.println("Time: " +
                    timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot());
            System.out.println("-----");
            classIndex++;
        }
        return Arrays.asList(classes);
    }
}
