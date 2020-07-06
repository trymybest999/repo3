package cn.it.cn.thread;

public class WaitingTest {

    public static Object obj = new Object();
    public static void main(String[] args) {
// 演示waiting
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        try {
                            System.out.println( Thread.currentThread().getName() +"=== 获取到锁对 象，调用wait方法，进入waiting状态，释放锁对象");
                                    obj.wait(); //无限等待
//obj.wait(5000); //计时等待, 5秒 时间到，自动醒来
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println( Thread.currentThread().getName() + "=== 从waiting状 态醒来，获取到锁对象，继续执行了");
                    }
                }
            }
        },"等待线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
// while (true){ //每隔3秒 唤醒一次
                try {
                    System.out.println( Thread.currentThread().getName() +"‐‐‐‐‐ 等待3秒钟");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println( Thread.currentThread().getName() +"‐‐‐‐‐ 获取到锁对 象,调用notify方法，释放锁对象");
                            obj.notify();
                }
            }
// }
        },"唤醒线程").start();
    }
}
