import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * 对象流的使用
 * 1. ObjectInputStream和ObjectOutputStream
 * 2. 作用: 存储和读取基本数据类型或对象的处理流
 *      它的强大之处在于可以把Java中的对象写入到数据源中
 *      也能把对象从数据源中还原回来
 */

public class App{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    // 序列化
    @Test
    public void ObjectOutputStreamTest() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\Code\\Java-Base\\day40_ObjectStream\\object.dat"));
            oos.writeObject(new String("I love programming!\n我爱编程!"));
            oos.flush();
        } catch (IOException e) {
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
            }
        }
    }

    // 反序列化
    @Test
    public void ObjectInputStreamTest() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\Code\\Java-Base\\day40_ObjectStream\\object.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Serialization of custom classes
    // 自定义类的序列化
    // To a certain class of objects can be serialized,
    // you must implement the interface Serializable or Externalizable
    // 要想某个类的对象可序列化，必须实现Serializable或者Externalizable接口
    // And the current class needs to provide a global constant: serialVersionUID
    // 并且当前类需要提供一个全局常量: serialVersionUID
    // In addition, all attributes inside the class also need to be serializable
    // 另外，类内部的所有属性也需要都是可序列化的
    // static and transient member variables can not be modified serialized
    // static 和 transient修饰的成员变量不能序列化
    @Test
    public void ObjectOutputStreamTest1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\Code\\Java-Base\\day40_ObjectStream\\Person.dat"));
            oos.writeObject(new Person("xiaoyao", 25));
            oos.flush();
        } catch (IOException e) {
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
            }
        }
    }
    // Deserialization of custom classes
    // 自定义类的反序列化
    @Test
    public void ObjectInputStreamTest1() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\Code\\Java-Base\\day40_ObjectStream\\Person.dat"));
            Object obj = ois.readObject();
            Person str = (Person) obj;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
