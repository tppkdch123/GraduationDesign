package org.graduationdesign.vo;

import lombok.Data;
import org.graduationdesign.entity.Meta;

import java.io.Serializable;

@Data
public class MetaVO extends Meta implements Serializable{
    private String metaValue;
}