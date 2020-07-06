package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;


public class JDBCDemo8 {

    public static void main(String[] args) {

        /**
         * 调用findAll2()方法实现
         */
        ArrayList<Emp> list = new ArrayList<>();
        list = findAll2();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        System.out.println(list.size());
    }

    /**
     *
     * @return List
     */
    public static ArrayList<Emp> findAll2(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        ArrayList<Emp> list = new ArrayList<>();
        //1. 导入驱动jar包
        //2. 注册驱动--->JDBCUtils的静态方法实
        try {
            //3. 获取数据库连接对象
            conn = JDBCUtils.getConnection();

            //4.定义sql语句
            String sql = "Select * From emp";

            //5.获取执行sql的对象 Stamentate
            stmt = conn.createStatement();

            //6. 执行sql
            res = stmt.executeQuery(sql);

            //7. 循环判断游标是否是最后一行
            while(res.next()){
                Emp emp = new Emp();
//                ArrayList<Emp> list = new ArrayList<>();

                int id = res.getInt("id");
                String ename = res.getString("ename");
                int job_id = res.getInt("job_id");
                int mgr = res.getInt("mgr");
                Date joindate = res.getDate("joindate");
                double salary = res.getDouble("salary");
                double bonus = res.getDouble("bonus");
                int dept_id = res.getInt("dept_id");

                System.out.println("这是为了测试代码更新后如何上传到GitHub");

                //emp对象的成员变量分别赋值
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                list.add(emp);
            }

            //8.释放资源
            JDBCUtils.close(res,stmt,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
