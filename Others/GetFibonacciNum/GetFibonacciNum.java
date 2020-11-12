package GetFibonacciNum;

import java.util.Scanner;

public class GetFibonacciNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a integer:");
        int N = scanner.nextInt();
        scanner.close();
        
        switch (N) {
            case 0:
                System.out.println(0);
                return;
            case 1:
                System.out.println(1);
                return;
            case 2:
                System.out.println(2);
                return;
        }
        int sum_1 = 2;
        int sum_2 = 1;
        int sum = 0;
        for (int i = 3; i <= N; i++) {
            sum = sum_1 + sum_2;
            sum_2 = sum_1;
            sum_1 = sum;
        }
        System.out.println(sum);
    }
}
