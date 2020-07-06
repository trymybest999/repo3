package cn.itcast.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {


        try {
            //创建Properties集合类
            Properties pro = new Properties();

            //获取src路径下文件的方式--->ClassLoader 加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
           // System.out.println("jdbc.properties配置文件的绝对路径"+path);

            //2. 加载文件
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //3. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /*
     * 获取连接
     */

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源方法
     * @param stmt
     * @param conn
     */

    public static void close(Statement stmt,Connection conn){

        if(stmt != null){
            try {
                stmt.close();
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

    /**
     * 释放资源方法重载
     * @param res
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet res,Statement stmt,Connection conn){

        if(res != null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
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
