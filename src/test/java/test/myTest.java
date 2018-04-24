package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.commons.lang3.StringUtils;
import org.graduationdesign.enums.CommenEnum;
import org.graduationdesign.util.CommonUtil;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.websocket.Encoder;
import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
        Map paramsMap = new LinkedHashMap<String, String>();
        //paramsMap.put("address", "百度大厦");
        // paramsMap.put("output", "json");
        paramsMap.put("ak", "4AWbhbXnGptGBuy4rlyDNd5rHfSPQeZR");
        String paramsStr = toQueryString(paramsMap);
        String wholeStr = new String("/location/ip?" + paramsStr + "OGs7Tl476u4IIkR0Z6dcSE68gV3KHfOG");

        // 对上面wholeStr再作utf8编码
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        System.out.println(MD5(tempStr));

    }

    // 对Map内所有value作utf8编码，拼接返回结果
    public String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
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
        String x = "\\u5317\\u4eac\\u5e02";
        char[] c = x.toCharArray();
        String op = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            stringBuilder.append(Integer.toBinaryString(c[i]));
        }
        op = stringBuilder.toString();
        System.out.println(op);
        try {
            byte[] vv = x.getBytes("unicode");
            for (int i = 0; i < vv.length; i++) {
                System.out.print(vv[i]);
            }
            System.out.println();
            byte[] b = new byte[op.length()];
            for (int i = 0; i < b.length; i++) {
                b[i]=Byte.valueOf(String.valueOf(op.charAt(i)));
                System.out.print(b[i]);
            }

            System.out.println(new String(b, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMySelf() {
        List<String> strs = Lists.newArrayList();
        for (int i = 1; i < 100; i++) {
            strs.add(String.valueOf(i));
        }
        AtomicInteger atomicInteger = new AtomicInteger(strs.size());
        for (int i = 0; i < strs.size(); i++) {
            executorService.execute(new ggo(atomicInteger, strs.get(i)));
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

    public class ggo implements Runnable {
        public ggo(AtomicInteger atomicInteger, String xx) {
            this.atomicInteger = atomicInteger;
            this.xx = xx;
        }

        private AtomicInteger atomicInteger = null;
        private String xx = null;

        @Override
        public void run() {
            int qq = atomicInteger.getAndDecrement();
            System.out.println(qq);
            if (qq == 1) {
                System.out.println("xxxxxxxx");
            }
        }
    }

    public Object getLong(String xx) {
        Object oo = "xx";
        return oo;
    }

    public Integer convert(Object cc) {
        return (Integer) cc;
    }

    public List<Integer> getIn(Object[] c) throws Exception {
        return null;
    }

    @Test
    public void test222() throws Exception {
        System.out.println(CommenEnum.huangshizhetianxiadiyi.toString());
    }
}

