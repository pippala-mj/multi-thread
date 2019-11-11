package io.github.pippala.threadcore.safeend;

/**
 * 继承Thread类的线程安全退出使用
 *
 * @author pippala-mj
 * @create 2019-11-11 17:06
 **/
public class EndUseThread {
    static class UseThread extends Thread{
        @Override
        public void run() {
            while (!isInterrupted()){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()
                            +" in InterruptedException interrupt flag is "
                            +isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }
                System.out.println(getName() + "是继承 Thread 的线程");
            }
            System.out.println(getName() + "interrupt 标志位是 " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        useThread.setName("endThread");
        useThread.start();
        Thread.sleep(100);
        useThread.interrupt();
    }
}
