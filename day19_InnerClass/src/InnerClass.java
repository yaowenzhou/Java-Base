/**
 * 类的内部成员之内部类
 * 1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类
 * 2. 内部类的分类: 成员内部类(静态、非静态)、局部内部类(方法内、代码块内、构造器内)
 * 2.1 成员内部类
 *      2.1.1 作为外部类的成员
 *          > 可以调用外部类的结构
 *          > 可以被static修饰
 *          > 可以被4中不同的权限修饰
 *      2.1.2 作为一个类
 *          > 类内部可以定义属性、方法、构造器等
 *          > 可以被final修饰，表示此类不能被继承
 *          > 可以被abstract修饰
 * 
 * 3. 关注如下3个问题
 *      3.1 如何实例化成员内部类的对象
 *      3.2 如何在成员内部类中区分调用外部类的结构
 *      3.3 开发中局部内部类的使用
 * 
 * 4. 在局部内部类的方法中，如果调用该类所在的方法中的局部变量的话，该变量必须声明为final
 *          
 */

public class InnerClass {
    public static void main(String[] args) throws Exception {
        // 静态成员内部类创建实例
        Person.StaticInnerClassInClass c1 = new Person.StaticInnerClassInClass();
        // 非静态成员内部类创建实例
        Person p = new Person();
        Person.InnerClassInClass c2 = p.new InnerClassInClass();
    }
}

class Person {
    String name;
    int age;

    Person() {
        this.name = "xiaoyao";
        this.age = 25;
        class InnerClassInConstructor {

        }
    }

    public void study() {
        System.out.println("I am learning Java.");
    }

    final class InnerClassInClass {
        String className;

        InnerClassInClass() {
            this.className = "InnerClassInClass";
        }

        public void showName() {
            System.out.println(className);
            // 调用外部类的study方法，省略的是"Person.this."
            study();
        }
    }

    static class StaticInnerClassInClass {
        String className;

        StaticInnerClassInClass() {
            this.className = "StaticInnerClassInClass";
        }

        public void showName() {
            System.out.println(className);
        }

    }

    public void showName() {
        class InnerClassInMethod {
        }
    }

    {
        class InnerClassInCodeBlock {

        }
    }

}
