import java.io.ByteArrayOutputStream;
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

public class TCPTest3 {
    @Test
    public void client() {
        Socket sock = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try {
            sock = new Socket(InetAddress.getByName("localhost"), 9090);
            os = sock.getOutputStream();
            fis = new FileInputStream(new File("xxx.avi"));
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            sock.shutdownOutput();
            // 接收服务器端的数据并显示到控制台
            is = sock.getInputStream();
            baos = new ByteArrayOutputStream();
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        OutputStream os = null;
        FileOutputStream fos = null;

        try {
            ssock = new ServerSocket(9090);
            sock = ssock.accept();
            is = sock.getInputStream();
            fos = new FileOutputStream("xxx.copy.avi");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            // 服务端接收完毕数据后，给予客户端反馈
            os = sock.getOutputStream();
            os.write("文件已收到!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
