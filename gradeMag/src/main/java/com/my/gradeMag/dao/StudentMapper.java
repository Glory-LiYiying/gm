package com.my.gradeMag.dao;

import com.my.gradeMag.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface StudentMapper {

    @Select("select name from student where id=#{id} and password=#{password}")
    String queryAcotAndPsw(@Param("id") Integer id, @Param("password") String password);

    @Insert("insert into student(id,name,classId,sex,tel) values(#{id},#{name},#{classId},#{sex},#{tel})")
    int insertStudent(Student student);

    @Select("select name,password,classId,sex,tel from student where id=#{id}")
    Student queryStudentInfo(@Param("id") Integer id);

    @Update("update student set name=#{name},classId=#{classId},sex=#{sex},tel=#{tel} where id=#{id}")
    int updateStudentInfo(Student student);

    @Update("update student set password=#{password} where id=#{id}")
    int updateStudentPsw(@Param("id") Integer id, @Param("password") String password);

    @Select("select count(*) from student where id=#{id} and password=#{password}")
    int checkStudentPsw(@Param("id") Integer id, @Param("password") String password);

    @Select("select s.id,s.name,s.sex,s.tel,s.classId from student as s " +
            "LEFT JOIN teacher as t on s.classId=t.classId " +
            "where t.id=#{teacherId}")
    List<Student> queryStudentInfosByTeacherId(@Param("teacherId") Integer teacherId);

    @Select("select id,name,sex,tel,classId from student where name=#{name}")
    List<Student> queryStudentInfosByName(@Param("name") String name);

    @Select("select id,name,sex,classId,tel from student")
    List<Student> queryAll();

    @Select("select id,name,sex,classId,tel from student where id=#{studentId}")
    List<Student> queryStudentInfoById(@Param("studentId") Integer studentId);

    @Select("select count(*) from student where id=#{id}")
    int queryStudentIdExist(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteStudent(Student student);
}