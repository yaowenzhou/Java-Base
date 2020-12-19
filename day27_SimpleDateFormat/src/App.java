import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 18:26:40
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 18:59:00
 * @version      : 
 * @Description  : 
 */
public class App {
    public static void main(String[] args) throws Exception {
        /* SimpleDateFormat的使用:
         * 1. 两个操作
         * 1.1 格式化: 日期 --> 字符串
         * 1.2 解析: 字符串 --> 日期
         * 
         * 2. SimpleDateFormat实例化
         */
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);
        System.out.println(sdf.parse("12/19/20, 6:42 PM"));
        // 还可以在构造时指定pattern，这样格式化或者解析时间时，就会按照pattern进行
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd EEEEE hh:mm aaa");
        System.out.println(sdf1.format(date));
    }
}
