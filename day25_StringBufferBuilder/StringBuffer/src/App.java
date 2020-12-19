import org.junit.Test;

public class App {
    public static void main(String[] args) {
        /*
         * StringBuffer: 可变的字符序列，线程安全，效率低
         */
        System.out.println("Hello Java!");
    }

    @Test
    public void StringBufferTest() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }
}
