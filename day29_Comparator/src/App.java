
/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 21:51:21
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 22:46:33
 * @version      : 
 * @Description  : 
 */
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Test
    public void ComparableTest() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("小米", 69);
        goods[1] = new Goods("罗技", 399);
        goods[2] = new Goods("联想", 39);
        goods[3] = new Goods("雷柏", 59);
        goods[4] = new Goods("达尔优", 40);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /* 定制排序
     * 实现Comparator接口，重写compare方法
     */
    @Test
    public void ComparatorTest() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("小米", 69);
        goods[1] = new Goods("罗技", 399);
        goods[2] = new Goods("联想", 39);
        goods[3] = new Goods("雷柏", 59);
        goods[4] = new Goods("达尔优", 40);
        Arrays.sort(goods, new Comparator<Goods>(){
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if(o1.getPrice() < o2.getPrice()){
                    return -1;
                }
                return 0;
            }
            
        });
        System.out.println(Arrays.toString(goods));
    }
}

/* 对于自定义类来说
 * 如果需要排序，我们可以让自定义类实现Comparable接口
 * 重写compareTo(obj)方法
 * 在compareTo(obj)中指明如何排序
 */
class Goods implements Comparable<Object> {
    private String name;
    private double price;

    public Goods() {
    }

    /**
     * @param name
     * @param price
     */
    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
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
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Goods [name=" + name + ", price=" + price + "]";
    }

    // 指明商品比较大小的方式: 按照价格从高到底排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            }
            return 0;
            // 方式2
            // return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("Invalid arguements...");
    }
}