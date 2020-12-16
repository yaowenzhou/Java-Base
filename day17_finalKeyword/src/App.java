/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-16 21:56:16
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-16 22:05:53
 * @version      : 
 * @Description  : 
 */
/**
 * final:
 *      可以用来修饰的结构: 类、方法、变量
 *  1. 修饰类：此类不能被其它类继承
 *      比如: String、System、StringBuffer
 *  2. 修饰方法: 此方法不可以被重写
 *      Object类中的getClass()
 *  3. 修饰变量: 该变量不可以被修改，此时的"变量"就可以称为一个常量
 *      3.1 修饰属性，可以考虑的赋值位置: 显式初始化、代码块中初始化、构造器中初始化
 *      3.2 修饰局部变量
 * static final 用来修饰属性: 全局常量
 */

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

/**
 * abstract:
 * 可以用来修饰类、方法(抽象类、抽象方法)
 * 修饰类:
 *      此类不可被实例化
 *      抽象类中一定有构造器，便于子类实例化时调用(涉及子类实例化的全过程)
 *      开发中都会提供抽象类的自雷，让子类对象实例化，完成相关的操作
 * 修饰方法:
 *      包含抽象方法的类必须是抽象类
 *      public abstract methodName(args);
 *      子类重写了父类中所有的抽象方法，才能进行实例化
 */

abstract class Person {
    abstract public void eat();
}

class PersonTest {
    Person p = new Person() {

        @Override
        public void eat() {
            // TODO Auto-generated method stub
            System.out.println("eating...");
        }
    };
}