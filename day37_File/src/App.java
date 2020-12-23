import java.io.File;

import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    @Test
    public void CreateFileInstance() {
        File file = new File("Hello.txt");
        System.out.println(file);
        File file1 = new File("./", "HelloJava");
        System.out.println(file1);
        File file2 = new File(file1, "HelloC++.txt");
        System.out.println(file2);
    }
}
