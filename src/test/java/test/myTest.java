package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.graduationdesign.enums.CommenEnum;
import org.graduationdesign.util.CommonUtil;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myTest {
    private static ExecutorService executorService = new ThreadPoolExecutor(8, 20, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

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
        System.out.println((double)380.00);
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
    public void testRandom() {
        BigDecimal bigDecimal=new BigDecimal("1.0");
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json=null;
        try {
            String s=objectMapper.writeValueAsString(bigDecimal);
            System.out.println(s);
            json="["+s+"]";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, Object.class);

        try { List L=   objectMapper.readValue(json,javaType);
            System.out.println(L.get(0) instanceof Double);
            System.out.println(((Double)L.get(0)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMySelf(){
    List<String> strs= Lists.newArrayList();
    for(int i=1;i<100;i++){
        strs.add(String.valueOf(i));
    }
    AtomicInteger atomicInteger=new AtomicInteger(strs.size());
    for(int i=0;i<strs.size();i++) {
        executorService.execute(new ggo(atomicInteger,strs.get(i)));
    }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.getAndDecrement());
        System.out.println(atomicInteger.get());
    }
public class ggo implements Runnable{
    public ggo(AtomicInteger atomicInteger, String xx) {
        this.atomicInteger = atomicInteger;
        this.xx = xx;
    }

    private AtomicInteger atomicInteger=null;
        private String xx=null;
    @Override
    public void run() {
       int qq=atomicInteger.getAndDecrement();
       System.out.println(qq);
       if(qq==1){
           System.out.println("xxxxxxxx");
       }
    }
}
    public Object getLong(String xx){
        Object oo="xx";
        return oo;
    }
    public Integer convert(Object cc){
        return (Integer)cc;
    }
    public List<Integer> getIn(Object[] c) throws Exception{
        return null;
    }

    @Test
    public void test222()throws Exception{
      System.out.println(CommenEnum.huangshizhetianxiadiyi.toString());
    }
}

