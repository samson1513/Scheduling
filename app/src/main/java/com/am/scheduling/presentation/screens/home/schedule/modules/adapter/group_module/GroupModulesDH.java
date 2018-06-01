package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.group_module;

import android.os.Parcel;
import android.os.Parcelable;

import com.am.scheduling.data.database.models.Group;
import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.data.database.models.Teacher;
import com.am.scheduling.presentation.abc.core.list.pager.PagerDH;
import com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module.ModuleDH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Michenko
 * on 01.06.2018.
 */
public class GroupModulesDH implements PagerDH, Parcelable {
    @Override
    public int getViewType() {
        return 0;
    }

    public Group group;
    public List<ModuleDH> moduleDHS;

    public ModuleDH currentModule;
    public boolean error;

    public GroupModulesDH(Group group) {
        this.group = group;
        moduleDHS = new ArrayList<>();
        currentModule = new ModuleDH();
    }

    public void setTeacher(Teacher teacher) {
        currentModule.teacher = teacher;
    }

    public void setSubject(Subject subject) {
        currentModule.subject = subject;
    }

    public void setCount(int count) {
        currentModule.count = count;
    }

    public void addModule() {
        if (currentModule.subject == null ||
                currentModule.teacher == null ||
                currentModule.count == 0) {
            error = true;
        } else {
            error = false;
            moduleDHS.add(currentModule);
            currentModule = new ModuleDH();
        }
    }

    public String getCurrentTeacher() {
        return currentModule.teacher == null ? null : currentModule.teacher.fullName;
    }

    public String getCurrentSubject() {
        return currentModule.subject == null ? null : currentModule.subject.name;
    }

    public String getCurrentCount() {
        return String.valueOf(currentModule.count);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.group, flags);
        dest.writeTypedList(this.moduleDHS);
        dest.writeParcelable(this.currentModule, flags);
        dest.writeByte(this.error ? (byte) 1 : (byte) 0);
    }

    protected GroupModulesDH(Parcel in) {
        this.group = in.readParcelable(Group.class.getClassLoader());
        this.moduleDHS = in.createTypedArrayList(ModuleDH.CREATOR);
        this.currentModule = in.readParcelable(ModuleDH.class.getClassLoader());
        this.error = in.readByte() != 0;
    }

    public static final Parcelable.Creator<GroupModulesDH> CREATOR = new Parcelable.Creator<GroupModulesDH>() {
        @Override
        public GroupModulesDH createFromParcel(Parcel source) {
            return new GroupModulesDH(source);
        }

        @Override
        public GroupModulesDH[] newArray(int size) {
            return new GroupModulesDH[size];
        }
    };
}
