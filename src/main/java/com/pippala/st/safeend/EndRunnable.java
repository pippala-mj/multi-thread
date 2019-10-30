package com.pippala.st.safeend;

public class EndRunnable {
    private static class UseRun implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            String threadName = thread.getName();
            while (!thread.isInterrupted()) {
                System.out.println(threadName + "interrupt flag is " + thread.isInterrupted());
            }
            System.out.println(threadName + "interrupt flag is " + thread.isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new UseRun());
        //线程优先级
        thread.setPriority(1);
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
