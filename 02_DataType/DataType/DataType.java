public class DataType {
    public static void main(String[] args) {
        // 整数
        byte by1 = 1;
        /*
         * byte 类型和整数常量进行计算时 整数常量默认为int类型，byte类型的变量也会自动类型提升为int 并且因此不能直接使用byte类型的变量来接收
         * 需要使用int或者long或者其它可以由int自动类型提升的变量来进行接收 或者在接手前使用强转符将结果强转为byte 另外，byte类型的变量可以自增
         */
        by1++;
        by1 = (byte) (by1 + 12);
        System.out.println(by1);

        // String
        /*
         * 1. String 属于引用数据类型 2. 声明String类型变量时，使用一对双引号包含字符串 3. String
         * 类型变量可以和8种类型的变量进行运算，且只能是连接运算“+”
         */
        int number = 123;
        String student = "学号: ";
        String studentInfo = student + number;
        boolean bool = true;
        String info1 = studentInfo + bool;
        System.out.println(info1);
        /* 
        强化练习:
        String str = 4;             // false
        String str2 = 3.5f + "";    // true "3.5"
        System.out.println(3 + 4 + "Hello!");   // "7Hello!"
        System.out.println("Hello!" + 3 + 4);   // "Hello!34"
        System.out.println('a' + 1 + "Hello!"); // "98Hello!"
        System.out.println("Hello" + 'a' + 1);  // "Hello!a1"
        */
    }
}
