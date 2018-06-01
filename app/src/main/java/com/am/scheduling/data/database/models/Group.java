package com.am.scheduling.data.database.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alex Michenko
 * on 01.03.2018.
 */

@Entity(tableName = "groups")
public class Group implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int size;

    public Group() {
    }

    @Ignore
    public Group(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.size);
    }

    @Ignore
    protected Group(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.size = in.readInt();
    }

    public static final Parcelable.Creator<Group> CREATOR = new Parcelable.Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel source) {
            return new Group(source);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };
}
