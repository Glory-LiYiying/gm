package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dao.TeacherMapper;
import com.my.gradeMag.dto.StudentGradeInfo;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GradeView extends JFrame implements ActionListener {

    private JTextField searchCourseNameText;

    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    private CourseResultMapper courseResultMapper;
    private CourseMapper courseMapper;


    public GradeView(){
        initDao();
        initView(new String[]{"序号","学号","姓名","课程名","成绩"}, new String[][]{});
        this.setTitle("成绩界面");
        this.setBounds(550,60,650,650);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        courseResultMapper=sqlSession.getMapper(CourseResultMapper.class);
        courseMapper=sqlSession.getMapper(CourseMapper.class);
    }

    public void initView(String[] colName,String[][] tableData){
        getContentPane().removeAll();
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new FlowLayout());

        JLabel courseNamelabel = new JLabel("课程名");
        searchCourseNameText = new JTextField(10);
        JButton searchCourseNameBtn = new JButton("搜索课程名");
        searchCourseNameBtn.addActionListener(this);

        Box baseBox = Box.createVerticalBox();
        Box componentBoxs= Box.createHorizontalBox();
        componentBoxs.add(courseNamelabel);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchCourseNameText);
        componentBoxs.add(Box.createHorizontalStrut(10));
        componentBoxs.add(searchCourseNameBtn);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "搜索课程名":{
                String courseName=searchCourseNameText.getText();
                String[] colName = {"序号", "学号", "姓名", "课程名", "成绩"};
                String[][] tableData;
                if(courseName.equals("")){
                    tableData=new String[0][colName.length];
                }else {
                    Integer courseId=courseMapper.queryCourseIdByName(courseName);
                    if(courseId==null){
                        JOptionPane.showMessageDialog(null,"查询失败\n系统中不存在该课程名","出错",JOptionPane.ERROR_MESSAGE);
                        break;
                    }else{
                        List<StudentGradeInfo> gradeInfos = courseResultMapper.queryCourseGradeByCourseId(courseId);
                        tableData=new String[gradeInfos.size()][colName.length];
                        for (int i = 0; i < gradeInfos.size(); i++) {
                            tableData[i][0]=(i+1)+"";
                            tableData[i][1]=gradeInfos.get(i).getId()+"";
                            tableData[i][2]=gradeInfos.get(i).getName();
                            tableData[i][3]=gradeInfos.get(i).getCourseName();
                            tableData[i][4]=gradeInfos.get(i).getGrade()+"";
                        }
                    }
                }
                initView(colName,tableData);
                break;
            }
        }
    }
}
