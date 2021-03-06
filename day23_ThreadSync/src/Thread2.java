/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-18 20:54:25
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-18 22:10:33
 * @version      : 
 * @Description  : 
 */
public class Thread2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        try {
            while (true) {
                show();
                Thread.sleep(200);
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    // 同步方法中，同步监视器默认是this
    private synchronized void show() throws InterruptedException {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为-->" + ticket);
            ticket--;
        } else {
            Thread.currentThread().interrupt();
        }
    }
}
