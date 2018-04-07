package org.graduationdesign.service;

import org.graduationdesign.entity.Meta;
import org.graduationdesign.exception.HuangShiZheException;

import java.util.List;

public interface MetaService {
    Meta getMetaById(Integer id) throws HuangShiZheException;

    List<Meta> getMetaByIds() throws HuangShiZheException;
}
