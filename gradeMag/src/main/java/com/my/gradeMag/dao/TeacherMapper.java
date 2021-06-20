package com.my.gradeMag.dao;

import com.my.gradeMag.dto.StudentGradeInfo;
import com.my.gradeMag.dto.TeacherInfo;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface TeacherMapper {

    @Select("select name from teacher where id=#{id} and password=#{password}")
    String queryAcotAndPsw(@Param("id") Integer id,@Param("password") String password);

    @Select("select name,sex,tel,academy,classId,studentNum,courseId from teacher where id=#{teacherId}")
    Teacher queryTeacherInfo(@Param("teacherId") Integer teacherId);

    @Update("update teacher set name=#{name},sex=#{sex},tel=#{tel},academy=#{academy},classId=#{classId}," +
            "studentNum=#{studentNum},courseId=#{courseId} where id=#{id}")
    int updateTeacherInfo(Teacher teacher);

    @Update("update teacher set password=#{password} where id=#{teacherId}")
    int updateTeacherPsw(@Param("password") String password,@Param("teacherId") Integer teacherId);

    @Select("select count(*) from teacher where id=#{teacherId} and password=#{password}")
    int checkTeacherPsw(@Param("password") String password,@Param("teacherId") Integer teacherId);

    @Select("select s.id,s.name,s.sex,s.classId,s.tel from teacher as t " +
            "LEFT JOIN courseresult as cr on t.courseId=cr.courseId " +
            "LEFT JOIN student as s on cr.studentId=s.id " +
            "where t.id=#{teacherId}")
    List<Student> queryCourseStudentInfo(@Param("teacherId") Integer teacherId);


    @Select("select s.id,s.name,c.name as courseName,cr.grade from teacher as t " +
            "LEFT JOIN courseresult as cr on t.courseId=cr.courseId " +
            "LEFT JOIN student as s on cr.studentId=s.id " +
            "LEFT JOIN course as c on c.id=t.courseId " +
            "where t.id=#{teacherId} " +
            "ORDER BY cr.grade desc")
    List<StudentGradeInfo> queryCourseStudentGrade(@Param("teacherId") Integer teacherId);

    @Select("select s.id,s.name,c.name as courseName,cr.grade from teacher as t " +
            "LEFT JOIN courseresult as cr on t.courseId=cr.courseId " +
            "LEFT JOIN student as s on cr.studentId=s.id " +
            "LEFT JOIN course as c on c.id=t.courseId " +
            "where t.id=#{teacherId} and s.id=#{studentId} " +
            "ORDER BY cr.grade desc")
    List<StudentGradeInfo> querySpecialCourseStudentGrade(@Param("teacherId") Integer teacherId,@Param("studentId") Integer studentId);

    @Select("select t.id,t.name,t.sex,t.tel,t.academy,t.classId as className,c.name as courseName " +
            "from teacher as t " +
            "left join course as c on t.courseId=c.id")
    List<TeacherInfo> queryAllTeacherInfo();

    @Select("select t.id,t.name,t.sex,t.tel,t.academy,t.classId as className,c.name as courseName " +
            "from teacher as t " +
            "left join course as c on t.courseId=c.id " +
            "where t.id=#{teacherId}")
    List<TeacherInfo> queryTeacherInfoById(@Param("teacherId") Integer teacherId);

    @Select("select t.id,t.name,t.sex,t.tel,t.academy,t.classId as className,c.name as courseName " +
            "from teacher as t " +
            "left join course as c on t.courseId=c.id " +
            "where t.id=#{teacherId}")
    TeacherInfo queryOneTeacherInfoById(@Param("teacherId") Integer teacherId);

    @Update("update teacher set name=#{name},sex=#{sex},tel=#{tel},academy=#{academy},courseId=(" +
            "select id from course where name=#{courseName}) " +
            "where id=#{id}")
    int updateTeacherBasicInfo(TeacherInfo teacherInfo);

    @Select("select count(*) from teacher where id=#{teacherId}")
    int queryTeacherIdExist(@Param("teacherId") Integer teacherId);

    @Insert("insert into teacher(id,name,sex,tel,academy,courseId) values(#{id},#{name},#{sex},#{tel},#{academy},#{courseId})")
    int insertTeacher(Teacher teacher);

    @Delete("delete from teacher where id=#{teacherId}")
    int deleteTeacher(@Param("teacherId") Integer teacherId);
}