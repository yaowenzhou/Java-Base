/* 创建多线程方式2: 实现Runnable接口
 * 1. 创建一个实现了Runnable接口的类Thread2
 * 2. Thread2 去实现Runnable中的抽象方法run()
 * 3. 创建Thread2的对象
 * 4. 将此对象作为参数传递给Thread类的构造器，创建Thread类对象 thread
 * 5. thread.start();
 */
public class Thread2 implements Runnable {

    @Override
    public void run() {
        // 输出前20个fibonacci数
        System.out.print(1 + " " + 1 + " ");
        int prev1 = 1;
        int prev2 = 1;
        int cur = 0;
        for (int i = 3; i <= 20; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
            System.out.print(cur + " ");
        }
    }
}
