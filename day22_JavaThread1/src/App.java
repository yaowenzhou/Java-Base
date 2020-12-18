import org.junit.Test;

/**
 * Java多线程方式1: 继承Thread类
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
}
