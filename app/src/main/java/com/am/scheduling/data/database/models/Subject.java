package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex Michenko
 * on 03.03.2018.
 */

@Entity(tableName = "subjects")
public class Subject implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;

    public Subject() {
    }

    @Ignore
    public Subject(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    @Ignore
    protected Subject(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Subject> CREATOR = new Parcelable.Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel source) {
            return new Subject(source);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };
}
