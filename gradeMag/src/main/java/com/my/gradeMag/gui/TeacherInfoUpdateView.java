package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.dao.TeacherMapper;
import com.my.gradeMag.dto.TeacherInfo;
import com.my.gradeMag.entity.Teacher;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherInfoUpdateView extends JFrame {
    private JTextField teacherIdText,teacherNameText,teacherSexText,teacherCourseText,teacherTelText,teacherAcademyText;

    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;
    private CourseMapper courseMapper;

    public TeacherInfoUpdateView(){
        initDao();
        initView();
        this.setTitle("教师信息管理");
        this.setBounds(500,10,350,620);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        courseMapper=sqlSession.getMapper(CourseMapper.class);
    }

    public void initView(){
        JPanel totalPanel = new JPanel(new FlowLayout());
        TeacherInfoUpdateViewActionListener actionListener=new TeacherInfoUpdateViewActionListener();

        Box baseBox = Box.createVerticalBox();
        Box[] componentBoxs=new Box[8];

        JLabel teacherIdlabel = new JLabel("教师号");
        teacherIdText = new JTextField(10);
        JButton searchBtn=new JButton("查询");
        searchBtn.addActionListener(actionListener);
        componentBoxs[0]=Box.createHorizontalBox();
        componentBoxs[0].add(teacherIdlabel);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(teacherIdText);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(searchBtn);

        JLabel teacherNamelabel = new JLabel("姓名");
        teacherNameText = new JTextField(10);
        componentBoxs[1]=Box.createHorizontalBox();
        componentBoxs[1].add(teacherNamelabel);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(teacherNameText);

        JLabel teacherSexlabel = new JLabel("性别");
        teacherSexText = new JTextField(10);
        componentBoxs[2]=Box.createHorizontalBox();
        componentBoxs[2].add(teacherSexlabel);
        componentBoxs[2].add(Box.createHorizontalStrut(10));
        componentBoxs[2].add(teacherSexText);

        JLabel teacherTellabel = new JLabel("电话");
        teacherTelText = new JTextField(10);
        componentBoxs[3]=Box.createHorizontalBox();
        componentBoxs[3].add(teacherTellabel);
        componentBoxs[3].add(Box.createHorizontalStrut(10));
        componentBoxs[3].add(teacherTelText);

        JLabel teacherAcademylabel = new JLabel("学院");
        teacherAcademyText = new JTextField(10);
        componentBoxs[4]=Box.createHorizontalBox();
        componentBoxs[4].add(teacherAcademylabel);
        componentBoxs[4].add(Box.createHorizontalStrut(10));
        componentBoxs[4].add(teacherAcademyText);
        
        JLabel teacherCourselabel = new JLabel("授课");
        teacherCourseText = new JTextField(10);
        componentBoxs[5]=Box.createHorizontalBox();
        componentBoxs[5].add(teacherCourselabel);
        componentBoxs[5].add(Box.createHorizontalStrut(10));
        componentBoxs[5].add(teacherCourseText);

        
        JButton updateBtn=new JButton("修改");
        JButton insertBtn=new JButton("添加");
        JButton deleteBtn=new JButton("删除");
        updateBtn.addActionListener(actionListener);
        insertBtn.addActionListener(actionListener);
        deleteBtn.addActionListener(actionListener);
        componentBoxs[6]=Box.createHorizontalBox();
        componentBoxs[6].add(updateBtn);
        componentBoxs[6].add(Box.createHorizontalStrut(30));
        componentBoxs[6].add(insertBtn);
        componentBoxs[6].add(Box.createHorizontalStrut(30));
        componentBoxs[6].add(deleteBtn);

        JButton resetBtn=new JButton("重置");
        resetBtn.addActionListener(actionListener);
        componentBoxs[7]=Box.createHorizontalBox();
        componentBoxs[7].add(resetBtn);

        for(int i=0;i<componentBoxs.length;i++){
            baseBox.add(Box.createVerticalStrut(40));
            baseBox.add(componentBoxs[i]);
        }
        
        
        totalPanel.add(baseBox);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    class TeacherInfoUpdateViewActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "查询":{
                    String teacherId=teacherIdText.getText();
                    if(teacherId.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师号","出错",JOptionPane.ERROR_MESSAGE);
                    }else{
                        TeacherInfo teacher=teacherMapper.queryOneTeacherInfoById(Integer.parseInt(teacherId));
                        if(teacher==null){
                            JOptionPane.showMessageDialog(null,"查询失败\n该教师号未被注册","出错",JOptionPane.ERROR_MESSAGE);
                            reset();
                            break;
                        }
                        teacherNameText.setText(teacher.getName());
                        teacherSexText.setText(teacher.getSex());
                        teacherTelText.setText(teacher.getTel());
                        teacherAcademyText.setText(teacher.getAcademy());
                        teacherCourseText.setText(teacher.getCourseName());
                    }
                    break;
                }
                case "修改":{
                    String id=teacherIdText.getText();
                    String name=teacherNameText.getText();
                    String sex=teacherSexText.getText();
                    String tel=teacherTelText.getText();
                    String academy=teacherAcademyText.getText();
                    String course=teacherCourseText.getText();
                    
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师姓名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(sex.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师性别","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(academy.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学院","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(course.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师授课科目","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if(courseMapper.checkExist(course)==0){
                        JOptionPane.showMessageDialog(null,"系统中暂无授课科目\n请先进行添加该科目","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    TeacherInfo teacher=new TeacherInfo(Integer.parseInt(id),name,sex,tel,academy,course);
                    if(teacherMapper.updateTeacherBasicInfo(teacher)>0){
                        JOptionPane.showMessageDialog(null,"修改成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"修改失败\n请检查教师号是否正确","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }
                    break;
                }
                case "添加":{
                    String id=teacherIdText.getText();
                    String name=teacherNameText.getText();
                    String sex=teacherSexText.getText();
                    String tel=teacherTelText.getText();
                    String academy=teacherAcademyText.getText();
                    String course=teacherCourseText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师姓名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(sex.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师性别","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(academy.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学院","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(course.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师授课科目","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if(teacherMapper.queryTeacherIdExist(Integer.parseInt(id))>0){
                        JOptionPane.showMessageDialog(null,"该教师号已被注册","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Integer courseId=courseMapper.queryCourseIdByName(course);
                    if(courseId==null){
                        JOptionPane.showMessageDialog(null,"系统中暂无授课科目\n请先进行添加该科目","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Teacher teacher=new Teacher(Integer.parseInt(id),name,sex,tel,academy,courseId);
                    if(teacherMapper.insertTeacher(teacher)>0){
                        JOptionPane.showMessageDialog(null,"添加教师信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"添加教师信息失败","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }
                    break;
                }
                case "删除":{
                    String id=teacherIdText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入教师号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if(teacherMapper.queryTeacherIdExist(Integer.parseInt(id))>0){
                        if(teacherMapper.deleteTeacher(Integer.parseInt(id))>0){
                            JOptionPane.showMessageDialog(null,"删除教师信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                            sqlSession.commit();
                            reset();
                        }else{
                            JOptionPane.showMessageDialog(null,"删除教师信息失败","出错",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"删除失败\n该教师号未被注册","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    break;
                }
                case "重置":{
                    reset();
                    break;
                }
            }
        }

        public void reset(){
            teacherIdText.setText("");
            teacherNameText.setText("");
            teacherSexText.setText("");
            teacherCourseText.setText("");
            teacherTelText.setText("");
            teacherAcademyText.setText("");
        }
    }


}
