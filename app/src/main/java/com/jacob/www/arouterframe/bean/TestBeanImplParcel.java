package com.jacob.www.arouterframe.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author JacobYu
 * @classDescription:
 * @createTime 2018/7/25
 */
public class TestBeanImplParcel implements Parcelable {

    public String data;

    public TestBeanImplParcel(String data){
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data);
    }

    protected TestBeanImplParcel(Parcel in) {
        this.data = in.readString();
    }

    public static final Parcelable.Creator<TestBeanImplParcel> CREATOR = new Parcelable.Creator<TestBeanImplParcel>() {
        @Override
        public TestBeanImplParcel createFromParcel(Parcel source) {
            return new TestBeanImplParcel(source);
        }

        @Override
        public TestBeanImplParcel[] newArray(int size) {
            return new TestBeanImplParcel[size];
        }
    };
}
