package com.pippala.st.daemon;


/**
 *
 * 守护线程：共死
 *
 * finally 语句不一定执行
 */

public class DaemonThread {
    private static class UseThread extends Thread{
        @Override
        public void run() {
            try {
                while (!isInterrupted()){
                    System.out.println("thread is run");
                }
            }finally {
                System.out.println("finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new UseThread();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(10);
    }
}
