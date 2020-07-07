package cn.it.cn.system;

public class SystemDemo3 {
    public static void main(String[] args) {

        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};

        System.arraycopy(src,0,dest,0,3);

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }

    }
}
