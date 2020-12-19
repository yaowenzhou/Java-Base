import java.util.Date;

import org.junit.Test;

/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 16:33:01 Saturday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 18:25:12
 * @Version      : 
 * @Description  : 
 */
/* java.util.Date
 * > toString(); 显示当前的年 月 日 时 分 秒
 * > getTime(); 获取当前Date对象对应的毫秒数(时间戳)
 */
public class Date1 {
    @Test
    public void DateTest() {
        // 创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
        // 创建指定毫秒数的Date对象
        Date date2 = new Date(1234567890L);
        System.out.println(date2.toString());
        System.out.println(date2.getTime());
    }
}
