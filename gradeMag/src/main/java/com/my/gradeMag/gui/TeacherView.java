package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dao.TeacherMapper;
import com.my.gradeMag.dto.StudentGradeInfo;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.entity.Teacher;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.List;

public class TeacherView extends JFrame {

    Integer teacherId;
    JMenuBar menubar;
    JMenu personInfoMenu, studentInfoMenu, courseInfoMenu;
    JMenuItem studentInfoItem, studentgradeItem, personInfoItem, updatePswItem, courseStudentInfoItem, courseStudentGradeItem;
    JPasswordField originPswInput, newPswInput, confirmPswInput;
    JTextField searchNameText, searchStudentIdText, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, searchCourseRankText;

    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;
    private StudentMapper studentMapper;
    private CourseResultMapper courseResultMapper;

    private void initDao() {
        sqlSession = MybatisUtils.getSqlSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        courseResultMapper = sqlSession.getMapper(CourseResultMapper.class);
    }

    public TeacherView(Integer teacherId,String name) {
        this.teacherId = teacherId;
        initDao();

        this.setTitle("教师界面   欢迎您,"+name);
        this.setBounds(500, 10, 600, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        menubar = new JMenuBar();
        setJMenuBar(menubar);
        MenuBarListener menuBarListener = new MenuBarListener();   //监听

        personInfoMenu = new JMenu("个人信息");
        personInfoItem = new JMenuItem("个人的信息");
        updatePswItem = new JMenuItem("修改密码");
        personInfoMenu.add(personInfoItem);
        personInfoMenu.add(updatePswItem);
        menubar.add(personInfoMenu);
        personInfoItem.addActionListener(menuBarListener);
        updatePswItem.addActionListener(menuBarListener);

        studentInfoMenu = new JMenu("班级信息");
        studentInfoItem = new JMenuItem("学生个人信息");
        studentInfoMenu.add(studentInfoItem);
        studentInfoItem.addActionListener(menuBarListener);
        studentgradeItem = new JMenuItem("学生成绩表");
        studentInfoMenu.add(studentgradeItem);
        studentgradeItem.addActionListener(menuBarListener);
        menubar.add(studentInfoMenu);

        courseInfoMenu = new JMenu("课堂信息");
        courseStudentInfoItem = new JMenuItem("学生信息");
        courseInfoMenu.add(courseStudentInfoItem);
        courseStudentInfoItem.addActionListener(menuBarListener);
        courseStudentGradeItem = new JMenuItem("学生成绩");
        courseInfoMenu.add(courseStudentGradeItem);
        courseStudentGradeItem.addActionListener(menuBarListener);
        menubar.add(courseInfoMenu);

        validate();
    }

    //教师个人信息界面
    public void teacherInfoPanelInit() {
        getContentPane().removeAll();
        JPanel updateInfoPanel = new JPanel();
        JButton updateInfoBtn = new JButton("更新信息");
        updateInfoPanel.setLayout(new FlowLayout());

        JLabel infoLabels[] = new JLabel[7];
        infoLabels[0] = new JLabel("教师号");
        infoLabels[1] = new JLabel("姓名");
        infoLabels[2] = new JLabel("性别");
        infoLabels[3] = new JLabel("电话");
        infoLabels[4] = new JLabel("所属学院");
        infoLabels[5] = new JLabel("负责班级");
        infoLabels[6] = new JLabel("执教课程");
        JTextField infoInputs[] = new JTextField[7];
        infoInputs[0] = new JTextField(10);
        infoInputs[1] = new JTextField(10);
        infoInputs[2] = new JTextField(10);
        infoInputs[3] = new JTextField(10);
        infoInputs[4] = new JTextField(10);
        infoInputs[5] = new JTextField(10);
        infoInputs[6] = new JTextField(10);
        Teacher teacherInfo = teacherMapper.queryTeacherInfo(teacherId);
        infoInputs[0].setText(teacherId + "");
        infoInputs[1].setText(teacherInfo.getName());
        infoInputs[2].setText(teacherInfo.getSex());
        infoInputs[3].setText(teacherInfo.getTel());
        infoInputs[4].setText(teacherInfo.getAcademy());
        infoInputs[5].setText(teacherInfo.getClassId());
        infoInputs[6].setText(teacherInfo.getCourseId() + "");
        infoInputs[0].setEditable(false);  //教师文本框不能编辑

        Box infoBox[] = new Box[7];
        for (int i = 0; i < 7; i++) {
            infoBox[i] = Box.createHorizontalBox();
            infoBox[i].add(infoLabels[i]);
            infoBox[i].add(Box.createHorizontalStrut(40));
            infoBox[i].add(infoInputs[i]);
        }
        Box basebox = Box.createVerticalBox();
        for (int i = 0; i < 7; i++) {
            basebox.add(Box.createVerticalStrut(40));
            basebox.add(infoBox[i]);
        }
        basebox.add(Box.createVerticalStrut(40));
        basebox.add(updateInfoBtn);
        updateInfoPanel.add(basebox);
        updateInfoBtn.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                Teacher teacher = new Teacher();
                teacher.setId(teacherId);
                teacher.setName(infoInputs[1].getText());
                teacher.setSex(infoInputs[2].getText());
                teacher.setTel(infoInputs[3].getText());
                teacher.setAcademy(infoInputs[4].getText());
                teacher.setClassId(infoInputs[5].getText());
                teacher.setCourseId(Integer.parseInt(infoInputs[6].getText()));
                if (teacherMapper.updateTeacherInfo(teacher) > 0) {
                    JOptionPane.showMessageDialog(null, "更新信息成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                    sqlSession.commit();
                } else {
                    JOptionPane.showMessageDialog(null, "更新信息失败", "出错", JOptionPane.ERROR_MESSAGE);
                    sqlSession.rollback();
                    teacherInfoPanelInit();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        getContentPane().add(updateInfoPanel);
        getContentPane().repaint();
        getContentPane().validate();


    }

    public void updatePswPanelInit() {
        getContentPane().removeAll();
        JPanel updatePswPanel = new JPanel();
        updatePswPanel.setLayout(new FlowLayout());
        JLabel originPswLabel = new JLabel("原密码：");
        JLabel newPswLabel = new JLabel("新密码：");
        JLabel confirmPswLabel = new JLabel("确认密码：");
        originPswInput = new JPasswordField(10);
        newPswInput = new JPasswordField(10);
        confirmPswInput = new JPasswordField(10);
        JButton updatePswBtn = new JButton("更新密码");
        Box pswBox[] = new Box[4];
        Box basebox1 = Box.createVerticalBox();
        for (int a = 0; a < 4; a++) {
            pswBox[a] = Box.createHorizontalBox();
        }
        pswBox[0].add(originPswLabel);
        pswBox[0].add(Box.createHorizontalStrut(40));
        pswBox[0].add(originPswInput);
        pswBox[1].add(newPswLabel);
        pswBox[1].add(Box.createHorizontalStrut(40));
        pswBox[1].add(newPswInput);
        pswBox[2].add(confirmPswLabel);
        pswBox[2].add(Box.createHorizontalStrut(30));
        pswBox[2].add(confirmPswInput);
        pswBox[3].add(updatePswBtn);
        for (int a = 0; a < 4; a++) {
            basebox1.add(Box.createVerticalStrut(40));
            basebox1.add(pswBox[a]);
        }
        updatePswPanel.add(basebox1);
        updatePswBtn.addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                String oldPwd = String.valueOf(originPswInput.getPassword());
                if (teacherMapper.checkTeacherPsw(oldPwd, teacherId) > 0) {
                    String newPsw1 = String.valueOf(newPswInput.getPassword());
                    String newPsw2 = String.valueOf(confirmPswInput.getPassword());
                    if (newPsw1.equals(newPsw2)) {
                        if (teacherMapper.updateTeacherPsw(newPsw1, teacherId) > 0) {
                            sqlSession.commit();
                            JOptionPane.showMessageDialog(null, "修改成功", "修改成功", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "修改失败", "出错", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "两次输入的新密码不一致", "出错", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "输入的原密码错误", "出错", JOptionPane.ERROR_MESSAGE);
                }
                updatePswPanelInit();
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        getContentPane().add(updatePswPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    public void studentInfoPanelInit(List<Student> studentInfos) {
        getContentPane().removeAll();
        JTable table;
        String[] name = {"学号", "姓名", "性别", "班级号", "电话"};

        String[][] tableData = new String[studentInfos.size() + 1][name.length];
        for (int i = 0; i < studentInfos.size(); i++) {
            tableData[i][0] = studentInfos.get(i).getId() + "";
            tableData[i][1] = studentInfos.get(i).getName();
            tableData[i][2] = studentInfos.get(i).getSex();
            tableData[i][3] = studentInfos.get(i).getClassId();
            tableData[i][4] = studentInfos.get(i).getTel();
        }
        table = new JTable(tableData, name);

        SearchBtnListener searchBtnListener = new SearchBtnListener();
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());
        Box baseBox = Box.createVerticalBox();
        Box componentBox = Box.createHorizontalBox();
        JLabel label = new JLabel("姓名");
        searchNameText = new JTextField(10);
        JButton seachNameBtn = new JButton("搜索姓名");
        componentBox.add(label);
        componentBox.add(Box.createHorizontalStrut(10));
        componentBox.add(searchNameText);
        componentBox.add(Box.createHorizontalStrut(10));
        componentBox.add(seachNameBtn);
        baseBox.add(Box.createVerticalStrut(20));
        baseBox.add(componentBox);
        baseBox.add(Box.createVerticalStrut(20));
        seachNameBtn.addActionListener(searchBtnListener);
        searchPanel.add(baseBox);
        JScrollPane jsp = new JScrollPane(table);
        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(jsp, BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    public void studentGradePanelInit(String[] colName, String[][] tableData) {
        getContentPane().removeAll();

        JPanel totalPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout());
        Box baseBox = Box.createVerticalBox();
        Box[] componentBoxs = new Box[2];

        SearchBtnListener searchBtnListener = new SearchBtnListener();

        JLabel studentIdlabel = new JLabel("学号");
        searchStudentIdText = new JTextField(10);
        JButton searchIdBtn = new JButton("搜索学号");
        searchIdBtn.addActionListener(searchBtnListener);
        componentBoxs[0] = Box.createHorizontalBox();
        componentBoxs[0].add(studentIdlabel);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(searchStudentIdText);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(searchIdBtn);

        JLabel courseNameLabel = new JLabel("课程名");
        searchCourseRankText = new JTextField(10);
        JButton searchCourseRankBtn = new JButton("查看单科排名");
        searchCourseRankBtn.addActionListener(searchBtnListener);
        componentBoxs[1] = Box.createHorizontalBox();
        componentBoxs[1].add(courseNameLabel);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(searchCourseRankText);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(searchCourseRankBtn);

        baseBox.add(Box.createVerticalStrut(20));
        baseBox.add(componentBoxs[0]);
        baseBox.add(Box.createVerticalStrut(10));
        baseBox.add(componentBoxs[1]);
        baseBox.add(Box.createVerticalStrut(20));
        searchPanel.add(baseBox);

        JTable table;
        table = new JTable(tableData, colName);
        JScrollPane jsp = new JScrollPane(table);

        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(jsp, BorderLayout.CENTER);
        getContentPane().add(totalPanel);

        getContentPane().repaint();
        getContentPane().validate();

    }

    public void courseStudentInfoPanelInit(List<Student> studentInfos) {
        getContentPane().removeAll();
        JTable table;
        String[] name = {" ","学号", "姓名", "性别", "班级号", "电话"};

        String[][] tableData = new String[studentInfos.size() + 1][name.length];
        for (int i = 0; i < studentInfos.size(); i++) {
            tableData[i][0] = (i+1) + "";
            tableData[i][1] = studentInfos.get(i).getId() + "";
            tableData[i][2] = studentInfos.get(i).getName();
            tableData[i][3] = studentInfos.get(i).getSex();
            tableData[i][4] = studentInfos.get(i).getClassId();
            tableData[i][5] = studentInfos.get(i).getTel();
        }
        table = new JTable(tableData, name);

        JPanel totalPanel = new JPanel(new BorderLayout());
        JScrollPane jsp = new JScrollPane(table);
        totalPanel.add(jsp, BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    public void courseStudentGradePanelInit(String[] colName, String[][] tableData) {
        getContentPane().removeAll();

        JPanel totalPanel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout());
        Box baseBox = Box.createVerticalBox();

        SearchBtnListener searchBtnListener = new SearchBtnListener();

        JLabel studentIdlabel = new JLabel("学号");
        searchStudentIdText = new JTextField(10);
        JButton searchIdBtn = new JButton("搜索学号");
        searchIdBtn.setActionCommand("searchStudentId_course");
        searchIdBtn.addActionListener(searchBtnListener);
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

        JTable table;
        table = new JTable(tableData, colName);
        JScrollPane jsp = new JScrollPane(table);

        totalPanel.add(searchPanel, BorderLayout.NORTH);
        totalPanel.add(jsp, BorderLayout.CENTER);
        getContentPane().add(totalPanel);

        getContentPane().repaint();
        getContentPane().validate();

    }

    //监听菜单条事件
    class MenuBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("个人的信息")) {
                teacherInfoPanelInit();
            } else if (e.getActionCommand().equals("修改密码")) {
                updatePswPanelInit();
            } else if (e.getActionCommand().equals("学生个人信息")) {
                List<Student> studentInfos = studentMapper.queryStudentInfosByTeacherId(teacherId);
                studentInfoPanelInit(studentInfos);
            } else if (e.getActionCommand().equals("学生成绩表")) {
                String[] colName = {" ", "学号", "学生姓名", "课程名", "分数"};
                List<StudentGradeInfo> studentGradeInfos = courseResultMapper.queryStudentGradesByTeacherId(teacherId);
                String[][] tableData = new String[studentGradeInfos.size() + 1][colName.length];
                for (int i = 0; i < studentGradeInfos.size(); i++) {
                    tableData[i][0] = (i + 1) + "";
                    tableData[i][1] = studentGradeInfos.get(i).getId() + "";
                    tableData[i][2] = studentGradeInfos.get(i).getName();
                    tableData[i][3] = studentGradeInfos.get(i).getCourseName();
                    tableData[i][4] = studentGradeInfos.get(i).getGrade() + "";
                }
                studentGradePanelInit(colName, tableData);
            } else if (e.getActionCommand().equals("学生信息")) {
                List<Student> studentInfos = teacherMapper.queryCourseStudentInfo(teacherId);
                courseStudentInfoPanelInit(studentInfos);
            } else if (e.getActionCommand().equals("学生成绩")) {
                String[] colName = {" ", "学号", "学生姓名", "课程名", "分数"};
                List<StudentGradeInfo> studentGradeInfos = teacherMapper.queryCourseStudentGrade(teacherId);
                String[][] tableData = new String[studentGradeInfos.size() + 1][colName.length];
                for (int i = 0; i < studentGradeInfos.size(); i++) {
                    tableData[i][0] = (i + 1) + "";
                    tableData[i][1] = studentGradeInfos.get(i).getId() + "";
                    tableData[i][2] = studentGradeInfos.get(i).getName();
                    tableData[i][3] = studentGradeInfos.get(i).getCourseName();
                    tableData[i][4] = studentGradeInfos.get(i).getGrade() + "";
                }
                courseStudentGradePanelInit(colName,tableData);
            }
        }
    }

    //搜索功能  个人
    public class SearchBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("搜索姓名")) {
                String name = searchNameText.getText();
                List<Student> studentInfos = studentMapper.queryStudentInfosByName(name);
                studentInfoPanelInit(studentInfos);
            } else if (e.getActionCommand().equals("搜索学号")) {
                String[] colName = {" ", "学号", "学生姓名", "课程名", "分数"};
                List<StudentGradeInfo> studentGradeInfos;
                String studentId = searchStudentIdText.getText();
                if (studentId.equals("")) {
                    studentGradeInfos = courseResultMapper.queryStudentGradesByTeacherId(teacherId);
                } else {
                    studentGradeInfos = courseResultMapper.queryStudentGradesByTeacherIdAndStudentId(teacherId, Integer.parseInt(studentId));
                }
                String[][] tableData = new String[studentGradeInfos.size() + 1][colName.length];
                for (int i = 0; i < studentGradeInfos.size(); i++) {
                    tableData[i][0] = (i + 1) + "";
                    tableData[i][1] = studentGradeInfos.get(i).getId() + "";
                    tableData[i][2] = studentGradeInfos.get(i).getName();
                    tableData[i][3] = studentGradeInfos.get(i).getCourseName();
                    tableData[i][4] = studentGradeInfos.get(i).getGrade() + "";
                }
                studentGradePanelInit(colName, tableData);
            } else if (e.getActionCommand().equals("查看单科排名")) {
                String[] colName = {" ", "学号", "学生姓名", "课程名", "分数"};
                List<StudentGradeInfo> studentGradeInfos;
                String courseName = searchCourseRankText.getText();
                if (courseName.equals("")) {
                    studentGradeInfos = courseResultMapper.queryStudentGradesByTeacherId(teacherId);
                } else {
                    studentGradeInfos = courseResultMapper.queryCourseRankingByTeacherId(teacherId, courseName);
                }
                String[][] tableData = new String[studentGradeInfos.size() + 1][colName.length];
                for (int i = 0; i < studentGradeInfos.size(); i++) {
                    tableData[i][0] = (i + 1) + "";
                    tableData[i][1] = studentGradeInfos.get(i).getId() + "";
                    tableData[i][2] = studentGradeInfos.get(i).getName();
                    tableData[i][3] = studentGradeInfos.get(i).getCourseName();
                    tableData[i][4] = studentGradeInfos.get(i).getGrade() + "";
                }
                studentGradePanelInit(colName, tableData);
            } else if(e.getActionCommand().equals("searchStudentId_course")){
                String[] colName = {" ", "学号", "学生姓名", "课程名", "分数"};
                List<StudentGradeInfo> studentGradeInfos;
                String searchStudentId=searchStudentIdText.getText();
                if(searchStudentId.equals("")){
                    studentGradeInfos = teacherMapper.queryCourseStudentGrade(teacherId);
                }else{
                    studentGradeInfos=teacherMapper.querySpecialCourseStudentGrade(teacherId,Integer.parseInt(searchStudentId));
                }
                String[][] tableData = new String[studentGradeInfos.size() + 1][colName.length];
                for (int i = 0; i < studentGradeInfos.size(); i++) {
                    tableData[i][0] = (i + 1) + "";
                    tableData[i][1] = studentGradeInfos.get(i).getId() + "";
                    tableData[i][2] = studentGradeInfos.get(i).getName();
                    tableData[i][3] = studentGradeInfos.get(i).getCourseName();
                    tableData[i][4] = studentGradeInfos.get(i).getGrade() + "";
                }
                courseStudentGradePanelInit(colName,tableData);
            }
        }
    }

}
