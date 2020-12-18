
/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-18 20:54:25
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 01:21:23
 * @version      : 
 * @Description  : 
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

/**
 * Java多线程方式1: 继承Thread类
 * Java多线程方式2: 实现Runnable接口
 * Java多线程方式3: 实现Callable接口
 * Java多线程方式4: 线程池
 */
public class App {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().setName("主线程");
    }

    @Test
    public void Thread1Test() {
        Thread1 thread1 = new Thread1("线程1");
        thread1.start();
    }

    @Test
    public void Thread2Test() {
        Thread2 t2 = new Thread2();
        Thread t = new Thread(t2);
        t.start();
    }

    // 第3种线程实现方式
    @Test
    public void Thread3Test() {
        Thread3 _t3 = new Thread3();
        FutureTask<Integer> task = new FutureTask<Integer>(_t3);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            // 多个线程想要都获取返回值，需要创建多个FutureTask实例
            System.out.println("task.get(): " + task.get());
        } catch (Exception e) {
        }
    }

    // 第四种线程实现方式
    /* 1. 提供指定线程数量的线程池
     * 2. 执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
     * 3. 关闭连接池
     */
    @Test
    public void Thread4Test() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        // service的类型其实是一个接口，无法用于设置线程池的一些属性
        // 我们可以将其强转成ThreadPoolExecutor类型，然后设置线程池的属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
        service1.setKeepAliveTime(1000, null);
        
        service1.execute(new Thread2()); // 适用于Runnable
        service1.submit(new Thread3()); // 适用于Callable
        service1.shutdown();
    }
}
