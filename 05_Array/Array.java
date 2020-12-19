/**
 * @Author       : yaowenzhou
 * @Date         : 2020-11-20 21:52:41
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 16:06:50
 * @version      : 
 * @Description  : 
 */
import java.util.Arrays;

/* 
    1. 一维数组的声明和初始化
    2. 如何访问数组指定位置的元素
    3. 如何获取数组的长度
    4. 如何遍历数组
    5. 数组元素的默认初始化值
    6. 数组的内存解析
    7. 数组的默认初始化值(和数组元素的类型有关)
        >整型:     0
        >浮点型:   0.0
        >char:    空字符、0、'\u0000'
        >boolean:   false
        >引用:      null
*/
public class Array {
    public static void main(String[] args) {
        // 一维数组的声明和初始化
        int[] ids; // 声明
        // 静态初始化(数组的初始化和数组元素的赋值操作同时进行)
        ids = new int[] { 1001, 1002, 1003, 1004 };
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        // 动态初始化(数组的初始化和数组元素的赋值操作分开进行)
        String[] names = new String[3];
        // 除了这两种初始化方式，都是错误的
        names[0] = "看我神威，无坚不摧";
        names[1] = "死亡如风，常伴吾身";
        names[2] = "无形之刃，最为致命";
        // 获取数组长度
        System.out.println(names.length);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        // 二维数组初始化
        String[][] arr1 = new String[3][2];
        String[][] arr2 = new String[3][];
        int[][] arr3 = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        System.out.println(arr1);
        System.out.println(arr2);
        System.out.println(arr3);

        // 类型推断
        int arr5[] = { 1, 2, 3, 4, 5 };
        /*
         * 下面这种写法有问题 int arr6[] = new int[3]; arr6={1,2,3};
         */
        System.out.println("array5: " +  Arrays.toString(arr5));
    }
}
