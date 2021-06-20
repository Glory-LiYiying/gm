package com.my.gradeMag.entity;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String password;
    private String classId;
    private String sex;
    private String tel;

    public Student() {
    }

    public Student(Integer id, String name, String password, String classId, String sex, String tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.classId = classId;
        this.sex = sex;
        this.tel = tel;
    }

    public Student(Integer id, String name, String classId, String sex, String tel) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.sex = sex;
        this.tel = tel;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", classId=" + classId +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}