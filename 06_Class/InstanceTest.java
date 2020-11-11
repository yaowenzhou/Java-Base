/* 一、对象的理解
 * 1. 在Java语言范畴中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
 * 2. 涉及到Java语言与前端Html、后端数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象
 *
 * 二、内存解析的说明
 * 1. 引用类型的变量，只可能存储两类值: null或地址值(含变量的类型)
 * 
 * 三、匿名对象的使用
 * 
 */
public class InstanceTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        System.out.println(p);
        p.sendEmail();
        p.playGame();

        // 匿名对象
        new Phone().sendEmail();
        new Phone().playGame();

        new Phone().price = 1999;
        new Phone().showPrice();// The Mobile phone price is: 0.0 yuan
    }

}

class Phone {
    double price;

    public void sendEmail() {
        System.out.println("Sending email.");
    }

    public void playGame() {
        System.out.println("Playing game.");
    }

    public void showPrice() {
        System.out.println("The Mobile phone price is: " + price + " yuan");
    }
}
