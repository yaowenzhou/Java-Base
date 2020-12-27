
/**
 * @Author       : yaowenzhou
 * @Date         : 2020-12-25 22:26:17
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-25 23:13:19
 * @version      : 
 * @Description  : 
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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

    // 客户端发送信息给服务端，服务端将数据显示到控制台
    @Test
    public void TCPServer() {
        ServerSocket ss = null;
        Socket socket = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            // 1. 创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            // 2. 调用accept()用于接受来自于客户端的socket
            socket = ss.accept();
            // 3. 获取输入流
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[200];
            int len = 0;
            // 4. 读取数据
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void TCPClient() {
        InetAddress inet = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            inet = InetAddress.getByName("localhost");
            // 1. 创建socket对象，指明服务端的ip和端口号
            socket = new Socket(inet, 8899);
            // 2. 获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            // 3. 写数据
            os.write("Hello, I'm client...".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
