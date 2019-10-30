package com.pippala.st.safeend;


/**
 * 方法跑出InterruptedException异常时，线程的中断标志位会被复位为false
 *
 * 需要手动再调用interrupt方法
 */
public class HasInterruptedException {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " state is " + isInterrupted());
                    e.printStackTrace();
                    interrupt();
                }
                System.out.println(threadName+" is run");
            }
            System.out.println(threadName + " state is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HasInterruptedException.MyThread thread = new HasInterruptedException.MyThread();
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
