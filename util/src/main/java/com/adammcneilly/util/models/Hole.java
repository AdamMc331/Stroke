package com.adammcneilly.util.models;

import android.os.Parcel;

import com.adammcneilly.util.base.BaseModel;

/**
 * Represents a hole that the user can play.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class Hole extends HoleBase {

    /**
     * The number of strokes the user took to complete this hole.
     */
    private int score;

    /**
     * Creator that converts a parcel to a Hole object.
     */
    public static Creator<Hole> CREATOR = new Creator<Hole>() {
        @Override
        public Hole createFromParcel(Parcel parcel) {
            return new Hole(parcel);
        }

        @Override
        public Hole[] newArray(int i) {
            return new Hole[i];
        }
    };

    public Hole(HoleBase base) {
        super(base);
    }

    /**
     * Creates a hole from a parcel.
     */
    public Hole(Parcel parcel) {
        super(parcel);
        setScore(parcel.readInt());
    }

    /**
     * Sets the number of strokes required to complete this hole.
     * @param score The number of strokes taken. Cannot be less than 1.
     */
    public void setScore(int score) {
        if(score < 1) {
            throw new IllegalArgumentException("Invalid hole score.");
        }

        this.score = score;
    }

    /**
     * @return the number of strokes required for this hole.
     */
    public int getScore() {
        return score;
    }

    /**
     * Determines the value of this hole based on par.
     */
    public int getValue() {
        return score - getPar();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getScore());
    }
}
