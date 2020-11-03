/* 
    Output all prime numbers within N
*/
public class PrintPrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        // get current time(ms)
        long start = System.currentTimeMillis();
        label: for (int i = 2; i <= 10; i++) {
            // System.out.println(i);
            int maxJ = (int) Math.sqrt(i);
            for (int j = 2; j <= maxJ; j++) {
                if (i % j == 0) {
                    continue label;
                }
            }
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms total.");
        System.out.println(count + " prime numbers total");
    }
}
