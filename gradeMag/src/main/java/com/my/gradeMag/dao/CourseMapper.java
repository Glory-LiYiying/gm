package com.my.gradeMag.dao;

import com.my.gradeMag.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CourseMapper {

    @Select("select count(*) from course where name=#{courseName}")
    int checkExist(@Param("courseName") String courseName);

    @Select("select id from course where name=#{courseName}")
    Integer queryCourseIdByName(@Param("courseName") String courseName);

    @Select("select id,name from course")
    List<Course> queryAll();

    @Select("select id,name from course where id=#{courseId}")
    Course queryCourseById(@Param("courseId") Integer courseId);

    @Insert("insert into course(id,name) values(#{id},#{name})")
    int insertCourse(Course course);

    @Update("update course set name=#{name} where id=#{id}")
    int updateCourseInfo(Course course);

    @Select("select count(*) from course where id=#{courseId}")
    int checkCourseIdExist(@Param("courseId") Integer courseId);

    @Delete("delete from course where id=#{courseId}")
    int deleteCourse(@Param("courseId") Integer courseId);
}