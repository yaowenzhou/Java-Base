import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class CreateStream {
    public static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("JackMa");
        list.add("PonyMa");
        list.add("刘强东");
        list.add("马斯克");
        list.add("比尔.盖茨");
        list.add("扎克伯格");
        list.add("C罗");
        return list;
    }

    // 通过集合创建Stream
    @Test
    public void Way1() {
        List<String> list = getList();
        // 顺序流
        Stream<String> stream = list.stream();
        // 并行流
        Stream<String> pStream = list.parallelStream();
    }

    // 通过数组创建Stream
    @Test
    public void Way2() {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        IntStream stream = Arrays.stream(arr);
        // 自定义类的stream
        Person[] arr1 = new Person[] { new Person("Tom", 22), new Person("Jerry", 13) };
        Stream<Person> stream1 = Arrays.stream(arr1);
    }

    class Person {
        String name;
        int age;

        /**
         * 
         */
        public Person() {
        }

        /**
         * @param name
         * @param age
         */
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    // 通过Stream的of
    @Test
    public void Way3() {
        Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4, 5);
    }

    // 创建无限流
    @Test
    public void Way4() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
