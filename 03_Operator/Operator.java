import java.security.Principal;

public class Operator {
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 5;

        int result1 = num1 / num2;
        System.out.println(result1); // 2

        int result2 = num1 / num2 * num2;
        System.out.println(result2); // 10

        double result3 = num1 / num2;
        System.out.println(result3); // 2.0

        double result4 = num1 / num2 + 0.0;
        double result5 = num1 / (num2 + 0.0);
        double result6 = (double) num1 / num2;
        System.out.println(result4); // 2.0
        System.out.println(result5); // 2.4
        System.out.println(result6); // 2.4

        // 取模运算
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1); // m1 % n1 = 2

        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2); // m2 % n2 = -2

        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 = " + m3 % n3); // m3 % n3 = 2

        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 = " + m4 % n4); // m4 % n4 = -2

        // 赋值运算符
        // +=
        short s1 = 10;
        s1 += 2;
        System.out.println(s1); // 12
        // -= 略
        // *=
        int i = 1;
        i *= 0.1;
        System.out.println(i);  // 0
        i++;
        System.out.println(i);  // 0.1
    }
}
