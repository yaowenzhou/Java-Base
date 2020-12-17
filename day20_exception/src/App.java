import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * Java异常体系结构
 * java.lang.Throwable
 *      |----java.lang.Error: 一般不编写针对性的代码进行处理
 *      |----java.lang.Exception: 可以进行异常处理
 *          |----编译时异常
 *          |----运行时异常
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Student s = new Student();
        try {
            s.regist(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  使用try-catch-finally处理编译时异常，使得程序在编译时不再报错
     * 但是运行时仍可能报错，相当于我们将一个编译时可能出现的异常延迟到运行时出现
     * 开发中，由于运行时异常比较常见，因此通常不针对运行时异常编写try-catch-finally
     * 对于编译时异常，我们说一定要考虑异常的处理
     * 
     * finally是可选的，不管前面是否出现异常，这里都会被执行
     * 即使在try或者catch中返回了，或者catch中又出现了异常导致程序终结
     * finally这里依然会被执行
     */
    @Test
    public void tryCatchTest1() {
        String str = "123";
        str = "abc";
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        finally {
            System.out.println("Regardless of success or failure, it will be executed here.");
        }
        System.out.println(num);
    }

    /**
     * throws + 异常类型
     * throws 写在方法的声明处，指明此方法执行时可能抛出的异常类型
     * 一旦方法体执行时出现异常，仍会在异常代码处生成一个异常类对象
     * 此对象满足throws致命的异常类型时，就会被抛出
     * 异常代码后续的代码将不会被执行
     */
    /**
     * 开发中如何选择使用try-catch-finally还是使用throws?
     * - 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws
     *      这意味着如果子类重写的方法中如果有异常，则必须使用try-catch-finally方式处理掉
     */
    @Test
    public void throwsException() {
        try {
            System.out.println("path2:" + System.getProperty("user.dir"));
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("Hello.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }

    public static void method2() throws IOException {
        method1();
    }
}

class Student {
    /*
     * 主动抛出异常
     */
    private int id;

    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            // throw new RuntimeException("---->id is invalid!");
            throw new MyException("---->id is invalid!");
        }
    }
}

/* 自定义异常类
 * 1. 继承于现有的异常结构: RuntimeException、Exception
 * 2. 提供全局常量: serialVersionUID
 * 3. 提供重载的构造器
 */
class MyException extends Exception {

    /**
     * 
     */
    static final long serialVersionUID = -3387516993124229948L;

    /**
     * 
     */
    public MyException() {
    }

    /**
     * @param message
     */
    public MyException(String message) {
        super(message);
    }
    
}