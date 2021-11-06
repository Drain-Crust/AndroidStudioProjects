package com.example.studentplanerguide.Data;

public class tasksList {
    private String mName;
    private String mColor;
    private String mIds;

    public tasksList(){
        //needed dont delete
    }

    public tasksList(String name, String color, String ids){
        this.mName = name;
        this.mColor = color;
        this.mIds = ids;
    }

    public String getmIds(){
        return mIds;
    }

    public void setmIds(String ids){
        mIds = ids;
    }

    public String getmName(){
        return mName;
    }

    public void setmName(String name){
        mName = name;
    }

    public String getmColor(){
        return mColor;
    }

    public void setmColor(String color){
        mColor = color;
    }

    public String toString(){
        return "tasksList{" + '\'' +
                "Name='" + mName + '\'' +
                "color='" + mColor + '\''+
                "ids='" + mIds + '}';
    }
}
