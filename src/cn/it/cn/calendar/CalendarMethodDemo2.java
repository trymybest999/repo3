package cn.it.cn.calendar;

import java.util.Calendar;

public class CalendarMethodDemo2 {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(instance.get(Calendar.MONTH));
        System.out.println(instance.get(Calendar.YEAR)+"年"+instance.get(Calendar.MONTH)+"月"+instance.get(Calendar.DAY_OF_MONTH)+"日");
        //使用add方法
        instance.add(Calendar.YEAR,-22);
        instance.add(Calendar.MONTH,5);
        instance.add(Calendar.DAY_OF_MONTH,0);
        System.out.println(instance.get(Calendar.YEAR)+"年"+instance.get(Calendar.MONTH)+"月"+instance.get(Calendar.DAY_OF_MONTH)+"日");
    }
}
