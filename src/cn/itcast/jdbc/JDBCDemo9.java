package cn.itcast.jdbc;

import cn.itcast.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 需求
 *      1. 通过键盘录入用户名和密码
 *      2. 判断用户是否登陆成功
 */
public class JDBCDemo9 {

    public static void main(String[] args) {
        boolean bool = false;
        //创建键盘录入的对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        //调用JDBCDemo9.login方法进行判断
        boolean flag = new JDBCDemo9().login(username, password);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码错误");
        }

        //1. 键盘输入用户名和密码


    }



    /**
     * 登录方法使用PrepareStatement方法实现
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password) {
        if (username == null && password == null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
//        boolean bool = false;//存放查询结果的boolean


        //1.注册驱动
        //2. 创建数据库连接对象 Connection
        try {
            conn = JDBCUtils.getConnection();
            //3. 书写sql语句
            //String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            String sql = "SELECT * FROM  user where username = ? AND password = ?";
            //4. 创建执行sql语句对象 Statement
//            stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //5. 执行sql语句
            res = pstmt.executeQuery();
            //6. 处理结果
            /*if(res != null){
                bool = true;
                System.out.println(res.getString("user"));
                System.out.println(res.getString("password"));
            }*/
            return res.next();
            //7. 释放资源
//            JDBCUtils.close(res,stmt,conn);
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JDBCUtils.close(res, pstmt, conn);
        }

        return false;

    }

}
