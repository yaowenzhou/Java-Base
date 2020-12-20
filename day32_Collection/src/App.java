import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-20 13:41:40
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-20 19:10:52
 * @version      : 
 * @Description  : Collection接口中的方法的使用
 */

class Person {
    String name;
    int age;

    /**
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(obj.getClass().getClass());
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person p = (Person) obj;
        return name.equals(p.name) && age == p.age;
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    private Collection<Object> getColl() {
        Collection<Object> coll = new ArrayList<Object>();
        // add(Object e): 将元素e添加到集合Collection中
        coll.add("AA");
        coll.add(123);//自动装箱
        coll.add(new Date());
        return coll;
    }

    @Test
    public void sizeTest() {
        Collection<Object> coll = getColl();
        // size(): 获取添加的元素的个数
        System.out.println(coll.size());
    }

    @Test
    public void addAllTest() {
        Collection<Object> coll = getColl();
        // addAll(): 将coll1中的元素添加到当前集合中
        Collection<Object> coll1 = new ArrayList<Object>();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void isEmptyTest() {
        Collection<Object> coll = getColl();
        // isEmpty(): 判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }

    @Test
    public void clearTest() {
        Collection<Object> coll = getColl();
        // clear(): 清空当前集合的元素
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }

    @Test
    public void containsTest() {
        Collection<Object> coll = getColl();
        // contains(Object obj): 判断当前集合中是否包含obj
        // 由于ArrayList是有序的
        // 因此contains会调用obj的equals方法依次与coll中的元素进行比较
        // 当equals返回true时，比较完毕，contains返回
        // 向Collection接口的实现类的对象中添加数据obj时，要求obj所在的类要重写equals()
        coll.add(new String("Tom"));
        coll.add(new Person("Tom", 22));
        coll.add(new Person("Jerry", 33));
        System.out.println(coll.contains(123)); // 自动装箱，同样是通过equals判断的
        System.out.println(coll.contains(new String("Tom"))); // True, 不是通过 == 判断，而是通过equals判断
        System.out.println(coll.contains(new Person("Tom", 22)));
        System.out.println(coll.contains(new Person("Jerry", 34)));
    }

    @Test
    public void containsAllTest() {
        Collection<Object> coll = getColl();
        // containsAll(Collection coll1): 判断形参coll1中所有的元素是不是都在当前集合中
        Collection<Object> coll2 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll2));
    }

    @Test
    public void removeTest() {
        // remove(Object obj): 将obj从当前集合中移除，返回值为boolean型，表示操作是否成功
        Collection<Object> coll = getColl();
        System.out.println(coll);
        System.out.println(coll.remove(123));
        System.out.println(coll);
    }

    @Test
    public void removeAllTest() {
        // removeAll(Collection coll1): 差集操作，将coll1中的所有元素从当前集合中移除
        // 返回值为boolean型，如果最少有一个coll1中的元素被移除，返回true，全部移除失败返回false
        Collection<Object> coll = getColl();
        System.out.println(coll);
        System.out.println(coll.removeAll(Arrays.asList(123, 456)));
        System.out.println(coll);
    }

    @Test
    public void retainAll() {
        // retainAll(Collection coll1): 交集操作
        // 获取当前集合和coll1的交集，并返回给当前集合
        Collection<Object> coll = getColl();
        Collection<Object> coll1 = getColl();
        // coll1.removeAll(Arrays.asList(123, "AA"));
        System.out.println(coll.retainAll(coll1));
        System.out.println(coll);
        Collection<Object> coll2 = getColl();
        coll2.clear();
        System.out.println(coll.retainAll(coll2));
        System.out.println(coll);
    }

    @Test
    public void equalsTest() {
        // equals(Object obj): 比较当前集合和形参对象是否相等，要想返回true，需要二者的大小和元素顺序完全等
        Collection<Object> coll = getColl();
        Collection<Object> coll1 = getColl();
        System.out.println(coll.equals(coll1));
        coll1.remove(123);
        coll1.add(123);
        System.out.println(coll1);
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void hashCodeTest() {
        // hashCode: 返回当前集合的hash值
        Collection<Object> coll = getColl();
        System.out.println(coll.hashCode());
    }

    @Test
    public void toArrayTest() {
        Collection<Object> coll = getColl();
        Object arr[] = coll.toArray();
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void array2ListTest() {
        // 数组-->集合
        List<String> list = Arrays.asList(new String[] { "AA", "BB", "CC" });
        System.out.println(list.size());
        // 基本数据类型的数组作为Arrays.List的参数，会被当做一个元素
        // 根本原因是泛型的类型应该是Object类型，基本数据类型不是类对象，而数组是对象
        // 编译器无法隔着数组完成自动装箱，编译器会将其解释为只有一个元素的二维数组
        List list1 = Arrays.asList(new int[] { 1, 2, 3 });
        List list2 = Arrays.asList(1, 2, 3); //自动装箱
        System.out.println("---->");
        System.out.println(list2.get(1).getClass());
        System.out.println(list1.size());
        Object obj = new int[] { 1, 2, 3 };
        System.out.println(obj.getClass().getName());
    }

    @Test
    public void iteratorTest() {
        // iterator(): 返回Iterator接口的实例，用于遍历集合元素
        Collection<Object> coll = getColl();
        Iterator<Object> ite = coll.iterator();
        // ite使用方式1
        /* System.out.println(ite.next());
        System.out.println(ite.next());
        System.out.println(ite.next());
        // 超出范围会抛异常
        System.out.println(ite.next()); */

        // ite使用方式2
        /* for(int i = 0; i < coll.size(); i++) {
            System.out.println(ite.next());
        } */

        // ite使用方式3
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

    @Test
    public void iteratorRemoveTest() {
        // Iterator.remove() 删除迭代器当前指向的集合对象
        Collection<Object> coll = getColl();
        Iterator<Object> ite = coll.iterator();
        while (ite.hasNext()) {
            Object obj = ite.next();
            if (obj.equals(123)) {
                ite.remove();
            }
        }
        System.out.println(coll);
    }
}
