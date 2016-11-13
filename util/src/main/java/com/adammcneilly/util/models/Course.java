package com.adammcneilly.util.models;

import android.os.Parcel;

import com.adammcneilly.util.base.BaseModel;

/**
 * Represents a Course a user can play a game of golf on.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class Course extends BaseModel {
    /**
     * The holes that can be played on this course. Cannot be anything other than 9 or 18.
     */
    private HoleBase[] holes;

    /**
     * The name of the course.
     */
    private String name;

    public static Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel parcel) {
            return new Course(parcel);
        }

        @Override
        public Course[] newArray(int i) {
            return new Course[i];
        }
    };

    public Course(Parcel parcel) {
        this.name = parcel.readString();
        this.holes = parcel.createTypedArray(Hole.CREATOR);
    }

    public Course(String name, HoleBase[] holes) {
        this.name = name;
        this.holes = holes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHole(HoleBase[] holes) {
        if(holes.length != 9 && holes.length != 18) {
            throw new IllegalArgumentException("Invalid number of holes.");
        }

        this.holes = holes;
    }

    public HoleBase[] getHoles() {
        return holes;
    }

    public String getName() {
        return name;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeTypedArray(getHoles(), i);
    }
}
