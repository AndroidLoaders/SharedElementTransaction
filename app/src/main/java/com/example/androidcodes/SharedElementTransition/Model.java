package com.example.androidcodes.SharedElementTransition;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mehta on 4/23/2017.
 */

public class Model implements Parcelable {

    private String appName = "";

    private String companyName = "";

    public Model() {
    }

    protected Model(Parcel in) {

        readFromParcel(in);

    }

    public String getAppName() {

        return appName;

    }

    public void setAppName(String appName) {

        this.appName = appName;

    }

    public String getCompanyName() {

        return companyName;

    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;

    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {

        @Override
        public Model createFromParcel(Parcel in) {

            return new Model(in);

        }

        @Override
        public Model[] newArray(int size) {

            return new Model[size];

        }
    };

    @Override
    public int describeContents() {

        return 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(appName);
        dest.writeString(companyName);

    }

    private void readFromParcel(Parcel in) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        appName = in.readString();

        companyName = in.readString();

    }
}
