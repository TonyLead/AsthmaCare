package com.asthmacare.asus.asthma.model.Results;




import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tony on 10.01.2017.
 */

public class Result implements Parcelable {
    @SerializedName("percent")
    private String percent;
    @SerializedName("cathegory")
    private String cathegory;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;

    protected Result(Parcel in) {
        percent = in.readString();
        cathegory = in.readString();
        date = in.readString();
        time = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(percent);
        dest.writeString(cathegory);
        dest.writeString(date);
        dest.writeString(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public String getPercent() {
        return percent;
    }

    public String getCathegory() {
        return cathegory;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
