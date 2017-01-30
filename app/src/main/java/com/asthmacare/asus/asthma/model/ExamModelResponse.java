package com.asthmacare.asus.asthma.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 20.11.2016.
 */

public class ExamModelResponse implements Parcelable {
    @SerializedName("code")
    String code;
    @SerializedName("message")
    String message;
    @SerializedName("result")
    String rusult;
    @SerializedName("id")
    String id;
    @SerializedName("percent")
    String percent;
    @SerializedName("cathegory")
    String cathegory;

    protected ExamModelResponse(Parcel in) {
        code = in.readString();
        message = in.readString();
        rusult = in.readString();
        id = in.readString();
        percent = in.readString();
        cathegory = in.readString();
    }

    public static final Creator<ExamModelResponse> CREATOR = new Creator<ExamModelResponse>() {
        @Override
        public ExamModelResponse createFromParcel(Parcel in) {
            return new ExamModelResponse(in);
        }

        @Override
        public ExamModelResponse[] newArray(int size) {
            return new ExamModelResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(code);
        parcel.writeString(message);
        parcel.writeString(rusult);
        parcel.writeString(id);
        parcel.writeString(percent);
        parcel.writeString(cathegory);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRusult() {
        return rusult;
    }

    public void setRusult(String rusult) {
        this.rusult = rusult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
