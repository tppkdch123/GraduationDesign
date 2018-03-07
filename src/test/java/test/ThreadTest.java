package test;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadTest {
    @Test
    public void testThreadMXBean(){
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfo=threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo1:threadInfo){
            System.out.println(threadInfo1.getThreadId()+" "+threadInfo1.getThreadName());
        }
    }
}
