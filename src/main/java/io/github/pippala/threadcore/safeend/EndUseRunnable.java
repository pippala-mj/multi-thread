package io.github.pippala.threadcore.safeend;

/**
 * 实现Runnable接口的线程安全退出使用
 *
 * @author pippa pippala-mj
 * @create 2019-11-11 17:21
 **/
public class EndUseRunnable {
    private static class UseRunnable implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + "");
            }
            System.out.println(Thread.currentThread().getName() + "interrupt 标志位是 " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread thread = new Thread(useRunnable,"useRunnable");
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
