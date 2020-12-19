/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 11:11:17
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 14:01:31
 * @version      : 
 * @Description  : 
 */
public class App {
    public static void main(String[] args) throws Exception {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
    }
}

/* 1. String 的常量值声明方式存储在常量池中，常量池中不会存储相同的字符串
 * 2. 常量与常量的拼接结果存储于常量池
 * 3. 只有其中有一个变量，结果存储在堆中
 * 4. 如果拼接的结果调用intern()方法，返回值就在常量池中
 */