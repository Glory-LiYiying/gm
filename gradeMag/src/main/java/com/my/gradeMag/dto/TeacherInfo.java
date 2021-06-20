package com.my.gradeMag.dto;

public class TeacherInfo {
    private Integer id;
    private String name;
    private String sex;
    private String tel;
    private String academy;
    private String className;
    private String courseName;

    public TeacherInfo() {
    }

    public TeacherInfo(Integer id, String name, String sex, String tel, String academy, String courseName) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.academy = academy;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
