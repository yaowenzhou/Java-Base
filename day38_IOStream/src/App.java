import java.io.*;
import java.util.Arrays;

import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    @Test
    public void FileReaderTest() {
        File file = new File(System.getProperty("java.home") + "/../../Code/");
        // System.out.println(Arrays.toString(file.list()));
        FileReader fr = null;
        // System.out.println(System.getProperty("java.home"));
        // read(): 返回读入的一个字符，如果达到文件末尾，返回-1
        int data;
        try {
            fr = new FileReader(file);
            data = fr.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileReaderTest1() {
        File file = new File(System.getProperty("java.home") + "/../../Code/");
        // System.out.println(Arrays.toString(file.list()));
        FileReader fr = null;
        // System.out.println(System.getProperty("java.home"));
        // read(): 返回读入的一个字符，如果达到文件末尾，返回-1
        char[] cbuf = new char[5];
        try {
            int len = 0;
            fr = new FileReader(file);
            while ((len = fr.read(cbuf)) != -1) {
                // for (int i = 0; i < len; i++) {
                //     System.out.println(cbuf[i]);
                // }
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* 输出操作，对应的文件可以不存在
     * 如果不存在，在输出的过程中会自动创建此文件
     * 如果存在:
     *      > 流使用的构造器是FileWriter(file, false)/FileWriter(file): 对原有文件进行覆盖
     *      > 流使用的构造器是FileWriter(file, true): 不会对原有文件进行覆盖，会直接追加
     */
    @Test
    public void FileWriterTest() {
        // Provide file object
        File file = new File("Hello.txt");
        FileWriter fw = null;
        try {
            // Provide FileWriter object for data writing
            fw = new FileWriter(file);
            fw.write("I have a dream.");
            fw.write("You need have a dream.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
            }
        }
    }

    @Test
    public void BufferedStreamTest() {
        // 1. 造文件
        File srcFile = new File("xxx.jpg");
        File tarFile = new File("yyy.jpg");
        // 2. 造流
        // 2.1 造节点流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 2.2 造缓冲流 
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(tarFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节
            byte[] buffer = new byte[10];
            int len = 0;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (Exception e) {
        } finally {
            try {
                // 4. 资源关闭
                // 要求: 先关闭外层的流，再关闭内层的流
                if (bis != null) {
                    bis.close();
                    bis = null;
                }
                if (bos != null) {
                    bos.close();
                    bos = null;
                }
                /*
                 * 关闭外层流时，会自动关闭内层流
                 * fis.close();
                 * fos.close();
                */
            } catch (Exception e) {
            }
        }
    }

    @Test
    public void TransformStreamTest() throws IOException {
        // 1. 造文件，造流
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        char[] cbuf = new char[20];
        int len;
        // 2. 读写过程
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        // 3. 关闭资源
        isr.close();
        osw.close();
    }

    // 从键盘读取字符串，要求将读取到的郑航字符串转换成大写输出，然后继续操作
    // 直至输入"e"或者"exit"时，退出程序
    @Test
    public void StandOutputInputPractice() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            while (true) {
                System.out.println("请输入字符串:");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exte".equalsIgnoreCase(data)) {
                    System.out.println("程序结束.");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
