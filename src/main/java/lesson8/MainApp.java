package lesson8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        new Thread(
                () -> {

                }
        );
        doSome(() -> {
            System.out.println("X = " + 100);
        });
        doSome(() -> System.out.println("Java" + "Script"));
        Stream.of("AA", "BBB", "CC", "DDD").map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5).map((s) -> s * 10).forEach(System.out::println);

        IntStream.rangeClosed(0, 10).parallel().filter(n -> {
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return n % 2 == 0;
        }).count();
    }

    public static void doSome(Runnable runnable) {
        runnable.run();
    }
}
