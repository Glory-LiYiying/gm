/*
 * Created by JFormDesigner on Tue May 18 17:17:39 CST 2021
 */

package com.my.gradeMag.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

import com.my.gradeMag.constants.AppConstants;
import com.my.gradeMag.dao.AdminMapper;
import com.my.gradeMag.dao.StudentMapper;
import com.my.gradeMag.dao.TeacherMapper;

import com.my.gradeMag.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


public class LoginView extends JFrame implements ActionListener{

    private JTextField username;
    private JPasswordField password;

    private byte loginRole=0;     //0:admin   1:teacher   2:student

    private AdminMapper adminMapper;
    private TeacherMapper teacherMapper;
    private StudentMapper studentMapper;

    public LoginView() {
    	initView();
    	initDaoComponent();
    }

    //初始化视图
    public void initView(){
        //获取容器
        Container container = getContentPane();
        container.setLayout(null);
        ((JPanel) container).setOpaque(false);

        //添加Logo
        JLabel logoLabel = new JLabel(AppConstants.LOGIN_LOGO);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBounds(0, 0, 500, 100);
        container.add(logoLabel);

        //添加用户名行
        JLabel userLabel = new JLabel(AppConstants.LOGIN_USERNAME);
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setBounds(10, 100, 250, 30);
        container.add(userLabel);
        username = new JTextField();
        username.setBounds(250, 100, 200, 30);
        container.add(username);

        //添加密码行
        JLabel passwordLabel = new JLabel(AppConstants.LOGIN_PASSWORD);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setBounds(10, 140, 250, 30);
        container.add(passwordLabel);
        password = new JPasswordField();
        password.setBounds(250, 140, 200, 30);
        container.add(password);

        //添加登录按钮
        JButton loginButton = new JButton(AppConstants.LOGIN);
        loginButton.setBounds(128, 272, 100, 30);
        loginButton.addActionListener(e ->
                this.check());
        container.add(loginButton);

        //添加重置按钮
        JButton resetButton = new JButton(AppConstants.RESET);
        resetButton.setBounds(278, 272, 100, 30);
        resetButton.addActionListener(e ->
        {
            username.setText("");
            password.setText("");
        });
        container.add(resetButton);

        //选择登录角色按钮
        JRadioButton adminRadioBtn = new JRadioButton("管理员");
        adminRadioBtn.setFont(new Font("宋体", Font.PLAIN, 14));
        adminRadioBtn.setBounds(115, 215, 100, 23);
        adminRadioBtn.setSelected(true);
        adminRadioBtn.addActionListener(this);
        getContentPane().add(adminRadioBtn);

        JRadioButton teacherRadioBtn = new JRadioButton("教师");
        teacherRadioBtn.setFont(new Font("宋体", Font.PLAIN, 14));
        teacherRadioBtn.setBounds(229, 215, 100, 23);
        teacherRadioBtn.addActionListener(this);
        getContentPane().add(teacherRadioBtn);

        JRadioButton studentRadioBtn = new JRadioButton("学生");
        studentRadioBtn.setFont(new Font("宋体", Font.PLAIN, 14));
        studentRadioBtn.setBounds(344, 215, 127, 23);
        studentRadioBtn.addActionListener(this);
        getContentPane().add(studentRadioBtn);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(adminRadioBtn);
        buttonGroup.add(teacherRadioBtn);
        buttonGroup.add(studentRadioBtn);


        setTitle(AppConstants.LOGIN_TITLE);
        setSize(500, 379);
        setVisible(true);
        setResizable(false);
        setLocation(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //初始化Dao组件
    public void initDaoComponent(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        adminMapper=sqlSession.getMapper(AdminMapper.class);
        teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        studentMapper=sqlSession.getMapper(StudentMapper.class);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="管理员"){
            loginRole=0;
        }else if(e.getActionCommand()=="教师"){
            loginRole=1;
        }else{
            loginRole=2;
        }
    }

    private void check() {
        String user=null;

        if(loginRole==0){
            user=adminMapper.queryAcotAndPsw(username.getText(),String.valueOf(password.getPassword()));
        }else if(loginRole==1){
            user=teacherMapper.queryAcotAndPsw(Integer.parseInt(username.getText()),String.valueOf(password.getPassword()));
        }else{
            user=studentMapper.queryAcotAndPsw(Integer.parseInt(username.getText()),String.valueOf(password.getPassword()));
        }
        if(user!=null){
            if(loginRole==0){
                new AdminView(user);
            }else if(loginRole==1){
                new TeacherView(Integer.parseInt(username.getText()),user);
            }else{
                new StudentView(Integer.parseInt(username.getText()),user);
            }
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"账号密码错误","登录失败",JOptionPane.ERROR_MESSAGE);
        }
        username.setText("");
        password.setText("");
    }


}
