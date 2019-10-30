package com.pippala.st.start;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * java新启线程的方式：
 * 1. 继承Thread
 * 2. 实现Runnable
 * 3，实现Callable
 *
 * java线程终止
 * 1. 自然执行完
 * 2. 抛出异常
 * 3. stop
 * 4. resume
 * 5. suspend 线程不释放资源
 *
 * 6.interrupt()：中断线程，并不是强制关闭线程，将中断标志位置为true
 * 7.isInterrupted() 判断当前线程处于中断状态
 * 8.static方法interrupted（） 判断当前线程是否处于中断状态，中断标志位改为false
 */
public class StartThread {
    private static class UseRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

    private static class UseCall implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Callable";
        }
    }

    private static class UseThread extends Thread{

        @Override
        public void run() {
            System.out.println("thread");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new UseThread();
        thread.start();

        UseRun useRun = new UseRun();
        Thread thread1 = new Thread(useRun);
        thread1.start();

        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        System.out.println(futureTask.get());
    }
}
