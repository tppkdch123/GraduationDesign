package test;

import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StreamTest {
    private static List<Integer> bigList = new ArrayList<>();
    private static List<String> bigStringList = new ArrayList<>();
    private static List<String> bigStringLinkedList = new ArrayList<>();

    static {
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < 10000000; i++) {
            bigStringList.add(uuid);
            bigStringLinkedList.add(uuid);
        }
        for (int i = 0; i < 100000; i++) {
            bigList.add(i);
        }
    }

    @Test
    public void testLinked() {
        long startTime = System.currentTimeMillis();
        List<String> list = bigStringLinkedList.stream().map(str -> str.toUpperCase().trim()).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void bigTest() {
        long startTime = System.currentTimeMillis();
        List<String> list = bigStringList.stream().map(str -> str.toUpperCase().trim()).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void testLinked2() {
        long startTime = System.currentTimeMillis();
        List<String> list = bigStringLinkedList.stream().parallel().map(str -> str.toUpperCase().trim()).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void bigTest2() {
        long startTime = System.currentTimeMillis();
        List<String> list = bigStringList.stream().parallel().map(str -> str.toUpperCase().trim()).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void test() {
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce((acc, element) -> acc + element).get());
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        int count = binaryOperator.apply(binaryOperator.apply(binaryOperator.apply(binaryOperator.apply(1, 2), 3), 4), 5);
    }

    @Test
    public void testReduce() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 8, 11).parallel();
        System.out.println(stream.reduce(new ArrayList<Integer>(), (result, b) -> {
            result.add(b);
            return result;
        }, (c, d) -> {
            return c;
        }));
    }

    public void bbq(List<Integer> list, List<Integer> list2) {

        list2.stream().forEach(integer -> {
            if (!list.contains(integer)) list.add(integer);
        });
    }

}
