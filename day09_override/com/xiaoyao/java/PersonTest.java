package com.xiaoyao.java;
/* 方法的重写(override/overwrite)
 * 注意点: 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符。
 * > 特殊情况: 子类中不能重写父类中的private方法
 * 返回值类型:
 * > 父类方法的返回值是void，则子类重写的方法的返回值类型只能是void
 * > 父类方法的返回值是A类型，则子类重写的方法的返回值类型可以是A类或者A的子类
 * > 父类方法的返回值类型是基本数据类型，则子类重写的方法必须是相同的类型
 * 异常类型
 * > 子类重写的方法抛出的异常类型不能大于父类方法抛出的异常类型
 * ****************************************************************
 * 子类和父类中同名同参的方法要么都声明为非static的，要么都声明为static的
 */
public class PersonTest {
    public static void main(String[] args) {
        Student s = new Student("计算机与科学技术学院");
        s.eat();
        s.walk(10);
        s.study();
    }
}
