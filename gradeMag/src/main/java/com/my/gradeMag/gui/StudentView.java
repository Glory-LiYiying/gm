package com.my.gradeMag.gui;

import com.my.gradeMag.dao.CourseResultMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dto.StudentGradeInfo;
import com.my.gradeMag.entity.Student;
import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.List;

public class StudentView extends JFrame implements MouseListener {

    JMenuBar menubar;   //菜单条
    JMenu queryGradeMenu;
    JMenu acotMenu;
    JMenuItem updateInfoItem,updatepswItem;   //子菜单
    JTable table;
    JButton updateInfoBtn,updatePswBtn;
    JScrollPane scrollPane;
    JPanel updateInfoPanel,updatePswPanel;
    Integer studentId;   //id为该学生的学号，SQL为sql语句
    String data[][];   //data为table中的数据
    String col[]={"学生","课程","分数"};    //col为table的列名

    JTextField infoInputs[]=new JTextField[5];
    JPasswordField originPswInput,newPswInput,confirmPswInput;
    int w=0,x=0,y=0;

    private SqlSession sqlSession;
    private CourseResultMapper courseResultMapper;
    private StudentMapper studentMapper;
    
    /**
     * 构造方法
     * 参数i为该学生的输入的学号
     * */
    public StudentView(Integer studentId,String name){
        this.studentId=studentId;
        initDao();
        infoAndPswpanel();
        initView();
        setLayout(new FlowLayout());
        setVisible(true);
        setTitle("学生成绩管理   欢迎您,"+name);
        setBounds(500,10,600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void initView(){
        menubar=new JMenuBar();
        queryGradeMenu=new JMenu("成绩查询");
        queryGradeMenu.addMouseListener(this);
        acotMenu=new JMenu("个人中心");
        updateInfoItem=new JMenuItem("修改个人信息");
        updateInfoItem.addMouseListener(this);
        updatepswItem=new JMenuItem("修改密码");
        updatepswItem.addMouseListener(this);
        acotMenu.add(updateInfoItem);
        acotMenu.add(updatepswItem);
        menubar.add(queryGradeMenu);
        menubar.add(acotMenu);
        setJMenuBar(menubar);

    }

    /**
     * 修改个人信息和修改密码的两个面板
     * */
    public void infoAndPswpanel(){
        //修改个人信息的面板
        updateInfoPanel=new JPanel();
        updateInfoBtn=new JButton("提交");
        updateInfoPanel.setLayout(new FlowLayout());
        Box[] infoBox=new Box[7];
        for(int i=0;i<7;i++){
            infoBox[i]=Box.createHorizontalBox();
        }
        Box basebox=Box.createVerticalBox();
        JLabel[] infoLabels=new JLabel[5];
        infoLabels[0]=new JLabel("学号");
        infoLabels[1]=new JLabel("姓名");
        infoLabels[2]=new JLabel("性别");
        infoLabels[3]=new JLabel("班级");
        infoLabels[4]=new JLabel("电话");
        infoInputs[0]=new JTextField(10);
        infoInputs[1]=new JTextField(10);
        infoInputs[2]=new JTextField(10);
        infoInputs[3]=new JTextField(10);
        infoInputs[4]=new JTextField(10);
        Student studentInfo=studentMapper.queryStudentInfo(studentId);
        infoInputs[0].setText(studentId+"");
        infoInputs[1].setText(studentInfo.getName());
        infoInputs[2].setText(studentInfo.getSex());
        infoInputs[3].setText(studentInfo.getClassId()+"");
        infoInputs[4].setText(studentInfo.getTel());
        infoInputs[0].setEditable(false);  //学号文本框不能编辑
        infoBox[0].add(infoLabels[0]);
        infoBox[0].add(Box.createHorizontalStrut(40));
        infoBox[0].add(infoInputs[0]);
        infoBox[1].add(infoLabels[1]);
        infoBox[1].add(Box.createHorizontalStrut(40));
        infoBox[1].add(infoInputs[1]);
        infoBox[2].add(infoLabels[2]);
        infoBox[2].add(Box.createHorizontalStrut(40));
        infoBox[2].add(infoInputs[2]);
        infoBox[3].add(infoLabels[3]);
        infoBox[3].add(Box.createHorizontalStrut(40));
        infoBox[3].add(infoInputs[3]);
        infoBox[4].add(infoLabels[4]);
        infoBox[4].add(Box.createHorizontalStrut(40));
        infoBox[4].add(infoInputs[4]);

        for(int i=0;i<5;i++){
            basebox.add(Box.createVerticalStrut(40));
            basebox.add(infoBox[i]);
        }
        basebox.add(Box.createVerticalStrut(40));
        basebox.add(updateInfoBtn);
        updateInfoPanel.add(basebox);
        updateInfoBtn.addMouseListener(this);
        //修改密码的面板
        updatePswPanel=new JPanel();
        updatePswPanel.setLayout(new FlowLayout());
        JLabel originPswLabel=new JLabel("原密码：");
        JLabel newPswLabel=new JLabel("新密码：");
        JLabel confirmPswLabel=new JLabel("确认密码：");
        originPswInput=new JPasswordField(10);
        newPswInput=new JPasswordField(10);
        confirmPswInput=new JPasswordField(10);
        updatePswBtn=new JButton("提交");
        Box pswBox[]=new Box[4];
        Box basebox1=Box.createVerticalBox();
        for(int a=0;a<4;a++){
            pswBox[a]=Box.createHorizontalBox();
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
        for(int a=0;a<4;a++){
            basebox1.add(Box.createVerticalStrut(40));
            basebox1.add(pswBox[a]);
        }
        updatePswPanel.add(basebox1);
        updatePswBtn.addMouseListener(this);
    }

    private void initDao(){
        sqlSession = MybatisUtils.getSqlSession();
        courseResultMapper = sqlSession.getMapper(CourseResultMapper.class);
        studentMapper=sqlSession.getMapper(StudentMapper.class);
    }


    public void mousePressed(MouseEvent a){
        if(w==1){
            remove(scrollPane);
            w=0;
        }
        if(x==1){
            remove(updateInfoPanel);
            x=0;

        }
        if(y==1){
            remove(updatePswPanel);
            y=0;
        }
        //点击成绩查询后，显示学生成绩
        if(a.getSource()==queryGradeMenu){
            List<StudentGradeInfo> studentGradeInfos = courseResultMapper.queryStudentGrade(studentId);
            data=new String[studentGradeInfos.size()][col.length];
            for (int i = 0; i < studentGradeInfos.size(); i++) {
                data[i][0]=studentGradeInfos.get(i).getName();
                data[i][1]=studentGradeInfos.get(i).getCourseName();
                data[i][2]=studentGradeInfos.get(i).getGrade()+"";
            }

            table=new JTable(data,col);  //设置表格
            scrollPane=new JScrollPane(table);  //设置滚动面板
            scrollPane.setBackground(Color.BLACK);
            w=1;
            table.repaint();
            add(scrollPane);
            repaint();
            validate();
        }
        //点击修改个人信息后
        if(a.getSource()==updateInfoItem){
            add(updateInfoPanel);
            x=1;
            repaint();
            validate();
        }
        //点击修改个人信息的提交后
        if(a.getSource()==updateInfoBtn){
            Student student=new Student();
            student.setId(studentId);
            student.setName(infoInputs[1].getText());
            student.setSex(infoInputs[2].getText());
            student.setClassId(infoInputs[3].getText());
            student.setTel(infoInputs[4].getText());

            if(studentMapper.updateStudentInfo(student)>0){
                sqlSession.commit();
                JOptionPane.showMessageDialog(this,"修改成功","修改成功",JOptionPane.OK_CANCEL_OPTION);
            } else {
                JOptionPane.showMessageDialog(this, "修改失败", "出错", JOptionPane.ERROR_MESSAGE);
                sqlSession.rollback();

            }
        }
        //点击修改密码后
        if(a.getSource()==updatepswItem){
            add(updatePswPanel);
            y=1;
            repaint();
            validate();
        }
        //点击修改密码的提交后
        if(a.getSource()==updatePswBtn){
            String oldPwd=String.valueOf(originPswInput.getPassword());
            if(studentMapper.checkStudentPsw(studentId,oldPwd)>0){
                String newPsw1=String.valueOf(newPswInput.getPassword());
                String newPsw2=String.valueOf(confirmPswInput.getPassword());
                if(newPsw1.equals(newPsw2)){
                    if(studentMapper.updateStudentPsw(studentId,newPsw1)>0){
                        sqlSession.commit();
                        JOptionPane.showMessageDialog(this,"修改成功","修改成功",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        originPswInput.setText("");
                        newPswInput.setText("");
                        confirmPswInput.setText("");
                        JOptionPane.showMessageDialog(this,"修改失败","出错",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    originPswInput.setText("");
                    newPswInput.setText("");
                    confirmPswInput.setText("");
                    JOptionPane.showMessageDialog(this,"两次输入的新密码不一致","出错",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                originPswInput.setText("");
                newPswInput.setText("");
                confirmPswInput.setText("");
                JOptionPane.showMessageDialog(null,"输入的原密码错误","出错",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void mouseReleased(MouseEvent a){}
    public void mouseEntered(MouseEvent a){}
    public void mouseExited(MouseEvent a){}
    public void mouseClicked(MouseEvent a){}



}
