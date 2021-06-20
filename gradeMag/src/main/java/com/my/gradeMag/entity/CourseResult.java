package com.my.gradeMag.entity;

public class CourseResult {
    private Integer studentId;

    private Integer courseId;

    private Integer grade;

    public CourseResult() {
    }

    public CourseResult(Integer studentId, Integer courseId, Integer grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}