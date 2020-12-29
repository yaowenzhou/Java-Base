import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Test
    public void beforeReflection() {
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
    }

    @Test
    public void afterReflection() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);
        // Call the specified method by reflection
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        // We can call private members of the class through reflection
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Java");
        System.out.println(p1);
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");
        System.out.println(nation);
    }

    /* 关于ava.lang.Class的理解
     * 1. 类的加载过程
     *  > 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class)结尾
     *  > 接着我们使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中，此过程就称为类的加载
     *  > 加载到内存中的类，我们称之为运行时类，此运行时类，就作为Class的一个实例。
     * 2. 换句话说，Class的实例就对应着一个运行时类
     * 3. 加载到内存中的运行时类，会缓存一定的时间，在此时间内，我们可以通过不同的方式来获取此运行时类
     */
    // 获取Class实例的方式
    @Test
    public void GetClassInstance() throws ClassNotFoundException {
        // Way1: RuntimeClassName.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // Way2: RuntimeClassObject.getClass();
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        // Way3: Class's static method: forName(String classPath)
        // classPath must be a path, here because the Person class is under the current path, it is directly a "Person" 
        Class clazz3 = Class.forName("Person");
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        // Way4: ClassLoader, the classPath must be a path
        ClassLoader loader = App.class.getClassLoader();
        Class clazz4 = loader.loadClass("Person");
        System.out.println(clazz1 == clazz4);
    }

    // Load configuration file by ClassLoader
    @Test
    public void ClassLoaderTest() throws IOException {
        Properties props = new Properties();
        // way1:
        // FileInputStream fis = new FileInputStream("E:/Code/Java-Base/day42_Reflection/src/test.properties");
        // props.load(fis);
        // way2:
        ClassLoader loader = App.class.getClassLoader();
        // 这里默认使用相对于项目的src目录的相对路径
        InputStream is = loader.getResourceAsStream("test.properties");
        System.out.println(is);
        props.load(is);
        System.out.println(props.getProperty("name"));
        System.out.println(props.getProperty("age"));
        // fis.close();
        is.close();
    }
}
