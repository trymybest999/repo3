package cn.it.cn.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02SimpleDateFormat {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2020年06月09日";
        System.out.println(format.format(date));
        System.out.println(dateFormat.format(date));
        Date date1  = dateFormat.parse(str);
        System.out.println(format.format(date1));
    }
}
