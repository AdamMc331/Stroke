package com.adammcneilly.util.base;

import android.os.Parcelable;

/**
 * Base for all models.
 *
 * Created by adam.mcneilly on 11/13/16.
 */
public abstract class BaseModel implements Parcelable{
    @Override
    public int describeContents() {
        return 0;
    }
}
