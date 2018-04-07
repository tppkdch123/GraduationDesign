package org.graduationdesign.service.impl;

import org.graduationdesign.entity.Meta;
import org.graduationdesign.entity.MetaExample;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.MetaMapper;
import org.graduationdesign.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    MetaMapper metaMapper;

    @Override
    public Meta getMetaById(Integer id) throws HuangShiZheException {
        MetaExample metaExample=new MetaExample();
        MetaExample.Criteria criteria=metaExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Meta> metas=metaMapper.selectByExample(metaExample);

        if(CollectionUtils.isEmpty(metas)){
            throw new HuangShiZheException(ResultCodeEnum.META_NOT_EXIT);
        }

        return metas.get(0);
    }

    @Override
    public List<Meta> getMetaByIds() throws HuangShiZheException {

        return null;
    }
}
