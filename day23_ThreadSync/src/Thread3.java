/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-18 20:54:25
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-18 22:09:48
 * @version      : 
 * @Description  : 
 */
import java.util.concurrent.locks.ReentrantLock;

public class Thread3 implements Runnable {

    private int ticket = 100;
    /* 1. 实例化ReentrantLock
     *      构造器可以传递一个参数 bool fair
     *      如果不传递，则fair的值为false
     *      true: 创建的是一个公平的锁，以一个队列的形式维护线程对于锁的竞争
     *      false: 随缘竞争
     */
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为-->" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

}
