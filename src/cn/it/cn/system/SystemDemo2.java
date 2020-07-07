package cn.it.cn.system;

public class SystemDemo2 {

    /**
     * 练习：验证for循环打印数字1-9999所需要使用的时间（毫秒）
     * @param args
     */
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        //long l = (l2 - l1) / 1000;
        //System.out.println(l);

    }
}
