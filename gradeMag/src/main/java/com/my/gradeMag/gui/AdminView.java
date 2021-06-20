package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dao.TeacherMapper;
import com.my.gradeMag.dto.TeacherInfo;
import com.my.gradeMag.entity.Course;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminView extends JFrame {

    private JTextField searchStudentIdText,searchTeacherIdText,searchCourseIdText;


    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    private TeacherMapper teacherMapper;
    private CourseMapper courseMapper;

    public AdminView(String user){
        initDao();
        menuInit();
        this.setTitle("管理员界面   欢迎您,"+user);
        this.setBounds(500,10,650,650);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        courseMapper=sqlSession.getMapper(CourseMapper.class);
    }

    public void menuInit(){
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        MyActionListener actionListener=new MyActionListener();

        JMenu studentMenu=new JMenu("学生");
        JMenuItem studentListMenuItem=new JMenuItem("学生列表");
        studentListMenuItem.addActionListener(actionListener);
        JMenuItem studentInfoUpdateMenuItem=new JMenuItem("学生信息管理");
        studentInfoUpdateMenuItem.addActionListener(actionListener);
        studentMenu.add(studentListMenuItem);
        studentMenu.add(studentInfoUpdateMenuItem);
        menubar.add(studentMenu);

        JMenu teacherMenu=new JMenu("教师");
        JMenuItem teacherListMenuItem=new JMenuItem("教师列表");
        teacherListMenuItem.addActionListener(actionListener);
        JMenuItem teacherInfoUpdateMenuItem=new JMenuItem("教师信息管理");
        teacherInfoUpdateMenuItem.addActionListener(actionListener);
        teacherMenu.add(teacherListMenuItem);
        teacherMenu.add(teacherInfoUpdateMenuItem);
        menubar.add(teacherMenu);

        JMenu courseMenu=new JMenu("课程");
        JMenuItem courseListMenuItem=new JMenuItem("课程列表");
        courseListMenuItem.addActionListener(actionListener);
        JMenuItem courseInfoUpdateMenuItem=new JMenuItem("课程信息管理");
        courseInfoUpdateMenuItem.addActionListener(actionListener);
        courseMenu.add(courseListMenuItem);
        courseMenu.add(courseInfoUpdateMenuItem);
        menubar.add(courseMenu);

        JMenu gradeMenu=new JMenu("成绩");
        JMenuItem gradeListMenuItem=new JMenuItem("成绩列表");
        gradeListMenuItem.addActionListener(actionListener);
        JMenuItem gradeInfoUpdateMenuItem=new JMenuItem("成绩信息管理");
        gradeInfoUpdateMenuItem.addActionListener(actionListener);
        gradeMenu.add(gradeListMenuItem);
        gradeMenu.add(gradeInfoUpdateMenuItem);
        menubar.add(gradeMenu);

    }


    public void initStudentListPanel(String[] colName,String[][] tableData){
        getContentPane().removeAll();
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel studentIdlabel = new JLabel("学号");
        searchStudentIdText = new JTextField(10);
        JButton searchIdBtn = new JButton("搜索学号");
        searchIdBtn.addActionListener(new MyActionListener());

        Box baseBox = Box.createVerticalBox();
        Box componentBoxs= Box.createHorizontalBox();
        componentBoxs.add(studentIdlabel);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchStudentIdText);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchIdBtn);
        baseBox.add(Box.createVerticalStrut(20));
        baseBox.add(componentBoxs);
        baseBox.add(Box.createVerticalStrut(20));
        searchPanel.add(baseBox);

        JTable table=new JTable(tableData, colName);
        JScrollPane scrollPane = new JScrollPane(table);

        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(scrollPane,BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }


    public void initTeacherListPanel(String[] colName,String[][] tableData){
        getContentPane().removeAll();
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel teacherIdlabel = new JLabel("教师号");
        searchTeacherIdText = new JTextField(10);
        JButton searchIdBtn = new JButton("搜索教师号");
        searchIdBtn.addActionListener(new MyActionListener());

        Box baseBox = Box.createVerticalBox();
        Box componentBoxs= Box.createHorizontalBox();
        componentBoxs.add(teacherIdlabel);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchTeacherIdText);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchIdBtn);
        baseBox.add(Box.createVerticalStrut(20));
        baseBox.add(componentBoxs);
        baseBox.add(Box.createVerticalStrut(20));
        searchPanel.add(baseBox);

        JTable table=new JTable(tableData, colName);
        JScrollPane scrollPane = new JScrollPane(table);

        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(scrollPane,BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    public void initCourseListPanel(String[] colName,String[][] tableData){
        getContentPane().removeAll();
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel courseIdlabel = new JLabel("课程号");
        searchCourseIdText = new JTextField(10);
        JButton searchIdBtn = new JButton("搜索课程号");
        searchIdBtn.addActionListener(new MyActionListener());

        Box baseBox = Box.createVerticalBox();
        Box componentBoxs= Box.createHorizontalBox();
        componentBoxs.add(courseIdlabel);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchCourseIdText);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchIdBtn);
        baseBox.add(Box.createVerticalStrut(20));
        baseBox.add(componentBoxs);
        baseBox.add(Box.createVerticalStrut(20));
        searchPanel.add(baseBox);

        JTable table=new JTable(tableData, colName);
        JScrollPane scrollPane = new JScrollPane(table);

        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(scrollPane,BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }


    class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "学生列表":{
                    String[] colName={"序号","学号","姓名","性别","班级","电话"};
                    List<Student> studentList = studentMapper.queryAll();
                    String[][] tableData=new String[studentList.size()][colName.length];
                    for (int i = 0; i < studentList.size(); i++) {
                        tableData[i][0]=(i+1)+"";
                        tableData[i][1]=studentList.get(i).getId()+"";
                        tableData[i][2]=studentList.get(i).getName();
                        tableData[i][3]=studentList.get(i).getSex();
                        tableData[i][4]=studentList.get(i).getClassId();
                        tableData[i][5]=studentList.get(i).getTel();
                    }
                    initStudentListPanel(colName,tableData);
                    break;
                }
                case "教师列表":{
                    String[] colName={"序号","教师号","姓名","性别","电话","学院","班级","授课"};
                    List<TeacherInfo> teacherInfos = teacherMapper.queryAllTeacherInfo();
                    String[][] tableData=new String[teacherInfos.size()][colName.length];
                    for (int i = 0; i < teacherInfos.size(); i++) {
                        tableData[i][0]=(i+1)+"";
                        tableData[i][1]=teacherInfos.get(i).getId()+"";
                        tableData[i][2]=teacherInfos.get(i).getName();
                        tableData[i][3]=teacherInfos.get(i).getSex();
                        tableData[i][4]=teacherInfos.get(i).getTel();
                        tableData[i][5]=teacherInfos.get(i).getAcademy();
                        tableData[i][6]=teacherInfos.get(i).getClassName();
                        tableData[i][7]=teacherInfos.get(i).getCourseName();
                    }
                    initTeacherListPanel(colName,tableData);
                    break;
                }
                case "课程列表":{
                    String[] colName={"序号","课程号","课程名"};
                    List<Course> courseInfos = courseMapper.queryAll();
                    String[][] tableData=new String[courseInfos.size()][colName.length];
                    for (int i = 0; i < courseInfos.size(); i++) {
                        tableData[i][0]=(i+1)+"";
                        tableData[i][1]=courseInfos.get(i).getId()+"";
                        tableData[i][2]=courseInfos.get(i).getName();
                    }
                    initCourseListPanel(colName,tableData);
                    break;
                }
                case "搜索学号":{
                    List<Student> studentList;
                    String studentId=searchStudentIdText.getText();
                    if(studentId.equals("")){
                        studentList = studentMapper.queryAll();
                    }else{
                        studentList = studentMapper.queryStudentInfoById(Integer.parseInt(studentId));
                    }
                    String[] colName={"序号","学号","姓名","性别","班级","电话"};
                    String[][] tableData=new String[studentList.size()][colName.length];
                    for (int i = 0; i < studentList.size(); i++) {
                        tableData[i][0]=(i+1)+"";
                        tableData[i][1]=studentList.get(i).getId()+"";
                        tableData[i][2]=studentList.get(i).getName();
                        tableData[i][3]=studentList.get(i).getSex();
                        tableData[i][4]=studentList.get(i).getClassId();
                        tableData[i][5]=studentList.get(i).getTel();
                    }
                    initStudentListPanel(colName,tableData);
                    break;
                }
                case "搜索教师号":{
                    String[] colName={"序号","教师号","姓名","性别","电话","学院","班级","授课"};
                    List<TeacherInfo> teacherInfos;
                    String teacherId=searchTeacherIdText.getText();
                    if(teacherId.equals("")){
                        teacherInfos=teacherMapper.queryAllTeacherInfo();
                    }else{
                        teacherInfos=teacherMapper.queryTeacherInfoById(Integer.parseInt(teacherId));
                    }
                    String[][] tableData=new String[teacherInfos.size()][colName.length];
                    for (int i = 0; i < teacherInfos.size(); i++) {
                        tableData[i][0]=(i+1)+"";
                        tableData[i][1]=teacherInfos.get(i).getId()+"";
                        tableData[i][2]=teacherInfos.get(i).getName();
                        tableData[i][3]=teacherInfos.get(i).getSex();
                        tableData[i][4]=teacherInfos.get(i).getTel();
                        tableData[i][5]=teacherInfos.get(i).getAcademy();
                        tableData[i][6]=teacherInfos.get(i).getClassName();
                        tableData[i][7]=teacherInfos.get(i).getCourseName();
                    }
                    initTeacherListPanel(colName,tableData);
                    break;
                }
                case "学生信息管理":{
                    new StudentInfoUpdateView();
                    break;
                }
                case "教师信息管理":{
                    new TeacherInfoUpdateView();
                    break;
                }
                case "搜索课程号":{
                    String courseId=searchCourseIdText.getText();
                    String[] colName={"序号","课程号","课程名"};
                    String[][] tableData;
                    if(courseId.equals("")){
                        List<Course> courseInfos = courseMapper.queryAll();
                        tableData=new String[courseInfos.size()][colName.length];
                        for (int i = 0; i < courseInfos.size(); i++) {
                            tableData[i][0]=(i+1)+"";
                            tableData[i][1]=courseInfos.get(i).getId()+"";
                            tableData[i][2]=courseInfos.get(i).getName();
                        }
                    }else{
                        Course courseInfo=courseMapper.queryCourseById(Integer.parseInt(courseId));
                        tableData=new String[1][colName.length];
                        tableData[0][0]="1";
                        tableData[0][1]=courseId;
                        tableData[0][2]=courseInfo.getName();
                    }
                    initCourseListPanel(colName,tableData);
                    break;
                }
                case "课程信息管理":{
                    new CourseInfoUpdateView();
                    break;
                }
                case "成绩列表":{
                    new GradeView();
                    break;
                }
                case "成绩信息管理":{
                    new GradeInfoUpdateView();
                    break;
                }
            }
        }
    }


}
