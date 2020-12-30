import java.util.Comparator;

import org.junit.Test;

/* lambda 的本质: 作为接口的实例
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {
        // 1. 正常写法
        Comparator<Integer> comp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comp1.compare(1, 2));
        // 2. lambda写法
        Comparator<Integer> comp2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comp2.compare(11, 12));
        // 3. 方法引用写法
        Comparator<Integer> comp3 = Integer::compare;
        System.out.println(comp3.compare(21, 22));
    }

    @Test // lambda1: no args, no return value
    public void Lambda1() {
        Runnable r = () -> {
            System.out.println("I love Java!");
        };
        r.run();
    }

    @Test // lambda2: 1 arg, no return value
    public void Lambda2() {
        Message message = (String msg) -> {
            System.out.println(msg);
        };
        message.show("This is a lambda expression with single parameter and no return value.");
    }

    @Test // lambda3: 类型推断，省略形参的类型
    public void Lambda3() {
        Message message = (msg) -> {
            System.out.println(msg);
        };
        message.show("This is a lambda expression with single parameter and no return value.");
    }

    @Test // lambda4: 如果参数只有一个，小括号也可以省略
    public void Lambda4() {
        Message message = msg -> {
            System.out.println(msg);
        };
        message.show("This is a lambda expression with single parameter and no return value.");
    }

    @Test // lambda5: 多形参，多条执行语句，并且有返回值
    public void Lambda5() {
        Comparator<Integer> comp2 = (o1, o2) -> {
            System.out.println("o1: " + o1);
            System.out.println("o2: " + o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comp2.compare(11, 12));
    }
}

interface Message {
    void show(String msg);
}
