package com.am.scheduling.presentation.screens.home.schedule.modules.adapter.module;

import android.os.Parcel;
import android.os.Parcelable;

import com.am.scheduling.data.database.models.Subject;
import com.am.scheduling.data.database.models.Teacher;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Alex Michenko
 * on 31.05.2018.
 */
public class ModuleDH implements MultiItemEntity, Parcelable {
    @Override
    public int getItemType() {
        return 0;
    }

    public Teacher teacher;
    public Subject subject;
    public int count;

    public ModuleDH() {
        count = 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.teacher, flags);
        dest.writeParcelable(this.subject, flags);
        dest.writeInt(this.count);
    }

    protected ModuleDH(Parcel in) {
        this.teacher = in.readParcelable(Teacher.class.getClassLoader());
        this.subject = in.readParcelable(Subject.class.getClassLoader());
        this.count = in.readInt();
    }

    public static final Parcelable.Creator<ModuleDH> CREATOR = new Parcelable.Creator<ModuleDH>() {
        @Override
        public ModuleDH createFromParcel(Parcel source) {
            return new ModuleDH(source);
        }

        @Override
        public ModuleDH[] newArray(int size) {
            return new ModuleDH[size];
        }
    };
}
