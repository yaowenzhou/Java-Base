public class Thread1 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            /* 下面这两种方式都ok
             * this在本例的执行中是惟一的，这个要具体情况具体分析(不一定是唯一的)
             * 类也是一种特殊对象，具有唯一性，二者都可以充当同步监视器
             */
            // synchronized (this) {
            // synchronized (Thread.class) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为-->" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
