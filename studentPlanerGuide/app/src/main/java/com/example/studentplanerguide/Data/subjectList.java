package com.example.studentplanerguide.Data;

public class subjectList {

    private String mName;
    private String mImageUrl;

    public subjectList(){
        //don't delete needed constructor
    }

    public subjectList(String name, String imageUrl){
        this.mName = name;
        this.mImageUrl = imageUrl;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }

    public String toString(){
        return "SubjectsList{"+
                "Name='" + mName + '\'' +
                ", ImageUrl='"+ mImageUrl + '}';
    }
}
