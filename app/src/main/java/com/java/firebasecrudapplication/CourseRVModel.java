package com.java.firebasecrudapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseRVModel implements Parcelable {
    private String courseName;
    private String courseDescription;
    private String coursePrice;
    private String bestSuitedFor;
    private String courseImg;
    private  String  courseID;

    public CourseRVModel(){

    }


    public CourseRVModel(String courseName, String courseDescription, String coursePrice, String bestSuitedFor, String courseImg, String courseID) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.coursePrice = coursePrice;
        this.bestSuitedFor = bestSuitedFor;
        this.courseImg = courseImg;
        this.courseID = courseID;
    }


    protected CourseRVModel(Parcel in) {
        courseName = in.readString();
        courseDescription = in.readString();
        coursePrice = in.readString();
        bestSuitedFor = in.readString();
        courseImg = in.readString();
        courseID = in.readString();
    }

    public static final Creator<CourseRVModel> CREATOR = new Creator<CourseRVModel>() {
        @Override
        public CourseRVModel createFromParcel(Parcel in) {
            return new CourseRVModel(in);
        }

        @Override
        public CourseRVModel[] newArray(int size) {
            return new CourseRVModel[size];
        }
    };

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getBestSuitedFor() {
        return bestSuitedFor;
    }

    public void setBestSuitedFor(String bestSuitedFor) {
        this.bestSuitedFor = bestSuitedFor;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(courseName);
        parcel.writeString(courseDescription);
        parcel.writeString(coursePrice);
        parcel.writeString(bestSuitedFor);
        parcel.writeString(courseImg);
        parcel.writeString(courseID);
    }
}