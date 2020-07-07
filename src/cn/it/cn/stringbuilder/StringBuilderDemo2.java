package cn.it.cn.stringbuilder;

import java.sql.SQLOutput;

public class StringBuilderDemo2 {

    /**
     * 测试StringBuilder类的成员方法
     * @param args
     */
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();
        //public StringBuilder append(任意类型)
        StringBuilder sb2 = sb.append("hello");
        //对比一下
        System.out.println("sb="+sb);
        System.out.println("sb2="+sb2);
        System.out.println(sb == sb2);

        // 可以添加 任何类型
        sb.append("hello");
        sb.append("world");
        sb.append(true);
        sb.append(100);

        System.out.println(sb);
// 在我们开发中，会遇到
    }
}
