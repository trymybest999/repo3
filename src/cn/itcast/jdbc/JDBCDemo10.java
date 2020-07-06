package cn.itcast.jdbc;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo10 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1. 获取数据库连接对象
            conn = JDBCUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);
            //2. 定义sql语句
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3. 获取数据库连接对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4. 设置参数
            //4.1 张三-500
            pstmt1.setDouble(1,500);
            pstmt1.setDouble(2,1);
            //4.2 李四 +500
            pstmt2.setDouble(1,500);
            pstmt2.setDouble(2,2);
            //5.执行sql语句
            int count1 = pstmt1.executeUpdate();

            int i = 3/0;//手动制造异常

            int count2 = pstmt2.executeUpdate();

            System.out.println(count1+"----"+count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
           //回滚事务
            try {
                if(conn != null)
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //6. 释放资源
            if(pstmt1 != null){
                try {
                    pstmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(pstmt2 != null){
                try {
                    pstmt2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


