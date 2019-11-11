package io.github.pippala.threadcore;

/**
 * join的使用
 *
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 *
 * @author pippa pippala-mj
 * @create 2019-11-11 17:46
 **/
public class UseJoin {
    private static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("线程t1");
        }
    }

    private static class T2 extends Thread{
        @Override
        public void run() {
            T1 t1 = new T1();
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程t2");
        }
    }

    private static class T3 extends Thread{
        @Override
        public void run() {
            T2 t2 = new T2();
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程t3");
        }
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.start();
    }
}
