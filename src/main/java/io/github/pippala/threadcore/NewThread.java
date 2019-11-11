package io.github.pippala.threadcore;

/**
 * 线程新启动方式：
 * 1.继承 Thread类
 * 2.实现 Runnable接口
 *
 * Thread 源码73行说明了这两种新建方式
 *
 * @author pippala-mj
 * @create 2019-11-11 16:30
 **/
public class NewThread {

    static class UseThread extends Thread{
        @Override
        public void run() {
            System.out.println("继承 Thread 的线程");
        }
    }

    static class UseRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("实现 Runnable 的线程");
        }
    }

    public static void main(String[] args) {
        UseThread useThread = new UseThread();
        useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();
    }


}
