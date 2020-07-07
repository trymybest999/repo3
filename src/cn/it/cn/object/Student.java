package cn.it.cn.object;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //如果对象地址一样，则认为相同
        if (this == obj) {
            return true;
        }
        //如果参数为空，或者信息不一样，则认为不同
        if (obj == null || getClass() != obj.getClass()) return false;
        //转换为当前类型
        Student student = (Student) obj;
        //要求基本类型相等，并且将引用类型交给java.util.Objects类的静态方法取用结果
        return age == student.age && Objects.equals(name,student.name);
    }
}
