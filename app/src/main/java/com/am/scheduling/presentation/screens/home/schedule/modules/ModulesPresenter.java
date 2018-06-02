package com.am.scheduling.presentation.screens.home.schedule.modules;

import android.util.SparseArray;

import com.am.scheduling.chapter5.Timetable;
import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.presentation.abc.core.base.BasePresenterImpl;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module.GroupModulesDH;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module.ModuleDH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.reactivex.Observable;

public class ModulesPresenter extends BasePresenterImpl<ModulesContract.View> implements ModulesContract.Presenter {

    private ModulesContract.Model model;
    private ArrayList<GroupModulesDH> groupModules;
    private SparseArray<SetWrap> subjTeachersId;

    public ModulesPresenter(ModulesContract.View view, ModulesContract.Model model, ArrayList<Group> groups) {
        super(view);
        this.model = model;
        this.groupModules = new ArrayList<>(Observable.fromIterable(groups)
                .map(GroupModulesDH::new)
                .toList()
                .blockingGet());

        subjTeachersId = new SparseArray<>();
        addDisposable(model.subjectListCase.async()
                .flatMapObservable(Observable::fromIterable)
                .subscribe(subject -> subjTeachersId.put(subject.id, new SetWrap())));
    }

    @Override
    public void subscribe() {
        getView().setTabs(groupModules);
    }

    @Override
    public void next(GroupModulesDH dh, int position) {
        if (dh.moduleDHS.isEmpty()) {
            getView().showMessage("Need module(s)");
        } else if (position < groupModules.size() - 1) {
            groupModules.set(position, dh);
            getView().selectTab(position + 1);
        } else {
            getView().startGeneratorScreen(prepareTimetable());
        }
    }

    private Timetable prepareTimetable() {
        Timetable timetable = new Timetable();

        obtainSubjects();

        for (GroupModulesDH dh : groupModules) {
            IntWrap moduleIds = new IntWrap();
            for (ModuleDH moduleDH : dh.moduleDHS){
                timetable.addProfessor(moduleDH.teacher.id, moduleDH.teacher.fullName);

                timetable.addModule(moduleDH.subject.id, moduleDH.subject.name, subjTeachersId.get(moduleDH.subject.id).get());

                for (int i = 0; i < moduleDH.count; i++) {
                    moduleIds.add(moduleDH.subject.id);
                }
            }
            timetable.addGroup(dh.group.id, dh.group.size, moduleIds.get());
        }
        return timetable;
    }


    private void obtainSubjects() {
        for (GroupModulesDH dh : groupModules) {
            for (ModuleDH moduleDH : dh.moduleDHS) {
                subjTeachersId.get(moduleDH.subject.id).add(moduleDH.teacher.id);
            }
        }
    }

    class IntWrap {
        List<Integer> ids;

        IntWrap() {
            ids = new ArrayList<>();
        }

        public int[] get() {
            int[] res = new int[ids.size()];
            for (int i = 0; i < ids.size(); i++) {
                res[i] = ids.get(i);
            }
            return res;
        }

        public void add(int value) {
            ids.add(value);
        }
    }

    class SetWrap {
        Set<Integer> ids;

        SetWrap() {
            ids = new HashSet<>();
        }

        public int[] get() {
            int[] res = new int[ids.size()];
            Iterator<Integer> iterator = ids.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                res[i] = iterator.next();
                ++i;
            }
            return res;
        }

        public void add(int value) {
            ids.add(value);
        }
    }
}