/**
 * Java多线程方式1: 继承Thread类
 * 1. 定义一个继承于Thread类的子类SubThread
 * 2. 重写Thread类的run() --> 讲此线程执行的操作声明在此方法中
 * 3. 创建SubThread的对象subThread
 * 4. subThread.start()
 * 5. Thread.currentThread().getName()可以获取当前调用现成的线程名称
 * 6. 不能start一个已经启动的线程 
 * 例子: 遍历100以内的所有质数
 */
public class Thread1 extends Thread {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":");
        System.out.print(2 + " ");
        for_i:
        for (int i = 3; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue for_i;
                }
            }
            System.out.print(i + " ");
        }
    }

    /**
     * 此方法不是必须重写的，可以不重写构造器
     * 此方法可以在创建线程对象时，指定线程的名称为name
     * @param name
     */
    public Thread1(String name) {
        super(name);
    }
}
/* Thread 类中常用方法
 * 1. start();
 * 2. run();
 * 3. currentThread(); 静态方法，返回当前代码所在的线程
 * 4. setName(); 设置当前线程的名称
 * 5. getName(); 获取当前线程的名称
 * 6. yield(); 释放当前CPU的执行权
 * 7. join(); 在线程A中调用线程B的join，线程A就会阻塞等待，直到线程B执行完毕
 * 8. stop(); 已过时，执行此方法时，会强制结束当前线程
 * 9. sleep(); 让当前线程睡眠指定的毫秒数
 * 10. isAlive(); 判断当前线程是否存活
 * 
 * 线程的优先级
 * MIN_PRIORITY: 1
 * NORM_PRIORITY: 5
 * MAX_PRIORITY: 10
 * getProority(); 获取线程优先级
 * setPriority(int p ); 设置线程优先级
 * 
 */

