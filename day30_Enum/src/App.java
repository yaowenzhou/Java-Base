import java.util.Arrays;

/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-19 23:19:00
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-20 00:06:40
 * @version      : 
 * @Description  : 
 */
/**
 * 枚举类的使用
 * 1. 当需要定义一组常量时，强烈建议使用枚举类
 * 2. 如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 */
public class App {
    public static void main(String[] args) throws Exception {
        Season spring = Season.SPRING;
        System.out.println(spring);

        /* Enum 中的常用方法
        * 1. values();
        * 2. valueOf(String objName); 返回枚举类中对象名是objName的对象
        *   如果没有找到，则抛出IllegalArgumentException异常
        */
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println(Arrays.toString(Season1.values()));
        System.out.println(Season1.valueOf("WINTER"));
        System.out.println(Arrays.toString(Thread.State.values()));
        // switch 中使用enum定义的枚举类
        switch (summer) {
            case SPRING:
                break;
            case SUMMER:
                break;
            case AUTUMN:
                break;
            default:
                break;
        }
    }
}

// 自定义枚举类
class Season {
    // 1. 声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器，并给对象属性赋值
    /**
     * @param seasonName
     * @param seasonDesc
     */
    public Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    /**
     * @return the seasonName
     */
    public String getSeasonName() {
        return seasonName;
    }

    /**
     * @return the seasonDesc
     */
    public String getSeasonDesc() {
        return seasonDesc;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Season [seasonDesc=" + seasonDesc + ", seasonName=" + seasonName + "]";
    }
}

interface Info {
    void show();
}

// 使用enum定义枚举类，默认继承于java.lang.Enum类，注意观察toString方法
// 枚举类中可以实现接口，可以统一实现同一个接口
// 还可以让枚举类的对象分别实现接口中的抽象方法
enum Season1 implements Info {
    // 1. 提供当前枚举类的对象，多个对象之间用","隔开，最后一个对象用";"结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 声明属性，private final保留
    private final String seasonName;
    private final String seasonDesc;

    /**
     * @param seasonName
     * @param seasonDesc
     */
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    /**
     * @return the seasonName
     */
    public String getSeasonName() {
        return seasonName;
    }

    /**
     * @return the seasonDesc
     */
    public String getSeasonDesc() {
        return seasonDesc;
    }
}
