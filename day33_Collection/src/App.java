import java.util.ArrayList;
import java.util.List;

/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-20 19:28:50
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-20 20:54:14
 * @version      : 
 * @Description  : 
 */
/**
 * Collection: 单列集合，用来存储一个一个的对象
 *  --> List: 存储有序的，可重复的数据 -> 动态数组，替换原有的数组
 *      --> ArrayList: 作为List的主要实现类，线程不安全的，效率高，底层使用Object[]存储
 *      --> LinkedList: 对于频繁的插入、删除操作。使用此类效率比ArrayList要高，底层使用双向链表存储
 *      --> Vector: 作为List接口的古老实现类，线程安全的，但是效率低，底层使用Object[]存储
 * 三个类都实现了List接口，存储数据的特点相同: 存储有序的、可重复的数据
 */
public class App {
    public static void main(String[] args) throws Exception {
        List list = new ArrayList(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println(list);
    }
}

// ArrayList 源码分析
// JDK7 和 JDK8中ArrayList源码不同
/* 2.1 jdk 7情况下
 *  ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *  list.add(123);//elementData[0] = new Integer(123);
 *  ...
 *  list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *  默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *  结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 * 2.2 jdk 8中ArrayList的变化：
 *  ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
 *  list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *  ...
 *  后续的添加和扩容操作与jdk 7 无异。
 * 2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 *  的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 * 3. LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *           E item;
 *           Node<E> next;
 *           Node<E> prev;
 *           Node(Node<E> prev, E element, Node<E> next) {
 *           this.item = element;
 *           this.next = next;
 *           this.prev = prev;
 *          }
 *      }
 *
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *      在扩容方面，默认扩容为原来的数组长度的2倍。
 */
