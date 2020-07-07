package cn.it.cn.object;

public class TestEquals {

    public static void main(String[] args) {
        Student stu = new Student("Simba", 22);
        Student stu1 = new Student("Milk~~", 22);
        Student stu2 = new Student("Simba", 22);
        boolean equals1 = stu.equals(stu1);
        System.out.println(equals1);
        boolean equals2 = stu.equals(stu2);
        System.out.println(equals2);
        System.out.println("stu.getClass()="+stu.getClass());
        System.out.println("stu1.getClass()="+stu1.getClass());
    }
}
