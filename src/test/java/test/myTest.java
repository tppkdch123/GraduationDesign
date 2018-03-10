package test;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.Data;
import org.junit.Test;

import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class myTest {
    private ActionConfigDTO returnActionDTO(String config) {
        Gson gson = new Gson();
        ActionConfigDTO actionConfigDTO = null;
        try {
            actionConfigDTO = gson.fromJson(config, ActionConfigDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actionConfigDTO;
    }

    @Test
    public void test() throws Exception {
        Timestamp timestamp = Timestamp.valueOf("2018-02-27 17:21:09" +
                "");
        System.out.println(timestamp.getTime());
    }

    @Test
    public void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("sourceCaseId", "1523606");
        System.out.println(map);
        System.out.println(new myTest().returnActionDTO("{\"leftValue\":\"{\\\"taskField\\\":[\\\"CaseMain.questionDesc\\\",\\\"WmOrder.id\\\"],\\\"eventId\\\":\\\"bobo\\\"}\",\"rightValue\":null}"));
        System.out.println(new myTest().returnActionDTO("{\"leftValue\":\"{\\\"taskField\\\":[\\\"CaseMain.id\\\"],\\\"eventId\\\":\\\"101225\\\"}\",\"rightValue\":null}"));
    }

    @Test
    public void testLamda() {
        new Button().addActionListener(event -> System.out.println("xx"));
    }

    @Test
    public void testxxx() {
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();
        list2.add("ppp");
        list.add("xxx");
        list.add("bbq");
        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                ;
                return new String("bbb");
            }
        };
        Function function1 = o -> new String("bbc");
        System.out.println(list.stream().map(function).collect(Collectors.toList()));
        Stream.of(list, list2).flatMap(string -> string.stream()).collect(Collectors.toList());
        System.out.println(Stream.of(list, list2).map(string -> string.stream()).collect(Collectors.toList()));
        List<String> yy = Stream.of(list, list2).map(string -> string + "").collect(Collectors.toList());
        System.out.println(yy.size());
        System.out.println(Stream.of(list, list2).flatMap(string -> string.stream()).collect(Collectors.toList()));
    }

}
