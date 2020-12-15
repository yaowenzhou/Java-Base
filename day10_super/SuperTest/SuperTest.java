/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-04 21:38:04
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-15 22:56:41
 * @version      : 
 * @Description  : 
 */
package SuperTest;

/* super 关键字的使用
 * 1. super理解为：父类的
 * 2. super可以用来调用：属性、方法、构造器
 * 3. super的使用:
 *  3.1 可以在子类的方法或构造器中
 *      通过使用 super.field 或 super.method 的方式显式地调用父类中声明的属性或方法
 *      通常情况下，我们习惯省略 super.
 *  3.2 特殊情况:
 *      当子类和父类中定义了同名的属性时
 *      我们要想在子类中调用父类中声明的属性
 *      则必须显式地使用 super.field 的方式，表明使用的是父类中声明的属性
 *  3.3 特殊情况:
 *      当子类重写了父类中的方法以后
 *      我们想在子类的方法中调用父类中被重写的方法时
 *      则必须显式地使用 super.method 的方式，表明调用的是父类中被重写的方法
 * 4. super 调用构造器
 *  4.1 可以在子类的构造器中显式地使用 super(args_list) 的形式
 *      调用父类中声明的指定的构造器
 *  4.2 super(args_list)的使用，必须声明在子类构造器的首行
 *  4.3 我们在类的构造器中
 *      针对 this(args_list) 或 super(args_list) 只能二选一，不能同时出现
 *  4.4 当我们在构造器的首行没有显式地声明 this(args_list) 或 super(args_list)
 *      则默认调用的是父类中空参的构造器
 */

public class SuperTest {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();
        s.study();
    }
}
