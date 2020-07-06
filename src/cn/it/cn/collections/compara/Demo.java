package cn.it.cn.collections.compara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {
// 创建四个学生对象 存储到集合中
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("rose",18));
        list.add(new Student("jack",16));
        list.add(new Student("abc",16));
        list.add(new Student("ace",17));
        list.add(new Student("mark",16));
/*
让学生 按照年龄排序 升序
*/
 //Collections.sort(list);//要求 该list中元素类型 必须实现比较器Comparable接口

        Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getAge()-o1.getAge();
                    }
                }
        );
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

