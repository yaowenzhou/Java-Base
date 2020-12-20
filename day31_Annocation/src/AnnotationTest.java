import org.junit.Test;

import java.lang.annotation.*;
import java.util.ArrayList;

import static java.lang.annotation.ElementType.*;

@Xiaoyao("HelloAnnotation!")
public class AnnotationTest {

    @Test
    public void InheritedTest() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

//自定义注解

/**
 * 定义新的Annotation类型使用@interface关键字
 * 自定义注解自动继承了java.lang.annotation.Annotation接口
 * Annotation的成员变量在Annotation定义中以无参数方法的形式来声明
 * 其方法名和返回值定义了该成员的名字和类型，我们称之为配置参数
 * 类型只能是8种基本数据类型、String、Class、enum、Annotation，以及以上所有类型的数组
 * 可以在定义Annotation的成员变量时使用default关键字为其指定初始值
 * 如果只有一个参数成员、建议使用参数名value
 * 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值
 * 格式是: argName = argValue，如果只有一个参数成员，且名称为value，可以省略"value="
 * 没有定义成员的Annotation称为标记，包含成员变量的Annotation称为元数据Annotation
 * 注意: 自定义注解必须配上注解的信息处理流程(使用反射)才有意义
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Inherited
@interface Xiaoyao {
    String[] value() default "Hello Annotation!";
}

/* 自定义注解通常都会指明两个元注解 Retention、Target
 * JDK的元注解用于修饰其它Annotation的定义
 * JDK5.0 提供了4个标准的meta-annotation，分别是:
 * Retention、Target、Documented、Inherited
 * Retention:
 *      指定所修饰的Annotation的生命周期: SOURCE/CLASS(default)/RUNTIME
 *      只有声明为RUNTIME生命周期的注解，才能通过反射获取
 * Target: 用于指定被修饰的Annotation能用于修饰哪些程序元素
 * Documented: 默认情况下，Annotation是不会被Javadoc解析的
 *      但是使用Documented修饰的注解将会被Javadoc解析
 * Inherited: 被它修饰的Annotation将具有继承性
 *      eg: AnnotationA被Inherited修饰过，然后使用Annotation修饰ClassA
 *          那么如果ClassB继承于ClassA，则ClassB将自动被AnnotationA修饰
 */
@Xiaoyao
class Person {
    String name;
    int age;
}

class Student extends Person {
    boolean male;
}

/* JDK8 新特性:
 *      可重复注解、类型注解
 *  可重复注解: 同一种注解写多次，想要使用需要做一些设置
 *
 *  类型注解: Java8开始，元注解@Target的参数类型ElementType枚举值多了两个
 *      ElementType.TYPE_PARAMETER和ElementType.TYPE_USE
 *  ElementType.TYPE_PARAMETER:
 *      表示该注解能写在类型变量的声明语句中
 *  ElementType.TYPE_USE:
 *      表示该注解能写在使用类型的任何语句中
 */
// jdk8 之前可重复注解的写法:
@Target({TYPE_PARAMETER, TYPE_USE})
@interface MyAnnotation {
    String value() default "Hello Java";
}

@Target({TYPE_PARAMETER, TYPE_USE})
@interface MyAnnotations {
    MyAnnotation[] value();
}

@MyAnnotations({@MyAnnotation("Hello"), @MyAnnotation("Java!")})
class RepeatAnnotationsBefore8 {
}

// JDK8 开始可重复注解的写法
/* ①: 在MyAnnotation1上声明@Repeatable，成员值为MyAnnotations1.class
 * ②: MyAnnotation1的Target、Retention、Inherited和MyAnnotations1相同
 */
@Repeatable(MyAnnotations1.class)
@interface MyAnnotation1 {
    String value();
}

@interface MyAnnotations1 {
    MyAnnotation1[] value();
}

@MyAnnotation1("Hello")
@MyAnnotation1("Java!")
class RepeatAnnotationsAfter8 {
}

// 类型注解
class Generic<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}