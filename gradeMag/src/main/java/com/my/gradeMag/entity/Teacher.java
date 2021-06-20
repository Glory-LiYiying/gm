package com.my.gradeMag.entity;

public class Teacher {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String tel;
    private String academy;
    private String classId;
    private Integer studentNum;
    private Integer courseId;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String sex, String tel, String academy, Integer courseId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.academy = academy;
        this.courseId = courseId;
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
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", academy='" + academy + '\'' +
                ", classId='" + classId + '\'' +
                ", studentNum=" + studentNum +
                ", courseId=" + courseId +
                '}';
    }
}