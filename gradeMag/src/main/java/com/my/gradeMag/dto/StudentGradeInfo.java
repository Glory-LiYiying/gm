package com.my.gradeMag.dto;

public class StudentGradeInfo {
    private Integer id;    //学号
    private String name;   //姓名
    private String courseName;   //课程名
    private Integer grade;   //成绩

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentGradeInfo{" +
                "name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
