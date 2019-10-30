#### 1.进程与线程的区别
    进程：程序运行资源分配的最小单位，一个进程有多个线程，线程共享资源
    线程：cpu调度的最小单位
    

#### 2.并行与并发的区别
    并行：同一时刻处理事情的能力
    并发：与时间单位有关，在单位时间内处理事情的能力

#### 3.创建线程的方式
    


#### 4.线程关闭

#### 5.线程状态
    线程状态：
    新建：new 
    就绪：start()，时间片到期，interrupt()，notify(),notifyAll(),yield
    运行: 获取执行权 join()
    阻塞: sleep(),wait()
    死亡: run结束 setDeamon

#### 6.线程池
    四种线程池

#### 7.多线程的优势
    发挥多处理器的强大能力（多核cpu的优势）
    便于建模
    异步事件的简化处理（防止阻塞）

#### 8.线程带来的风险
    安全性问题
    活跃性问题
    性能问题
    
#### 9.安全中断
    interrupt()：中断线程，并不是强制关闭线程，将中断标志位置为true
    isInterrupted() 判断当前线程处于中断状态
    static方法interrupted（） 判断当前线程是否处于中断状态，中断标志位改为false

#### 10.run start区别
    只有调用start(),才具备多线程的特性，直接调用run方法，还是单线程，普通方法调用
    
#### 11.线程优先级

#### 12.线程共享
    volatile 
    synchronized
    ThreadLocal
    
#### 13.线程间的协作

#### 14.等待和通知的范式
    等待方： 1.获取对象的锁
            2.循环里判断条件是否满足，不满足调用wait方法
            3.条件满足执行业务逻辑
    通知方： 1.获取对象的锁
            2.改变条件
            3.通知所有在等待对象的线程
#### 15. notify和notifyAll应该用谁
    优先使用notifyAll，因为使用notify有可能发生信号丢失的情况

#### 16. 等待超时模式标准范式
    假设等待时长为T，当前时间now+T以后超时
    long overTime = now + T
    long remain = T //等待的持续时间
    while(result 不满足条件&&remain>0){
        wait(remain);
        remain = overTime - now //等待剩下的持续时间
    }
    
#### join()
    面试点 线程a在线程b后执行
    线程A执行线程B的join(),线程A必须要等待线程B执行完成以后，线程A才能继续执行自己的工作

#### yield，sleep，wait，notify对锁有何影响
    yield：持有锁不释放
    sleep：持有锁不释放
    wait：调用方法前必须持有锁，调用wait方法后，锁就会被释放，当wait方法返回时，重新持有锁
    notify：调用方法前必须持有锁，调用notify本身不会释放锁

#### fork/join 
    分而治之
    规模为N的问题，N<阀值，直接解决，N>阀值，将N分解为k个小规模子问题，子问题互相对立，与原问题形式相同，将子问题的解合并得到原问题的解
    工作密取

#### 常见的并发工具类
    CountDownLatch
    作用：使一个线程等待其他线程完成工作以后再执行，加强版的join，await用来等待，countDown负责计数器减一
    cic
    
#### callable future futureTask

#### 原子操作（atom）
    CAS（comepare and swap）原理
    指令级别保证原子操作
    三个操作符：一个内存地址V 一个期望的值A 一个新值B，循环里面不断进行CAS操作，自旋
    synchronized基于阻塞的锁机制
    
    cas问题：
    ABA问题：版本号解决
    开销问题：
    只能保证一个共享变量的原子操作： 将多个共享变量合成一个对象处理

#### 显示锁
    lock接口
    主要方法：
    tryLock
    
    reentrant：可重入锁
    
    公平锁：先对锁进行获取的请求，先被满足
    非公平锁：不被满足就是非公平
    
#### lock synchronized
    synchronized：代码简洁
    lock：获取锁可以被中断，超时获取锁，尝试获取锁
    

    