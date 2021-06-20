package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.entity.Course;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseInfoUpdateView extends JFrame {

    private JTextField courseIdText,courseNameText;

    private SqlSession sqlSession;
    private CourseMapper courseMapper;


    public CourseInfoUpdateView(){
        initDao();
        initView();
        this.setTitle("课程信息管理");
        this.setBounds(500,10,350,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        courseMapper=sqlSession.getMapper(CourseMapper.class);

    }

    public void initView(){
        JPanel totalPanel = new JPanel(new FlowLayout());
        CourseInfoUpdateViewActionListener actionListener=new CourseInfoUpdateViewActionListener();

        Box baseBox = Box.createVerticalBox();
        Box[] componentBoxs=new Box[4];

        JLabel courseIdlabel = new JLabel("课程号");
        courseIdText = new JTextField(10);
        JButton searchBtn=new JButton("查询");
        searchBtn.addActionListener(actionListener);
        componentBoxs[0]=Box.createHorizontalBox();
        componentBoxs[0].add(courseIdlabel);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(courseIdText);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(searchBtn);

        JLabel courseNamelabel = new JLabel("课程名");
        courseNameText = new JTextField(10);
        componentBoxs[1]=Box.createHorizontalBox();
        componentBoxs[1].add(courseNamelabel);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(courseNameText);

        JButton updateBtn=new JButton("修改");
        JButton insertBtn=new JButton("添加");
        JButton deleteBtn=new JButton("删除");
        updateBtn.addActionListener(actionListener);
        insertBtn.addActionListener(actionListener);
        deleteBtn.addActionListener(actionListener);
        componentBoxs[2]=Box.createHorizontalBox();
        componentBoxs[2].add(updateBtn);
        componentBoxs[2].add(Box.createHorizontalStrut(30));
        componentBoxs[2].add(insertBtn);
        componentBoxs[2].add(Box.createHorizontalStrut(30));
        componentBoxs[2].add(deleteBtn);

        JButton resetBtn=new JButton("重置");
        resetBtn.addActionListener(actionListener);
        componentBoxs[3]=Box.createHorizontalBox();
        componentBoxs[3].add(resetBtn);

        for(int i=0;i<componentBoxs.length;i++){
            baseBox.add(Box.createVerticalStrut(40));
            baseBox.add(componentBoxs[i]);
        }

        totalPanel.add(baseBox);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    class CourseInfoUpdateViewActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "查询":{
                    String courseId=courseIdText.getText();
                    if(courseId.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程号","出错",JOptionPane.ERROR_MESSAGE);
                    }else{
                        Course course=courseMapper.queryCourseById(Integer.parseInt(courseId));
                        if(course==null){
                            JOptionPane.showMessageDialog(null,"查询失败\n该课程号未被注册","出错",JOptionPane.ERROR_MESSAGE);
                            reset();
                            break;
                        }
                        courseNameText.setText(course.getName());
                    }
                    break;
                }
                case "修改":{
                    String id=courseIdText.getText();
                    String name=courseNameText.getText();

                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Course course=new Course(Integer.parseInt(id),name);
                    if(courseMapper.checkExist(name)>0){
                        JOptionPane.showMessageDialog(null,"修改失败\n在课程名已存在","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(courseMapper.updateCourseInfo(course)>0){
                        JOptionPane.showMessageDialog(null,"修改成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    } else{
                        JOptionPane.showMessageDialog(null,"修改失败","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }
                    break;
                }
                case "添加":{
                    String id=courseIdText.getText();
                    String name=courseNameText.getText();

                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }


                    if(courseMapper.checkCourseIdExist(Integer.parseInt(id))>0){
                        JOptionPane.showMessageDialog(null,"该课程号已被注册","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(courseMapper.checkExist(name)>0){
                        JOptionPane.showMessageDialog(null,"修改失败\n在课程名已存在","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Course course=new Course(Integer.parseInt(id),name);
                    if(courseMapper.insertCourse(course)>0){
                        JOptionPane.showMessageDialog(null,"添加课程信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"添加课程信息失败","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }
                    break;
                }
                case "删除":{
                    String id=courseIdText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入课程号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    if(courseMapper.checkCourseIdExist(Integer.parseInt(id))>0){
                        if(courseMapper.deleteCourse(Integer.parseInt(id))>0){
                            JOptionPane.showMessageDialog(null,"删除课程信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                            sqlSession.commit();
                            reset();
                        }else{
                            JOptionPane.showMessageDialog(null,"删除课程信息失败","出错",JOptionPane.ERROR_MESSAGE);
                            sqlSession.rollback();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"删除失败\n该课程号未被注册","出错",JOptionPane.ERROR_MESSAGE);
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
            courseIdText.setText("");
            courseNameText.setText("");
        }
    }


}
