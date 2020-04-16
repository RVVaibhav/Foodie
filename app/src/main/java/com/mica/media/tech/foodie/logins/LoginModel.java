package com.mica.media.tech.foodie.logins;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mica.media.tech.foodie.BR;


public class LoginModel  extends BaseObservable implements Parcelable {

    public String userName;
    public String password;
    public String userNameError;
    public String passwordError;
    public static  String Empty_USERNAME = "mobile number is empty ";
    public static  String Empty_PASSWORD = "password is empty ";
    public static  String INVALID_USERNAME = "please enter valid mobile number";
    public static  String INVALID_PASSWORD = "please enter valid password";

    protected LoginModel(Parcel in) {
        userName = in.readString();
        password = in.readString();
        userNameError = in.readString();
        passwordError = in.readString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
        notifyPropertyChanged(BR.userNameError);
    }

    @Bindable
    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
        notifyPropertyChanged(BR.passwordError);
    }

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    public LoginModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        boolean isValid = true;
        if (!TextUtils.isEmpty(userName) && userName.length() < 10) {
            Empty_USERNAME=INVALID_USERNAME;
            setUserNameError(Empty_USERNAME);
            isValid = false;
        }  if (TextUtils.isEmpty(userName)) {
            setUserNameError(Empty_USERNAME);
            isValid = false;
        }  if (TextUtils.isEmpty(password)) {
            setPasswordError(Empty_PASSWORD);
            isValid = false;
        }  if (!TextUtils.isEmpty(password) && password.length()<6) {
            Empty_PASSWORD=INVALID_PASSWORD;
            setPasswordError(Empty_PASSWORD);
            isValid = false;
        }
        return isValid;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(password);
        parcel.writeString(userNameError);
        parcel.writeString(passwordError);
    }
}
