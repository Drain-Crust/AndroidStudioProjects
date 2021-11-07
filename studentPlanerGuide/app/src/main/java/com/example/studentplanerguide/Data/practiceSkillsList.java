package com.example.studentplanerguide.Data;

public class practiceSkillsList {

    private String mName;
    private String mIds;
    private String mLocation;
    private String mUrls;

    public practiceSkillsList() {
        //don't delete needed constructor
    }

    public practiceSkillsList(String name, String location, String ids,String urls) {
        this.mName = name;
        this.mIds = ids;
        this.mLocation = location;
        this.mUrls = urls;
    }

    public void setmUrls(String mUrls) {
        this.mUrls = mUrls;
    }

    public String getmUrls() {
        return mUrls;
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

    @Override
    public String toString() {
        return "practiceSkillsList{" +
                "mName='" + mName + '\'' +
                ", mIds='" + mIds + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mUrls='" + mUrls + '\'' +
                '}';
    }
}
