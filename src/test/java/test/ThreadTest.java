package test;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    @Test
    public void testThreadMXBean() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfo = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo1 : threadInfo) {
            System.out.println(threadInfo1.getThreadId() + " " + threadInfo1.getThreadName());
        }
    }

    @Test
    public void testThread() {
        final Map<String, Integer> map = new HashMap<>();
        map.put("ss", 0);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            for (int i = 0; i < 100; i++) {
                map.put("ss", map.get("ss") + 2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(map.get("ss") + "=====================================");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.execute(() -> map.put("ss", 1));
        for (int i = 0; i < 1000; i++) {
            try {
                testThreadMXBean();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
