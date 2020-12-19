
/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 19:56:58
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-19 20:08:22
 * @version      : 
 * @Description  : 
 */
import java.util.Calendar;
import java.util.Date;

/* Canlendar: 日历类(这是一个抽象类)
 * 1. 实例化:
 *      方式一 > 创建其子类(GregorianCalendar)对象
 *      方式二 > 调用其静态方法getInstance()
 * 2. 常用方法:
 *  get()、set()、add()、getTime()、setTime()
 */
public class App {
    public static void main(String[] args) throws Exception {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        Date date =  calendar.getTime();
        System.out.println(date);

        Date newDate = new Date(123456789012L);
        calendar.setTime(newDate);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
