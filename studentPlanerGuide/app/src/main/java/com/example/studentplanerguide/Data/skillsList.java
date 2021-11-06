package com.example.studentplanerguide.Data;

public class skillsList {

    private String mName;
    private String mIds;
    private String mLocation;

    public skillsList() {
        //don't delete needed constructor
    }

    public skillsList(String name, String location, String ids) {
        this.mName = name;
        this.mIds = ids;
        this.mLocation = location;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String location) {
        mLocation = location;
    }

    public String getmIds() {
        return mIds;
    }

    public void setmIds(String ids) {
        mIds = ids;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public String toString() {
        return "SkillsList{" + '\'' +
                "Name='" + mName + '\'' +
                "location='" + mLocation + '\'' +
                "ids='" + mIds + '}';
    }
}
