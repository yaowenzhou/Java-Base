import java.util.Arrays;

/* java.util.Arrays:
 *  Tool class for manipulating arrays
 *  操作数组的工具类
 *  Defines many methods to manipulate arrays
 *  定义了很多操作数组的方法
*/
public class ArraysTest {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4 };
        int[] arr2 = new int[] { 1, 3, 2, 4 };
        // 1. public static boolean equals(int[] a, int[] a2)
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);
        // 2. public static String toString(int[] a)
        System.out.println(Arrays.toString(arr1));
        // 3. public static void fill(int[] a, int val)
        Arrays.fill(arr1, 0);
        System.out.println(Arrays.toString(arr1));
        // 4. public static void sort(int[] a)
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        // 5. public static int binarySearch(int[] a, int key)
        int index = Arrays.binarySearch(arr2, 2);
        System.out.println(index);
    }
}
