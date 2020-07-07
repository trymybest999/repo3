package cn.it.cn.calendar;
import java.util.Calendar;

public class CalendarDemo2 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();

        System.out.println("Year="+instance.get(Calendar.YEAR));
        System.out.println("MONTH="+ instance.get(Calendar.MONTH));

        instance.set(Calendar.YEAR,2012);
        System.out.println(instance.get(Calendar.YEAR));
    }
}
