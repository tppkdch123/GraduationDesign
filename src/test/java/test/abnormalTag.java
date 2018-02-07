package test;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import org.junit.Test;

@Data
public class abnormalTag {
    private String content;
    private boolean color;
    abnormalTag(String content,boolean color){
        this.content=content;
        this.color=color;
    }
    abnormalTag(){}
}
