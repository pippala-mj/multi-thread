package com.pippala.st.sync;

import lombok.Synchronized;

public class SynClzAndInst {
    //类锁 类的class对象
    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println("TestClass is running");
        }
    }

    //对象锁
    private static class InstanceSyn implements Runnable{
        private SynClzAndInst synClzAndInst;

        @Override
        public void run() {
            System.out.println("TestInstance is running...." + synClzAndInst);
            try {
                synClzAndInst.instance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public InstanceSyn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }
    }

    private static class Instance2Syn implements Runnable{
        private SynClzAndInst synClzAndInst;

        @Override
        public void run() {
            System.out.println("TestInstance2 is running...." + synClzAndInst);
            try {
                synClzAndInst.instance2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Instance2Syn(SynClzAndInst synClzAndInst) {
            this.synClzAndInst = synClzAndInst;
        }
    }

    private synchronized void instance() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("SynInstance is going..." + this.toString());
        Thread.sleep(3000);
        System.out.println("SynInstance is ended..." + this.toString());

    }

    private synchronized void instance2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("SynInstance2 is going..." + this.toString());
        Thread.sleep(3000);
        System.out.println("SynInstance2 is ended..." + this.toString());

    }

    private static synchronized void synClass() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("SynInstance2 is going...");
        Thread.sleep(1000);
        System.out.println("SynInstance2 is ended...");

    }

    public static void main(String[] args) throws InterruptedException {
        SynClzAndInst synClzAndInst1 = new SynClzAndInst();
        Thread thread1 = new Thread(new InstanceSyn(synClzAndInst1));

        SynClzAndInst synClzAndInst2 = new SynClzAndInst();
        Thread thread2 = new Thread(new InstanceSyn(synClzAndInst1));

        thread1.start();
        thread2.start();

        Thread.sleep(1000);

    }


}
