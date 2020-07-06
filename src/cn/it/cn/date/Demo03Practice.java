package cn.it.cn.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03Practice {

    public static void main(String[] args) throws ParseException {

        //出生日期
        String begin = "1997-07-06";
        //当前日期
        String now = "2020-06-12";
        //创建DateFormat对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //日期转换为毫秒
        Date date1 = df.parse(begin);
        Date date2 = df.parse(now);
        System.out.println(date1);

        System.out.println(date1.getTime());

        long l = date2.getTime() - date1.getTime();

        //计算出生到现在过了多少天
        long l1 = l / (60 * 60 * 24 * 1000);
        System.out.println("出生到现在共经历了"+l1+"天");


        //System.out.println(date2-date1);
    }
}
