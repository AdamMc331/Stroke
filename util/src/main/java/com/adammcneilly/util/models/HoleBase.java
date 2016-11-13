package com.adammcneilly.util.models;

import android.os.Parcel;

import com.adammcneilly.util.base.BaseModel;

/**
 * Base class for a Hole that contains number and par, but not score.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public class HoleBase extends BaseModel {
    /**
     * The number of the hole on the course - between 1 and 18.
     */
    private int number;

    /**
     * The number of strokes expected to complete this hole.
     */
    private int par;

    public static Creator<HoleBase> CREATOR = new Creator<HoleBase>() {
        @Override
        public HoleBase createFromParcel(Parcel parcel) {
            return new HoleBase(parcel);
        }

        @Override
        public HoleBase[] newArray(int i) {
            return new HoleBase[i];
        }
    };

    public HoleBase(int number, int par) {
        setNumber(number);
        setPar(par);
    }

    public HoleBase(HoleBase base) {
        setNumber(base.getNumber());
        setPar(base.getPar());
    }

    /**
     * Creates a HoleBase object from a parcel.
     */
    public HoleBase(Parcel parcel) {
        setNumber(parcel.readInt());
        setPar(parcel.readInt());
    }

    /**
     * Sets the number of this hole.
     * @param number The number of the hole on the course, must be between 1 and 18 (inclusive).
     */
    public void setNumber(int number) {
        if(number < 1 || number > 18) {
            throw new IllegalArgumentException("Invalid hole number.");
        }

        this.number = number;
    }

    /**
     * Sets the par of this hole.
     * @param par The number of strokes expected to complete this hole. Between 3 and 5.
     */
    public void setPar(int par) {
        if(par < 3 || par > 5) {
            throw new IllegalArgumentException("Invalid hole par.");
        }

        this.par = par;
    }

    /**
     * @return the number for this hole.
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the number of stroke expected to complete this hole.
     */
    public int getPar() {
        return par;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getNumber());
        parcel.writeInt(getPar());
    }

    public static HoleBase[] getTestHoles(int count, int par) {
        HoleBase[] holes = new HoleBase[count];

        for(int i = 0; i < count; i++) {
            holes[i] = new HoleBase(i + 1, par);
        }

        return holes;
    }
}
