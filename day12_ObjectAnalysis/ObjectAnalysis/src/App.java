/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-06 00:30:52
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-06 22:12:09
 * @version      : 
 * @Description  : Object 类测试
 */

public class App {
    public static void main(String[] args) throws Exception {
        Person p = new Person("Xiaoyao", 25);
        System.out.println(p);
        p = null; // 此时对象实体就是垃圾对象，等待被回收，但时间不确定
        System.gc(); // 强制性释放空间

        GetClassTest test = new GetClassTest();
        System.out.println("test's className is: " + test.getClass());
        System.out.println("test's baseClass is: " + test.getClass().getSuperclass());
    }
}
