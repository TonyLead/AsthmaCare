package com.asthmacare.asus.asthma.model.Results;




import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Tony on 10.01.2017.
 */

public class AllResultResponse implements Parcelable {
    @SerializedName("id")
    String id;
    @SerializedName("results")
    private ArrayList<Result> results = new ArrayList<>();


    protected AllResultResponse(Parcel in) {
        id = in.readString();
        results = in.createTypedArrayList(Result.CREATOR);
    }

    public static final Creator<AllResultResponse> CREATOR = new Creator<AllResultResponse>() {
        @Override
        public AllResultResponse createFromParcel(Parcel in) {
            return new AllResultResponse(in);
        }

        @Override
        public AllResultResponse[] newArray(int size) {
            return new AllResultResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeTypedList(results);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}


