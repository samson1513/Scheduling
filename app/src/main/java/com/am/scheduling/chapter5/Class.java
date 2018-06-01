package com.am.scheduling.chapter5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A simple class abstraction -- basically a container for class, group, module, professor, timeslot, and room IDs
 */
public class Class implements Parcelable {
    private final int classId;
    private final int groupId;
    private final int moduleId;
    private int professorId;
    private int timeslotId;
    private int roomId;
    
    /**
     * Initialize new Class
     * 
     * @param classId
     * @param groupId
     * @param moduleId
     */
    public Class(int classId, int groupId, int moduleId){
        this.classId = classId;
        this.moduleId = moduleId;
        this.groupId = groupId;
    }
    
    /**
     * Add professor to class
     * 
     * @param professorId
     */
    public void addProfessor(int professorId){
        this.professorId = professorId;
    }
    
    /**
     * Add timeslot to class
     * 
     * @param timeslotId
     */
    public void addTimeslot(int timeslotId){
        this.timeslotId = timeslotId;
    }    
    
    /**
     * Add room to class
     * 
     * @param roomId
     */
    public void setRoomId(int roomId){
        this.roomId = roomId;
    }
    
    /**
     * Get classId
     * 
     * @return classId
     */
    public int getClassId(){
        return this.classId;
    }
    
    /**
     * Get groupId
     * 
     * @return groupId
     */
    public int getGroupId(){
        return this.groupId;
    }
    
    /**
     * Get moduleId
     * 
     * @return moduleId
     */
    public int getModuleId(){
        return this.moduleId;
    }
    
    /**
     * Get professorId
     * 
     * @return professorId
     */
    public int getProfessorId(){
        return this.professorId;
    }
    
    /**
     * Get timeslotId
     * 
     * @return timeslotId
     */
    public int getTimeslotId(){
        return this.timeslotId;
    }
    
    /**
     * Get roomId
     * 
     * @return roomId
     */
    public int getRoomId(){
        return this.roomId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.classId);
        dest.writeInt(this.groupId);
        dest.writeInt(this.moduleId);
        dest.writeInt(this.professorId);
        dest.writeInt(this.timeslotId);
        dest.writeInt(this.roomId);
    }

    protected Class(Parcel in) {
        this.classId = in.readInt();
        this.groupId = in.readInt();
        this.moduleId = in.readInt();
        this.professorId = in.readInt();
        this.timeslotId = in.readInt();
        this.roomId = in.readInt();
    }

    public static final Parcelable.Creator<Class> CREATOR = new Parcelable.Creator<Class>() {
        @Override
        public Class createFromParcel(Parcel source) {
            return new Class(source);
        }

        @Override
        public Class[] newArray(int size) {
            return new Class[size];
        }
    };
}

