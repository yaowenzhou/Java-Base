
/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-15 21:13:46 Tuesday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-15 23:07:04
 * @Version      : 0.0.1
 * @Description  : 包装类的使用
 */

import org.junit.Test;

/**
 * 包装类的使用:
 * 1. java提供了8中基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 2. 掌握基本数据类型、包装类、String三者之间的相互转换
 */
public class WrapperTest {
    // 基本数据类型如何转换为对应的包装类
    @Test
    public void basicDataType2Wrapper() {
        int num1 = 1024;
        // The constructor Integer(int) is deprecated since version 9
        // Integer in1 = new Integer(num1);
        // instead, we should use Integer.valueOf()
        Integer in1 = Integer.valueOf(num1);
        System.out.println(in1.toString());

        // Integer in2 = new Integer("123");
        Integer in2 = Integer.valueOf("123");
        System.out.println(in2.toString());
    }

    // Wrapper class to basic data type
    @Test
    public void wrapper2BasicDataType() {
        Integer in1 = Integer.valueOf(1024);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);
    }

    /**
     * JDK 5.0 新特性: 自动装箱与自动拆箱
     */
    @Test
    public void test3() {
        int num1 = 0;
        Integer in1 = num1; // 自动装箱

        Boolean b1 = true;
        boolean b2 = b1; //自动拆箱

        System.out.println(in1);
        System.out.println(b2);
    }

    // basic data type(wrapper class) to string
    @Test
    public void basicDataTypeOrWrapper2String() {
        int num1 = 10;
        Integer in1 = 11;
        String str1 = num1 + "";
        String str2 = in1 + "";
        System.out.println(str1);
        System.out.println(str2);

        float f1 = 12.3f;
        String str3 = String.valueOf(f1);
        System.out.println(str3);
    }

    @Test
    public void test4() {
        Integer in1 = new Integer(1);
        Integer in2 = new Integer(1);
        System.out.println(in1 == in2); // false

        // 真正的原因是IntegerCache中有个缓存的数组 static final Integer cache[]
        // 这个数组存储着 [-128, 127]之间的数(这个范围的数使用频率最高)
        // 自动装箱时，直接返回相应的Integer对象，如果缓存中找不到，才会new一个Integer对象并返回
        // 因此in3 和 in4实际上指向同一个Integer对象
        Integer in3 = 1;
        Integer in4 = 1;
        System.out.println(in3 == in4); // true

        Integer in5 = 128;
        Integer in6 = 128;
        System.out.println(in5 == in6); // false

    }
}
