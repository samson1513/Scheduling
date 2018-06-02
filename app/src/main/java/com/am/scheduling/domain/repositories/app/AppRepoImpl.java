package com.am.scheduling.domain.repositories.app;

import com.am.scheduling.data.database.dao.GroupDao;
import com.am.scheduling.data.database.dao.RoomDao;
import com.am.scheduling.data.database.dao.SubjectDao;
import com.am.scheduling.data.database.dao.TeacherDao;
import com.am.scheduling.data.database.dao.TimeslotDao;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Room;
import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.data.database.models.Timeslot;
import com.am.scheduling.presentation.utils.DateUtil;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * Created by Alex Michenko
 * on 02.06.2018.
 */
public class AppRepoImpl implements AppRepo {

    @Inject
    RoomDao roomDao;
    @Inject
    GroupDao groupDao;
    @Inject
    TeacherDao teacherDao;
    @Inject
    SubjectDao subjectDao;
    @Inject
    TimeslotDao timeslotDao;

    @Inject
    public AppRepoImpl() {
    }

    @Override
    public Completable fill() {
        return Completable.fromAction(() -> {
            fillRoom();
            fillGroup();
            fillTeacher();
            fillSubject();
            fillTimeslot();
        });
    }

    private void fillRoom() {
        if (roomDao.count() == 0) {
            roomDao.insert(
                    new Room("100", 50),
                    new Room("101", 50),
                    new Room("102", 25),
                    new Room("103", 50),
                    new Room("104", 30),
                    new Room("105", 20),
                    new Room("106", 50),
                    new Room("107", 15),
                    new Room("108", 50),
                    new Room("109", 30),
                    new Room("110", 20),
                    new Room("111", 50),
                    new Room("112", 50),
                    new Room("113", 15),
                    new Room("114", 20),
                    new Room("115", 50)
            );
        }
    }

    private void fillGroup() {
        if (groupDao.count() == 0) {
            groupDao.insert(
                    new Group("Group 01", 10),
                    new Group("Group 02", 25),
                    new Group("Group 03", 20),
                    new Group("Group 04", 18),
                    new Group("Group 05", 20),
                    new Group("Group 06", 15),
                    new Group("Group 07", 21),
                    new Group("Group 08", 30),
                    new Group("Group 09", 20),
                    new Group("Group 10", 15),
                    new Group("Group 11", 20),
                    new Group("Group 12", 17),
                    new Group("Group 13", 23)
            );
        }
    }

    private void fillTeacher() {
        if (teacherDao.count() == 0) {
            teacherDao.insert(
                    new Teacher("Герич М.С."),
                    new Teacher("Баранник В.Ф."),
                    new Teacher("Чупов С.В."),
                    new Teacher("Андрашко Ю.В"),
                    new Teacher("Брила А.Ю."),
                    new Teacher("Маринець В.В."),
                    new Teacher("Глебена М.І."),
                    new Teacher("Рейтій О.К."),
                    new Teacher("Мулеса П.П."),
                    new Teacher("Млавець Ю.Ю."),
                    new Teacher("Рего В.Л."),
                    new Teacher("Міщанин В.В."),
                    new Teacher("Шаркаді М.М."),
                    new Teacher("Погоріляк О.О."),
                    new Teacher("Гусак Д.В."),
                    new Teacher("Поляк І.Й."),
                    new Teacher("Гапак Т.С."),
                    new Teacher("Маляр М.М."),
                    new Teacher("Мулеса О.Ю."),
                    new Teacher("Бортош М.Ю.")
            );
        }
    }

    private void fillSubject() {
        if (subjectDao.count() == 0) {
            subjectDao.insert(
                    new Subject("Українська мова"),
                    new Subject("Українська література"),
                    new Subject("Історпія України"),
                    new Subject("Алгебра"),
                    new Subject("Англійська мова"),
                    new Subject("Технології"),
                    new Subject("Інформатика"),
                    new Subject("Французька мова"),
                    new Subject("Математичний аналіз"),
                    new Subject("Дискретна математика"),
                    new Subject("Економіка"),
                    new Subject("Фізична культура "),
                    new Subject("Людина і світ"),
                    new Subject("Геометрія"),
                    new Subject("Облік і оподаткування"),
                    new Subject("Психологія"),
                    new Subject("Прикладна механіка"),
                    new Subject("Інформатика та програмування"),
                    new Subject("Лінійна алгебра"),
                    new Subject("Методи обчислень"),
                    new Subject("Аналіз даних"),
                    new Subject("Топологія"),
                    new Subject("Теоретична механіка"),
                    new Subject("Психологія"),
                    new Subject("Диференціальні рівняння"),
                    new Subject("Теорія ймовірностей"),
                    new Subject("Методи обчислень"),
                    new Subject("Комп'ютерні мережі")
            );
        }
    }

    private void fillTimeslot() {
        if (timeslotDao.count() == 0) {
            timeslotDao.insert(
                    new Timeslot(DateUtil.toDate("2017-05-01 08:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-01 09:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-01 10:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-01 11:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-01 12:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-01 13:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-01 14:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-01 15:30",DateUtil.PATTERN_SERVER_DATE)),

                    new Timeslot(DateUtil.toDate("2017-05-02 08:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-02 09:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-02 10:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-02 11:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-02 12:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-02 13:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-02 14:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-02 15:30",DateUtil.PATTERN_SERVER_DATE)),

                    new Timeslot(DateUtil.toDate("2017-05-03 08:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-03 09:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-03 10:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-03 11:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-03 12:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-03 13:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-03 14:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-03 15:30",DateUtil.PATTERN_SERVER_DATE)),

                    new Timeslot(DateUtil.toDate("2017-05-04 08:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-04 09:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-04 10:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-04 11:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-04 12:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-04 13:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-04 14:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-04 15:30",DateUtil.PATTERN_SERVER_DATE)),

                    new Timeslot(DateUtil.toDate("2017-05-05 08:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-05 09:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-05 10:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-05 11:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-05 12:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-05 13:30",DateUtil.PATTERN_SERVER_DATE)),
                    new Timeslot(DateUtil.toDate("2017-05-05 14:00",DateUtil.PATTERN_SERVER_DATE), DateUtil.toDate("2017-05-05 15:30",DateUtil.PATTERN_SERVER_DATE))
            );
        }
    }


}
