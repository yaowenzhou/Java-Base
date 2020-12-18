/**
 * 线程通信的例子: 使用两个线程打印1-100，线程1、线程2交替打印
 * 涉及到的3个方法:
 * wait();  执行此方法，当前线程进入阻塞状态，并同步释放监视器
 * notify();    一旦执行此方法，就会唤醒一个被wait()的线程
 *      如果有多个线程被wait()，则唤醒优先级高的线程
 * notifyAll(); 一旦执行此方法，就会唤醒所有被wait的线程
 * 注意: 这只能在同步方法或者同步代码块中使用
 *      并且只能由该同步方法或这同步代码块的同步监视器调用
 *      否则会出现IllegalMonitorStateException异常
 *      ----> 这三个方法是定义在Object类中
 */
public class ThreadCommunication implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    break;
                }
            }
        }
    }
}
