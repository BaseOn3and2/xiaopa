package com.base.xiaopa.db;

import cn.bmob.v3.BmobUser;

/**
 * Created by Satellite Wu on 2017/11/12.
 */
public class User extends BmobUser {

    private  String college;  //院校
    private  String academy;  //学院
    private  String major;    //专业
    private  Boolean gender;  //0为女，1为男


    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
