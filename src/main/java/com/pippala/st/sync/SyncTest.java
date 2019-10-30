package com.pippala.st.sync;

public class SyncTest {

    //使用类锁
    private static class SyncClass extends Thread{
        @Override
        public void run() {
            System.out.println("SyncClass is running......");
            super.run();
        }
    }

    private static class InstanceSyn implements Runnable{
        @Override
        public void run() {
            System.out.println();
        }
    }
}
