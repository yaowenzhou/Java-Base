import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-22 22:54:08
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-23 00:13:24
 * @version      : 
 * @Description  : 
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

    }

    @Test
    public void subGenericClassTest() {
        SubGenericClass sub = new SubGenericClass();
        sub.setT(10);
        System.out.println(sub.getT());
    }

    @Test
    public void subGenericClass1Test() {
        // since jdk 1.7: Type inference(类型推断)
        SubGenericClass1<Integer> sub = new SubGenericClass1<>();
        sub.setT(10);
        System.out.println(sub.getT());
    }
}

// GenericClass
/**
 * GenericClass<T>
 */
class GenericClass<T> {
    private String name;
    private int id;
    private T t;

    public GenericClass() {
    }

    /**
     * @param name
     * @param id
     * @param t
     */
    public GenericClass(String name, int id, T t) {
        this.name = name;
        this.id = id;
        this.t = t;
    };

    // this is not a generic method
    public void setT(T t) {
        this.t = t;
    }

    // this is not a generic method
    public T getT() {
        return this.t;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    // static GenericClass<T> getGenericObject() {
    //     Cannot make a static reference to the non-static type T
    //      无法在静态方法中使用类的泛型
    // }

    // generic method
    // At this point, the method can be declared as static
    // 此时可以将方法声明为static
    // public static <E> List<E> copyFromArrayToList(E[] arr) {
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}

class SubGenericClass extends GenericClass<Integer> {

}

class SubGenericClass1<T> extends GenericClass<T> {

}

// GenericInterface
interface GenericInterface<T> {

}

// class MyException<T> extends Exception {
//     The generic class MyException<T> may not subclass java.lang.Throwable
//     异常类不能是泛型的
//     Cannot catch a generic type in try-catch
//     不能在try-catch中catch一个泛型
// }

// new T[];
// 不能new一个泛型数组，但是可以 T[] arr = (T[]) new Object[10]

class Father<T1, T2> {
}

//子类不保留父类的泛型
// 1) 没有类型 擦除
class Son<A, B> extends Father { //等价 于 class Son extends Father<Object,Object>{
}

// 2) 具体类型
class Son2<A, B> extends Father<Integer, String> {
}

// 子类保留父类的泛型
// 1) 全部保留
class Son3<T1, T2, A, B> extends Father<T1, T2> {
}

// 2) 部分保留
class Son4<T2, A, B> extends Father<Integer, T2> {
}

// 子类不保留父类的泛型
// 1) 没有类型 擦除
class Son5<A, B> extends Father { //等价 于 class Son extends Father<Object,Object>{
}

// 2) 具体类型
class Son6<A, B> extends Father<Integer, String> {
}

// 子类保留父类的泛型
// 1) 全部保留
class Son7<T1, T2, A, B> extends Father<T1, T2> {
}

// 2) 部分保留
class Son8<T2, A, B> extends Father<Integer, T2> {
}

/* A and B have an inheritance relationship
 * but G<A> and G<B> are in a parallel relationship
 * and the two do not have a child-parent relationship
 * A和B具备继承关系，但是G<A>和G<B>是并列关系，二者不具备子父类关系
 * At this time, the following code will not compile
 * 此时下列代码将无法编译通过
 * List<String> list1 = null;
 * List<Object> list2 = null;
 * list1 = list2;
 * This situation makes the use of generics have certain limitations
 * you can consider wildcards at this time
 * 这种情况使得泛型的使用具备了一定的局限性，此时可以考虑通配符
 * public void print(List<?> list) {
 *     Iterator<?> ite = list.iterator();
 *     while(ite.hasNext()) {
 *         System.out.println(ite.next());
 *     }
 * }
 * we cannot add data to a container which is defined with wildcards, except for null
 * 使用通配符定义的容器就不能向其中添加数据了，除了null
 * Allow to read data, the type of the read data is Object
 * 允许读取数据，读取的数据类型为Object
 * 
 * Use of wildcards with restrictions
 * 有限制条件的通配符的使用
 */