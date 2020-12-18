import org.junit.AfterClass;
import org.junit.Test;

/* 线程同步方式一: 同步代码块
 * synchronized(同步监视器) {
 *     // 需要被同步的代码
 * }
 * 同步监视器俗称锁，任何一个对象都可以充当锁，但是具备竞争条件的多个线程必须使用同一把锁
 * 
 * 线程同步方式二: 同步方法
 *      如果操作共享数据的代码完整地声明在一个方法中
 *      我们不妨将此方法声明为同步方法
 *  1. 实现Runnable接口的多线程方式中使用同步方法请直接查看代码 App.java--> Thread2Test()
 *  2. 继承Thread类的方式中使用同步方法，与1.中类似
 *      但是需要将该同步方法定义为static类型
 *      此时的同步监视器是 ClassName.class
 */
public class App {
    public static void main(String[] args) throws Exception {
        Thread1 _t1 = new Thread1();
        Thread t1 = new Thread(_t1);
        Thread t2 = new Thread(_t1);
        Thread t3 = new Thread(_t1);
        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void Thread2Test() {
        Thread2 _t2 = new Thread2();
        Thread t1 = new Thread(_t2);
        Thread t2 = new Thread(_t2);
        Thread t3 = new Thread(_t2);
        t1.start();
        t2.start();
        t3.start();
        // 此处必须等待三个线程退出
        // 否则使用JUnit4进行测试时测试线程会在主线程执行完毕后直接退出
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        System.out.println("票已经卖完了...");
    }

    @Test
    public void Thread3Test() {
        Thread3 _t3 = new Thread3();
        Thread t1 = new Thread(_t3);
        Thread t2 = new Thread(_t3);
        Thread t3 = new Thread(_t3);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
        }
        System.out.println("票已经卖完了...");
    }

    @Test
    public void ThreadCommunicationTest() {
        ThreadCommunication _t = new ThreadCommunication();
        Thread t1 = new Thread(_t);
        Thread t2 = new Thread(_t);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }
    }

    @AfterClass
    public static void showFinish() {
        System.out.println("AfterClass...");
    }
}
