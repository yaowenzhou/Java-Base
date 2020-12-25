import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-24 22:34:32 Thursday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-25 00:33:31
 * @Version      : 
 * @Description  : RandomAccessFile
 */

/**
 * RandomAccessFile直接继承于java.lang.Object，实现了DataInput和DataOutput接口
 * 既可以作为一个输入流，也可以作为一个输出流
 */
public class RandomAccess {
    @Test
    public void CreateRandomAccessFile() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("E:\\Code\\Java-Base\\day40_ObjectStream\\Lamborghini.jpg"), "r");
            raf2 = new RandomAccessFile(new File("E:\\Code\\Java-Base\\day40_ObjectStream\\Lamborghini1.jpg"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* 如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中会自动创建
     * 如果写出到的文件存在，则会对原有文件内容进行覆盖(默认情况下从头覆盖)
     * 可以通过seek(long position); 设置文件指针，实现随机访问
     * 如果想实现插入效果，只能先将插入位置极其后面的所有数据全部读取，然后再插入并进行写覆盖
     */
    @Test
    public void coverFileWhenAccessFile() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("E:\\Code\\Java-Base\\day40_ObjectStream\\Hello.txt"), "rw");
            raf1.write("abc".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // StringBuilder实现插入
    @Test
    public void StringBuilderAccessFile() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("E:\\Code\\Java-Base\\day40_ObjectStream\\Hello.txt"), "rw");
            raf1.seek(3);
            StringBuilder builder = new StringBuilder(
                    (int) new File("E:\\Code\\Java-Base\\day40_ObjectStream\\Hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }
            raf1.seek(3);
            raf1.write("xyz".getBytes());
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
