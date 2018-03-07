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

    @Test
    public void testStream() {
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();
        list2.add("ppp");
        list.add("xxx");
        list.add("bbq");
        list.add("aaaa");
        list.stream().map(string -> {
            System.out.println(string);
            return string;
        }).collect(Collectors.maxBy(Comparator.comparing(str->str.length())));
        List<setout> setouts= Lists.newArrayList();
        setouts.add(new setout("name1","1",Boolean.TRUE));
        setouts.add(new setout("name2","2",Boolean.FALSE));
        setouts.add(new setout("name3","3",Boolean.FALSE));
        setouts.add(new setout("name4","4",Boolean.TRUE));
        setouts.add(new setout("name5","1",Boolean.FALSE));
        setouts.add(new setout("name7","4",Boolean.TRUE));
        setouts.add(new setout("name6","3",Boolean.FALSE));
        System.out.println(setouts.stream().collect(Collectors.partitioningBy(setout::getH)));
        System.out.println(setouts.stream().collect(Collectors.groupingBy(setout::getId)));
        System.out.println(list.stream().collect(Collectors.joining(",","[","]")));

    }
}
 interface bbq {
   default void bbs(){
       System.out.println("bbs");
   }
}
interface bbqparent extends bbq,Serializable{
   default void bbs(){
        System.out.println("bbsparent");
    }
}

@Data
class setout{

    public setout(String name, String id, Boolean h) {
        this.name = name;
        this.id = id;
        H = h;
    }

    String name;
    String id;
    Boolean H;

        }
