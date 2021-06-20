package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseMapper;
import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.entity.CourseResult;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GradeInfoUpdateView extends JFrame implements ActionListener {

    private JTextField studentIdText,courseNameText,studentGradeText,studentNameText,studentClassText;

    private SqlSession sqlSession;
    private StudentMapper studentMapper;
    private CourseMapper courseMapper;
    private CourseResultMapper courseResultMapper;

    public GradeInfoUpdateView(){
        initDao();
        initView();
        this.setTitle("课程信息管理");
        this.setBounds(500,10,530,550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
    }

    public void initDao(){
        sqlSession= MybatisUtils.getSqlSession();
        courseMapper=sqlSession.getMapper(CourseMapper.class);
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        courseResultMapper=sqlSession.getMapper(CourseResultMapper.class);
    }

    public void initView(){
        JPanel totalPanel = new JPanel(new BorderLayout());
        JPanel searchPanel=new JPanel(new FlowLayout());
        JPanel mainPanel=new JPanel(new FlowLayout());

        Box baseBox = Box.createVerticalBox();
        Box searchBox=Box.createHorizontalBox();
        Box searchParentBox=Box.createVerticalBox();
        Box[] componentBoxs=new Box[5];


        JLabel studentIdlabel = new JLabel("学号");
        studentIdText = new JTextField(10);
        searchBox.add(studentIdlabel);
        searchBox.add(Box.createHorizontalStrut(10));
        searchBox.add(studentIdText);
        searchBox.add(Box.createHorizontalStrut(40));

        JLabel courseNamelabel = new JLabel("课程名");
        courseNameText = new JTextField(10);
        searchBox.add(courseNamelabel);
        searchBox.add(Box.createHorizontalStrut(10));
        searchBox.add(courseNameText);
        searchBox.add(Box.createHorizontalStrut(10));

        JButton searchBtn=new JButton("查询");
        searchBtn.setSize(30, 140);
        searchBtn.addActionListener(this);
        searchBox.add(Box.createHorizontalStrut(10));
        searchBox.add(searchBtn);

        searchParentBox.add(Box.createVerticalStrut(40));
        searchParentBox.add(searchBox);
        searchPanel.add(searchParentBox);


        JLabel studentNamelabel = new JLabel("姓名");
        studentNameText = new JTextField(10);
        studentNameText.setEditable(false);
        componentBoxs[0]=Box.createHorizontalBox();
        componentBoxs[0].add(studentNamelabel);
        componentBoxs[0].add(Box.createHorizontalStrut(10));
        componentBoxs[0].add(studentNameText);

        JLabel studentClasslabel = new JLabel("班级");
        studentClassText = new JTextField(10);
        studentClassText.setEditable(false);
        componentBoxs[1]=Box.createHorizontalBox();
        componentBoxs[1].add(studentClasslabel);
        componentBoxs[1].add(Box.createHorizontalStrut(10));
        componentBoxs[1].add(studentClassText);

        JLabel studentGradelabel = new JLabel("成绩");
        studentGradeText = new JTextField(10);
        componentBoxs[2]=Box.createHorizontalBox();
        componentBoxs[2].add(studentGradelabel);
        componentBoxs[2].add(Box.createHorizontalStrut(10));
        componentBoxs[2].add(studentGradeText);


        JButton updateBtn=new JButton("修改");
        JButton insertBtn=new JButton("添加");
        JButton deleteBtn=new JButton("删除");
        updateBtn.addActionListener(this);
        insertBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        componentBoxs[3]=Box.createHorizontalBox();
        componentBoxs[3].add(updateBtn);
        componentBoxs[3].add(Box.createHorizontalStrut(30));
        componentBoxs[3].add(insertBtn);
        componentBoxs[3].add(Box.createHorizontalStrut(30));
        componentBoxs[3].add(deleteBtn);

        JButton resetBtn=new JButton("重置");
        resetBtn.addActionListener(this);
        componentBoxs[4]=Box.createHorizontalBox();
        componentBoxs[4].add(resetBtn);

        for(int i=0;i<componentBoxs.length;i++){
            baseBox.add(Box.createVerticalStrut(40));
            baseBox.add(componentBoxs[i]);
        }
        mainPanel.add(baseBox);

        totalPanel.add(searchPanel,BorderLayout.NORTH);
        totalPanel.add(mainPanel,BorderLayout.CENTER);
        getContentPane().add(totalPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }


    public void reset(){
        studentIdText.setText("");
        courseNameText.setText("");
        studentGradeText.setText("");
        studentNameText.setText("");
        studentClassText.setText("");
    }

    public void query(){
        String studentId=studentIdText.getText();
        if(studentId.equals("")){
            JOptionPane.showMessageDialog(null,"请输入学生学号","出错",JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Student> studentList = studentMapper.queryStudentInfoById(Integer.parseInt(studentId));
        if(studentList.size()==0){
            JOptionPane.showMessageDialog(null,"该学号尚未注册","出错",JOptionPane.ERROR_MESSAGE);
            reset();
            return;
        }
        studentNameText.setText(studentList.get(0).getName());
        studentClassText.setText(studentList.get(0).getClassId());

        String courseName=courseNameText.getText();
        if(courseName.equals("")){
            JOptionPane.showMessageDialog(null,"请输入课程名","出错",JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer courseId=courseMapper.queryCourseIdByName(courseName);
        if(courseId==null){
            JOptionPane.showMessageDialog(null,"系统中暂无该课程","出错",JOptionPane.ERROR_MESSAGE);
            courseNameText.setText("");
            studentGradeText.setText("");
            return;
        }
        CourseResult courseResult= courseResultMapper.queryCourseGradeByStudentId(courseId+"", studentId);
        if(courseResult==null){
            JOptionPane.showMessageDialog(null,"该学生尚未学习该课程\n可通过点击添加让该学生学习该课程","提示",JOptionPane.INFORMATION_MESSAGE);
            studentGradeText.setText("");
            return;
        }
        if(courseResult.getGrade()!=null) {
            studentGradeText.setText(courseResult.getGrade()+"");
        }else{
            studentGradeText.setText("");
        }
    }


    public void update(){
        String courseName=courseNameText.getText();

        if(studentNameText.getText().equals("") || courseName.equals("")){
            JOptionPane.showMessageDialog(null,"请输入已有的学生学号与课程名\n然后点击查询","出错",JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer courseId=courseMapper.queryCourseIdByName(courseName);
        if(courseId==null){
            JOptionPane.showMessageDialog(null,"系统中暂无该课程","出错",JOptionPane.ERROR_MESSAGE);
            courseNameText.setText("");
            studentGradeText.setText("");
            return;
        }

        String studentId=studentIdText.getText();
        CourseResult courseResult= courseResultMapper.queryCourseGradeByStudentId(courseId+"", studentId);
        if(courseResult==null){
            JOptionPane.showMessageDialog(null,"该学生尚未学习该课程\n可通过点击添加让该学生学习该课程","提示",JOptionPane.INFORMATION_MESSAGE);
            studentGradeText.setText("");
            return;
        }

        String grade=studentGradeText.getText();
        if(grade.equals("")){
            JOptionPane.showMessageDialog(null,"请输入学生在该课程中的成绩","提示",JOptionPane.ERROR_MESSAGE);
            return;
        }
        courseResult.setGrade(Integer.parseInt(grade));
        if(courseResultMapper.updateCourseGrade(courseResult)>0){
            JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
            sqlSession.commit();
        }else{
            JOptionPane.showMessageDialog(null,"修改失败","提示",JOptionPane.ERROR_MESSAGE);
            sqlSession.rollback();
        }

    }


    public void delete(){
        String courseName=courseNameText.getText();

        if(studentNameText.getText().equals("") || courseName.equals("")){
            JOptionPane.showMessageDialog(null,"请输入已有的学生学号与课程名\n然后点击查询","出错",JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer courseId=courseMapper.queryCourseIdByName(courseName);
        if(courseId==null){
            JOptionPane.showMessageDialog(null,"系统中暂无该课程","出错",JOptionPane.ERROR_MESSAGE);
            courseNameText.setText("");
            studentGradeText.setText("");
            return;
        }

        String studentId=studentIdText.getText();
        CourseResult courseResult= courseResultMapper.queryCourseGradeByStudentId(courseId+"", studentId);
        if(courseResult==null){
            JOptionPane.showMessageDialog(null,"该学生尚未学习该课程\n无需删除","提示",JOptionPane.INFORMATION_MESSAGE);
            studentGradeText.setText("");
            return;
        }

        if(courseResultMapper.deleteData(courseResult)>0){
            JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
            sqlSession.commit();
            courseNameText.setText("");
            studentGradeText.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
            sqlSession.rollback();
        }

    }

    public void insert(){
        String courseName=courseNameText.getText();

        if(studentNameText.getText().equals("") || courseName.equals("")){
            JOptionPane.showMessageDialog(null,"请输入已有的学生学号与课程名\n然后点击查询","出错",JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer courseId=courseMapper.queryCourseIdByName(courseName);
        if(courseId==null){
            JOptionPane.showMessageDialog(null,"系统中暂无该课程","出错",JOptionPane.ERROR_MESSAGE);
            courseNameText.setText("");
            studentGradeText.setText("");
            return;
        }

        String studentId=studentIdText.getText();
        CourseResult courseResult= courseResultMapper.queryCourseGradeByStudentId(courseId+"", studentId);
        if(courseResult!=null){
            if(courseResult.getGrade()!=null) {
                studentGradeText.setText(courseResult.getGrade()+"");
            }else{
                studentGradeText.setText("");
            }
            JOptionPane.showMessageDialog(null,"该学生已学习该课程\n无需再添加","提示",JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Integer grade=null;
        if(!studentGradeText.getText().equals("")){
            grade=Integer.parseInt(studentGradeText.getText());
        }
        courseResult=new CourseResult(Integer.parseInt(studentId),courseId,grade);
        if(courseResultMapper.insertData(courseResult)>0){
            JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
            sqlSession.commit();
        }else {
            JOptionPane.showMessageDialog(null,"添加失败","提示",JOptionPane.ERROR_MESSAGE);
            sqlSession.rollback();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "查询":{
                query();
                break;
            }
            case "修改":{
                update();
                break;
            }
            case "添加":{
                insert();
                break;
            }
            case "删除":{
                delete();
                break;
            }
            case "重置":{
                reset();
                break;
            }
        }
    }



}
