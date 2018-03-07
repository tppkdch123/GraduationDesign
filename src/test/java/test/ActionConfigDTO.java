package test;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActionConfigDTO implements Serializable {
    private static final long serialVersionUID = 7474258404737425491L;
    private String leftValue;

    private String rightValue;

}