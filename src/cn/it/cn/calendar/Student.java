package cn.it.cn.calendar;

import java.util.Calendar;



public class Student {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        //public int get(int field)
        int i = instance.get(Calendar.DATE);
        System.out.println(instance.ZONE_OFFSET);
        System.out.println(i);
    }
}
