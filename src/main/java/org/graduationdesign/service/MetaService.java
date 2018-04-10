package org.graduationdesign.service;

import org.graduationdesign.entity.Meta;
import org.graduationdesign.exception.HuangShiZheException;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface MetaService {
    Meta getMetaById(@NotNull(message = "metaId不能为空") Integer id) throws HuangShiZheException;

    List<Meta> getMetaByIds(@NotNull(message = "参数不能为空") List<Integer> ids) throws HuangShiZheException;
}
