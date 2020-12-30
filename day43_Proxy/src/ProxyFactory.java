import java.lang.reflect.Proxy;

// (代理工厂)生成代理类对象的类
public class ProxyFactory {
    /**
     * 调用此方法，返回一个代理类的对象
     * @param obj the object of class which is proxied
     * @return
     */
    public static Object getProxyInstance(Object obj) {
        Handler handler = new Handler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
