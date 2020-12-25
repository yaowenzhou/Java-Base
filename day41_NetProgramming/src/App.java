import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    // 在Java中使用InetAddress类代表ip
    // 实例化InetAddress:
    //          > InetAddress.getByName(String host); // host可以是域名，也可以是ip对应的字符串
    //          > InetAddress.getLocalHost(); // 获取本地ip
    // 两个常用方法: getHostName(); getHostAddress();
    @Test
    public void InetAddressTest() {
        try {
            InetAddress inet1 = InetAddress.getByName("14.17.22.33");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
