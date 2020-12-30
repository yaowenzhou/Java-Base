import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamMiddleOperation {
    // filter
    @Test
    public void filter() {
        Arrays.asList(0, 1, 2, 3, 4, 5).stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }

    // limit
    @Test
    public void limit() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    // skip
    @Test
    public void skip() {
        Stream.generate(Math::random).limit(10).skip(3).forEach(System.out::println);
    }

    // distinct
    @Test
    public void distinct() {
        Arrays.asList(0, 1, 2, 3, 4, 5, 3, 5, 4).stream().distinct().forEach(System.out::println);
    }

    @Test
    public void map() {
        Arrays.asList(0, 1, 2, 3, 4, 5).stream().map((i) -> i * 0.5).forEach(System.out::println);
    }

    @Test
    public void flatMap() {
        Arrays.asList(0, 1, 2, 3, 4, 5).stream().flatMap(Stream.generate(Math::random)::limit)
                .forEach(System.out::println);
        // Arrays.asList(0, 1, 2, 3, 4, 5).stream().flatMap(i -> Stream.generate(Math::random).limit(i))
        //         .forEach(System.out::println);
        // Arrays.asList(0, 1, 2, 3, 4, 5).stream()
        //         .flatMap((j) -> Stream.generate(Math::random).map(i -> i * 10 % 1).limit(j))
        //         .forEach(System.out::println);
    }
}
