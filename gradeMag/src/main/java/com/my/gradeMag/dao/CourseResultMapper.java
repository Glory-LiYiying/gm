package com.my.gradeMag.dao;

import com.my.gradeMag.dto.StudentGradeInfo;
import com.my.gradeMag.entity.CourseResult;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface CourseResultMapper {

    @Insert("insert into courseresult(studentId,courseId,grade) values(#{studentId},#{courseId},#{grade})")
    int insertData(CourseResult courseResult);


    /**
     * 获取某学生的成绩信息
     * @param id
     * @return
     */
    @Select("select s.name as name,c.name as courseName,cr.grade as grade\n" +
            "FROM courseresult as cr,student as s,course as c\n" +
            "where cr.studentId=#{id} and cr.studentId=s.id and cr.courseId=c.id")
    List<StudentGradeInfo> queryStudentGrade(@Param("id") Integer id);


    /**
     * 获取某学生的成绩信息的数量
     * @param id
     * @return
     */
    @Select("select count(*) from courseresult where studentId=#{id}")
    int queryStudentGradeCount(@Param("id") Integer id);


    @Select("select cr.studentId as id,s.name as name,c.name as courseName,cr.grade " +
            "FROM courseresult as cr " +
            "LEFT JOIN student as s on s.id=cr.studentId " +
            "LEFT JOIN course as c on c.id=cr.courseId " +
            "LEFT JOIN teacher as t on t.classId=s.classId " +
            "where t.id=#{teacherId}")
    List<StudentGradeInfo> queryStudentGradesByTeacherId(@Param("teacherId") Integer teacherId);


    @Select("select cr.studentId as id,s.name as name,c.name as courseName,cr.grade " +
            "FROM courseresult as cr " +
            "LEFT JOIN student as s on s.id=cr.studentId " +
            "LEFT JOIN course as c on c.id=cr.courseId " +
            "LEFT JOIN teacher as t on t.classId=s.classId " +
            "where t.id=#{teacherId} and cr.studentId=#{studentId} " +
            "order by cr.grade desc")
    List<StudentGradeInfo> queryStudentGradesByTeacherIdAndStudentId(@Param("teacherId") Integer teacherId,@Param("studentId") Integer studentId);


    @Select("select cr.studentId as id,s.name as name,c.name as courseName,cr.grade " +
            "FROM courseresult as cr " +
            "LEFT JOIN student as s on s.id=cr.studentId " +
            "LEFT JOIN course as c on c.id=cr.courseId " +
            "LEFT JOIN teacher as t on t.classId=s.classId " +
            "where t.id=#{teacherId} and c.name=#{courseName} " +
            "order by cr.grade desc")
    List<StudentGradeInfo> queryCourseRankingByTeacherId(@Param("teacherId") Integer teacherId,@Param("courseName") String courseName);


    @Select("SELECT cr.studentId as id,s.name as name,c.name as courseName,cr.grade " +
            "FROM courseresult as cr " +
            "LEFT JOIN student as s on cr.studentId=s.id " +
            "LEFT JOIN course as c on cr.courseId=c.id " +
            "where cr.courseId=#{courseId} " +
            "ORDER BY cr.grade desc")
    List<StudentGradeInfo> queryCourseGradeByCourseId(@Param("courseId") Integer courseId);


    @Select("SELECT studentId,courseId,grade FROM courseresult where courseId=#{courseId} and studentId=#{studentId}")
    CourseResult queryCourseGradeByStudentId(@Param("courseId") String courseId,@Param("studentId") String studentId);

    @Update("update courseresult set grade=#{grade} where studentId=#{studentId} and courseId=#{courseId}")
    int updateCourseGrade(CourseResult courseResult);


    @Delete("delete from courseresult where studentId=#{studentId} and courseId=#{courseId}")
    int deleteData(CourseResult courseResult);
}