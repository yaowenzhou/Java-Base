/* 可变个数形参
 * 1. 格式: dataType ... varName
 * 2. 当调用可变个数形参的方法时，传入的参数可以为任意个数
 * 3. 可以与同名方法构成重载，但是不能和形参为同类型数组的方法构成重载，这个应该很容易理解
 * 4. 可变个数形参必须声明在末尾(依据这个规则，一个方法中最多只能存在一个可变形参)
*/
public class variableNumberArgsTest {
    public static void show(String... args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
    }

    public static void main(String[] args) {
        show("arg1", "arg2", "arg3");
    }
}
