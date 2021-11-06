package com.example.studentplanerguide.Data;

public class skillsList {

    private String mName;
    private String mIds;

    public skillsList() {
        //don't delete needed constructor
    }

    public skillsList(String name, String ids) {
        this.mName = name;
        this.mIds = ids;
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
                "ids='" + mIds + '}';
    }
}
