package com.pippala.st.safeend;


/**
 *
 * zhong
 */
public class EndThread{
    private static class MyThread extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println(threadName+" is run");
            }
            System.out.println(threadName + " state is " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
    }
}
