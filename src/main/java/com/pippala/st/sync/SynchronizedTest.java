package com.pippala.st.sync;


/**
 * 并发编程中存在线程安全问题：
 * 1.存在共享数据
 * 2.多线程共同操作共享数据
 *
 * 关键字synchronized可以保证同一时刻只有一个线程执行某个方法或者代码块
 * 可以保证一个线程的变化可见性，可以替代volatile
 *
 * synchronized 可以保证方法或者代码块在运行时，同一时刻只有一个方法进入临界区，保证共享变量的可见性
 *
 * 三种应用方式
 * 1.普通同步方法（实例方法）锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
 * 2.静态同步方法，锁的是当前类的class对象，进入同步代码前获得当前类对象的锁
 * 3.同步方法块（锁的是括号里的对象）
 *
 * Synchronized是Java中解决并发问题的一种最常用最简单的方法 ，他可以确保线程互斥的访问同步代码
 *
 * volatile 适用一个线程写，多个线程读的场景
 * 保证可见行，无法保证原子性
 *
 */
public class SynchronizedTest implements Runnable{
    //共享资源
    static int i = 0;

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j=0;j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread thread = new Thread(synchronizedTest);
        Thread thread1 = new Thread(synchronizedTest);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
