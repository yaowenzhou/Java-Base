import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-25 23:14:30 Friday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-25 23:14:35
 * @Version      : 
 * @Description  : The client sends the file to the server, and the server saves the file locally
 */

public class TcpTest2 {
    @Test
    public void client() {
        Socket sock = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            sock = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            os = sock.getOutputStream();
            fis = new FileInputStream(
                    new File("E:\\Code\\Java-Base\\day41_NetProgramming\\20-尚硅谷-Java语言高级-TCP网络编程例题2.avi"));
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ssock = null;
        Socket sock = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            ssock = new ServerSocket(9090);
            sock = ssock.accept();
            is = sock.getInputStream();
            fos = new FileOutputStream(
                    new File("E:\\Code\\Java-Base\\day41_NetProgramming\\20-尚硅谷-Java语言高级-TCP网络编程例题2.copy.avi"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
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
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ssock != null) {
                try {
                    ssock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
