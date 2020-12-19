public class MainApp {
    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        // 开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 的执行时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 的执行时间: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            text += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 的执行时间: " + (endTime-startTime));
    }
}
