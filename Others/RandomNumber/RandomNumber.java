package RandomNumber;

public class RandomNumber {
    public static void main(String[] args) {
        // 产生一个随机数，范围为[0.0-1.0)
        int val = (int) (Math.random() * 90 + 10);
        System.out.println(val);
    }
}
