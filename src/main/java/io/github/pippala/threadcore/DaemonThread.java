package io.github.pippala.threadcore;

/**
 * 守护线程
 *
 * @author pippala-mj
 * @create 2019-11-11 16:30
 **/
public class DaemonThread {
    static class Daemon extends Thread{
        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(Thread.currentThread().getName() + "守护线程");
                }
            } finally {
                System.out.println("守护线程finally不一定起作用");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Daemon daemon = new Daemon();
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(500);
    }
}
