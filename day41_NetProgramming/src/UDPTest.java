import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

public class UDPTest {
    @Test
    public void sender() {
        DatagramSocket sock = null;
        DatagramPacket pack = null;
        InetAddress inet = null;
        try {
            // 准备UDP专用socket
            sock = new DatagramSocket();
            // 准备UDP数据包
            String str = "I am a missile sent by UDP";
            byte[] data = str.getBytes();
            inet = InetAddress.getLocalHost();
            pack = new DatagramPacket(data, 0, data.length, inet, 9090);
            // 发送数据
            sock.send(pack);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sock != null) {
                sock.close();
            }
        }
    }

    @Test
    public void receiver() {
        DatagramSocket sock = null;
        DatagramPacket pack = null;
        byte[] buffer = new byte[128];
        try {
            // 创建UDP服务端
            sock = new DatagramSocket(9090);
            // 创建用于接收UDP数据包的对象
            pack = new DatagramPacket(buffer, 0, buffer.length);
            // 接收UDP数据
            sock.receive(pack);
            System.out.println(new String(pack.getData(), 0, pack.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sock != null) {
                sock.close();
            }
        }
    }
}
