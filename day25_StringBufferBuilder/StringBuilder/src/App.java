/* StringBuilder: 可变的字符序列
 * jdk5.0新增的，线程不安全，效率高
 */
public class App {
    public static void main(String[] args) {
        StringBuilder bu = new StringBuilder("看我神威，无坚不摧");
        bu.setCharAt(0, '视');
        System.out.println(bu);
        System.out.println(bu.reverse());
    }
}
