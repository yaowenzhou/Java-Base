public class App {
    public static void main(String[] args) throws Exception {
        /* 要想实现动态代理，需要解决两个问题
         * 1. 如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
         * 2. 当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
         */
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBeief());
        proxyInstance.eat("热干面");
    }
}
