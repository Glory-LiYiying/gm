package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dao.TeacherMapper;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoUpdateView extends JFrame {


    private JTextField studentIdText,studentNameText,studentSexText,studentClassText,studentTelText;

    private SqlSession sqlSession;
    private StudentMapper studentMapper;


    public StudentInfoUpdateView(){
        initDao();
        initView();
        this.setTitle("学生信息管理");
        this.setBounds(500,10,350,550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);

    }

    public void initView(){
        JPanel totalPanel = new JPanel(new FlowLayout());
        StudentInfoUpdateViewActionListener actionListener=new StudentInfoUpdateViewActionListener();

        Box baseBox = Box.createVerticalBox();
        Box[] componentBoxs=new Box[7];

        JLabel studentIdlabel = new JLabel("学号");
        studentIdText = new JTextField(10);
        JButton searchBtn=new JButton("查询");
        searchBtn.addActionListener(actionListener);
        componentBoxs[0]=Box.createHorizontalBox();
        componentBoxs[0].add(studentIdlabel);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(studentIdText);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(searchBtn);

        JLabel studentNamelabel = new JLabel("姓名");
        studentNameText = new JTextField(10);
        componentBoxs[1]=Box.createHorizontalBox();
        componentBoxs[1].add(studentNamelabel);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(studentNameText);

        JLabel studentSexlabel = new JLabel("性别");
        studentSexText = new JTextField(10);
        componentBoxs[2]=Box.createHorizontalBox();
        componentBoxs[2].add(studentSexlabel);
        componentBoxs[2].add(Box.createHorizontalStrut(10));
        componentBoxs[2].add(studentSexText);

        JLabel studentClasslabel = new JLabel("班级");
        studentClassText = new JTextField(10);
        componentBoxs[3]=Box.createHorizontalBox();
        componentBoxs[3].add(studentClasslabel);
        componentBoxs[3].add(Box.createHorizontalStrut(10));
        componentBoxs[3].add(studentClassText);

        JLabel studentTellabel = new JLabel("电话");
        studentTelText = new JTextField(10);
        componentBoxs[4]=Box.createHorizontalBox();
        componentBoxs[4].add(studentTellabel);
        componentBoxs[4].add(Box.createHorizontalStrut(10));
        componentBoxs[4].add(studentTelText);

        JButton updateBtn=new JButton("修改");
        JButton insertBtn=new JButton("添加");
        JButton deleteBtn=new JButton("删除");
        updateBtn.addActionListener(actionListener);
        insertBtn.addActionListener(actionListener);
        deleteBtn.addActionListener(actionListener);
        componentBoxs[5]=Box.createHorizontalBox();
        componentBoxs[5].add(updateBtn);
        componentBoxs[5].add(Box.createHorizontalStrut(30));
        componentBoxs[5].add(insertBtn);
        componentBoxs[5].add(Box.createHorizontalStrut(30));
        componentBoxs[5].add(deleteBtn);

        JButton resetBtn=new JButton("重置");
        resetBtn.addActionListener(actionListener);
        componentBoxs[6]=Box.createHorizontalBox();
        componentBoxs[6].add(resetBtn);

        for(int i=0;i<componentBoxs.length;i++){
            baseBox.add(Box.createVerticalStrut(40));
            baseBox.add(componentBoxs[i]);
        }


        totalPanel.add(baseBox);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    class StudentInfoUpdateViewActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "查询":{
                    String studentId=studentIdText.getText();
                    if(studentId.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生学号","出错",JOptionPane.ERROR_MESSAGE);
                    }else{
                        Student student=studentMapper.queryStudentInfo(Integer.parseInt(studentId));
                        if(student==null){
                            JOptionPane.showMessageDialog(null,"查询失败\n该学号未被注册","出错",JOptionPane.ERROR_MESSAGE);
                            reset();
                            break;
                        }
                        studentNameText.setText(student.getName());
                        studentSexText.setText(student.getSex());
                        studentClassText.setText(student.getClassId());
                        studentTelText.setText(student.getTel());
                    }
                    break;
                }
                case "修改":{
                    String id=studentIdText.getText();
                    String name=studentNameText.getText();
                    String sex=studentSexText.getText();
                    String classId=studentClassText.getText();
                    String tel=studentTelText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生学号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生姓名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(sex.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生性别","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(classId.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生班级","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Student student=new Student(Integer.parseInt(id),name,classId,sex,tel);
                    if(studentMapper.updateStudentInfo(student)>0){
                        JOptionPane.showMessageDialog(null,"修改成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    } else{
                        JOptionPane.showMessageDialog(null,"修改失败\n请检查学生学号是否正确","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }

                    break;
                }
                case "添加":{
                    String id=studentIdText.getText();
                    String name=studentNameText.getText();
                    String sex=studentSexText.getText();
                    String classId=studentClassText.getText();
                    String tel=studentTelText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生学号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生姓名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(sex.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生性别","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    if(classId.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生班级","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    Student student=new Student(Integer.parseInt(id),name,classId,sex,tel);
                    if(studentMapper.queryStudentIdExist(student)>0){
                        JOptionPane.showMessageDialog(null,"该学号已被注册","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }else if(studentMapper.insertStudent(student)>0){
                        JOptionPane.showMessageDialog(null,"添加学生信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                        sqlSession.commit();
                    }else{
                        JOptionPane.showMessageDialog(null,"添加学生信息失败","出错",JOptionPane.ERROR_MESSAGE);
                        sqlSession.rollback();
                    }
                    break;
                }
                case "删除":{
                    String id=studentIdText.getText();
                    if(id.equals("")){
                        JOptionPane.showMessageDialog(null,"请先输入学生学号","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    Student student=new Student();
                    student.setId(Integer.parseInt(id));
                    if(studentMapper.queryStudentIdExist(student)>0){
                        if(studentMapper.deleteStudent(student)>0){
                            JOptionPane.showMessageDialog(null,"删除学生信息成功","信息",JOptionPane.INFORMATION_MESSAGE);
                            sqlSession.commit();
                            reset();
                        }else{
                            JOptionPane.showMessageDialog(null,"删除学生信息失败","出错",JOptionPane.ERROR_MESSAGE);
                            sqlSession.rollback();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"删除失败\n该学号未被注册","出错",JOptionPane.ERROR_MESSAGE);
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
            studentIdText.setText("");
            studentNameText.setText("");
            studentSexText.setText("");
            studentClassText.setText("");
            studentTelText.setText("");
        }
    }


}
