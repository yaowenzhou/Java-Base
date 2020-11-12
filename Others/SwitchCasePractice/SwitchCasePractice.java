package SwitchCasePractice;

/* 
编写程序: 从键盘上输入2019年的"month"和"day"，要求通过程序输出该日期为2019年的第几天
*/
import java.util.Scanner;

class SwitchCasePractice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入2019年的一个月份");
        int month = scan.nextInt();
        System.out.println("请输入该月份的某一天");
        int day = scan.nextInt();
        scan.close();

        // 定义一个变量用来保存总天数
        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                sumDays += 28;
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }
        System.out.println("您输入的日期是2019年的第" + sumDays + "天");
    }
}