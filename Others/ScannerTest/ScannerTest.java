package ScannerTest;

/*
    从键盘获取不同类型的变量，需要使用Scanner类
    具体实现步骤：
    1. 导包： import java.util.Scanner;
    2. Scanner 的实例化
    3. 调用Scanner类的相关方法
*/
import java.util.Scanner;

class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a number...");
        int num = scan.nextInt();
        System.out.println(num);
    }
}
