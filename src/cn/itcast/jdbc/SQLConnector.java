package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

    public static void main(String[] args) {
        String userName = "sa"; //用户名
        String userPwd = "root"; //密码
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //获取连接
            //Connection connection = DriverManager.getConnection("jdbc:sqlserver://101.37.83.223:1433;integratedSecurity=true; DatabaseName=CityGeo",userName,userPwd);
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true; DatabaseName=qingdaoZK",userName,userPwd);
            Statement statement = connection.createStatement();
             String sql = "SELECT HOLEID from EgHole where HOLEID = 1;";
            statement.execute(sql);//执行sql语句
            statement.close();
            connection.close();
            System.out.println("创建成功！");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
