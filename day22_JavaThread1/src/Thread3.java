
/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-18 22:09:16 Friday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 00:56:30
 * @Version      : 
 * @Description  : 第三种创建线程的方式，此例中用来获取100000以内的完美数
 * 1. 创建一个实现Callable接口的实现类
 * 2. 实现call(),将此线程需要执行的操作名声在call()中，call()可以有返回值
 * 3. 创建Callable接口实现类的对象
 * 4. 将此Callable实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
 * 5. 将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
 * 6. 如果有返回值，调用get()方法，即为FutureTask构造器参数Callable实现类重写的call()的返回值
 */
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Thread3 implements Callable<Integer> {
    private final int maxNum = 100000;
    private int cur = 2;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public Integer call() throws Exception {
        int tmp = 0;
        while (true) {
            lock.lock();
            if (cur > maxNum) {
                lock.unlock();
                break;
            }
            tmp = cur++;
            lock.unlock();
            int sum = 1;
            for (int i = 2; i <= tmp / 2; i++) {
                if (tmp % i == 0) {
                    sum += i;
                }
            }
            if (sum == tmp) {
                System.out.println(tmp + " is a perfect number.");
            }
        }
        return cur;
    }
}
