import java.util.concurrent.Callable;

public class Thread3 implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        // 输出
        return 10;
    }

}
