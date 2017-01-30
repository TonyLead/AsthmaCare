package com.asthmacare.asus.asthma.model.registrationmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus on 19.11.2016.
 */

public class AddUserResponse implements Parcelable {
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;
    @SerializedName("id")
    private String Id;

    protected AddUserResponse(Parcel in) {
        message = in.readString();
        code = in.readString();
        Id = in.readString();
    }

    public static final Creator<AddUserResponse> CREATOR = new Creator<AddUserResponse>() {
        @Override
        public AddUserResponse createFromParcel(Parcel in) {
            return new AddUserResponse(in);
        }

        @Override
        public AddUserResponse[] newArray(int size) {
            return new AddUserResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeString(code);
        parcel.writeString(Id);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
