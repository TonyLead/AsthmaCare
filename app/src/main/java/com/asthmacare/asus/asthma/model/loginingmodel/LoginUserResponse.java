package com.asthmacare.asus.asthma.model.loginingmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;



public class LoginUserResponse implements Parcelable {
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;
    @SerializedName("result")
    private String result;
    @SerializedName("id")
    private String id;

    protected LoginUserResponse(Parcel in) {
        message = in.readString();
        code = in.readString();
        result = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(code);
        dest.writeString(result);
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginUserResponse> CREATOR = new Creator<LoginUserResponse>() {
        @Override
        public LoginUserResponse createFromParcel(Parcel in) {
            return new LoginUserResponse(in);
        }

        @Override
        public LoginUserResponse[] newArray(int size) {
            return new LoginUserResponse[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String  result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}



