package com.example.studentplanerguide.Data;

public class subjectList {

    private String mIds;
    private String mImageUrl;
    private String mNames;

    public subjectList(){
        //don't delete needed constructor
    }

    public subjectList(String ids, String names, String imageUrl){
        this.mIds = ids;
        this.mNames = names;
        this.mImageUrl = imageUrl;
    }

    public String getName(){
        return mNames;
    }

    public void setName(String name){
        mNames = name;
    }

    public String getIds(){
        return mIds;
    }

    public void setIds(String ids){
        mIds = ids;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }

    public String toString(){
        return "SubjectsList{"+
                "Ids='" + mIds + '\'' +
                "Names='" + mNames + '\'' +
                ", ImageUrl='"+ mImageUrl + '}';
    }
}
