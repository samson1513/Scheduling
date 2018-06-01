package com.am.scheduling.data.database.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex Michenko
 * on 02.03.2018.
 */

@Entity(tableName = "teachers")
public class Teacher implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "full_name")
    public String fullName;

    public Teacher() {
    }

    @Ignore
    public Teacher(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.fullName);
    }

    @Ignore
    protected Teacher(Parcel in) {
        this.id = in.readInt();
        this.fullName = in.readString();
    }

    public static final Parcelable.Creator<Teacher> CREATOR = new Parcelable.Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel source) {
            return new Teacher(source);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
        }
    };
}
