package cn.it.cn.date;

import java.util.Date;

public class Demo01Date {

    public static void main(String[] args) {
        //创建日期对象，把当前的毫秒值转成日期对象
        System.out.println(new Date());
        System.out.println(new Date(0L));
    }
}
