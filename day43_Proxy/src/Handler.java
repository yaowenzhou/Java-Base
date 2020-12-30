import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    private Object obj; //需要使用被代理类对象进行赋值

    public Handler(Object obj) {
        this.obj = obj;
    }

    @Override
    // 当我们通过代理类的对象调用方法a时，就会自动调用此方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method 即为代理类对象调用的方法，此方法也就作为了被代理类调用的方法
        // obj: 被代理类的对象
        Object val = method.invoke(obj, args);
        // 上述方法的返回值就作为当前累中的invoke()的返回值
        return val;
    }

}
