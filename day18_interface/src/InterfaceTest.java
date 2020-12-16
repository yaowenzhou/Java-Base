/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-16 22:04:27
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-17 00:49:23
 * @version      : 
 * @Description  : 接口的使用
 */
public class InterfaceTest {
    public static void main(String[] args) throws Exception {
        Computer com = new Computer();
        Android android = new Android();
        com.transferData(android);
        // 接口的匿名实现类的匿名对象
        com.transferData(new USB() {
            @Override
            public void start() {
                System.out.println("USB接口的匿名实现类的start方法");
            }

            @Override
            public void stop() {
                System.out.println("USB接口的匿名实现类的stop方法");
            }
        });
        // 接口中定义的静态方法，只能通过接口调用
        USB.insert();
        TypeC.insert();
    }
}

interface USB {
    // 成员变量只能是 public static final 类型的，如果不写会默认为public static final
    public static final int width = 10;

    // 接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
    void start();

    void stop();

    // JDK 1.8 以后，接口里可以有静态方法和方法体了。
    // 接口中定义的静态方法，只能通过接口调用
    static void insert() {
        System.out.println("You have plugged a device into the usb port.");
    }

    // 默认方法可以通过类对象来调用

    default void unplug() {
        System.out.println("Unplug the USB...");
    }
    /**
     * 如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的方法
     * 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法
     * ----> 类优先原则
     */
    /**
     * 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的方法
     * 那么在实现类没有重写此方法的情况下，会报错 ----> 接口冲突
     */
    /**
     * 可以在实现类中调用接口类的默认方法
     * 语法: interfaceName.super.method();
     */
}

// 接口的继承
interface USB3 extends USB {
    // 最大传输速率
    int maxRate = 200;
    default void showInterfaceName(){
        System.out.println("USB3...");
    }
}

interface TypeC {
    int height = 3;
    int maxRate = 300;

    void start();

    void stop();

    static void insert() {
        System.out.println("You have plugged a device into the type-c port.");
    }
    default void showInterfaceName(){
        System.out.println("TypeC...");
    }
}

interface NewPort extends USB3, TypeC {
    @Override
    default void showInterfaceName() {
        System.out.println("NewPort...");
    }
}

// 接口的实现
class Android implements NewPort {
    @Override
    public void start() {
        System.out.println("Override start method in Android.");
    }

    @Override
    public void stop() {
        System.out.println("Override stop method in Android1.");
    }
}

class Android1 implements USB3, TypeC {

    @Override
    public void start() {
        System.out.println("Override start method in Android1.");
    }

    @Override
    public void stop() {
        System.out.println("Override stop method in Android1.");
    }
    @Override
    public void showInterfaceName() {
        System.out.println("---->in Android1 showInterfaceName start");;
        USB3.super.showInterfaceName();
        TypeC.super.showInterfaceName();
        System.out.println("---->in Android1 showInterfaceName end");;
    }
}

class Computer {
    // 接口的多态
    public void transferData(USB usb) {
        usb.start();
        System.out.println("具体的传输细节");
        usb.stop();
        usb.unplug();
    }
}