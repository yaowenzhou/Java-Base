
/**
 * 1. 静态变量
 * 静态变量随着类的加载而加载，可以通过 ClassName.staticVar 的方式进行调用
 * 静态变量的加载要早于对象的创建
 * 由于类只会加载一次，因此静态变量在内存中也只会存在一份
 * 静态变量存在方法区的静态域中
 * 2. 静态方法
 * 
 */
import org.junit.Test;

public class StaticTest {
    @Test
    public void ordinaryVar() {
        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 40;
        c1.nation = "CN";

        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 30;
        System.out.println(c2.nation);

        Chinese.eat();
    }
}

class Chinese {
    String name;
    int age;
    static String nation;
    static void eat() {
        System.out.println("中国人吃中餐");
    }
}