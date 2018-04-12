package org.graduationdesign.service.impl;

import org.graduationdesign.entity.City;
import org.graduationdesign.entity.CityExample;
import org.graduationdesign.entity.Province;
import org.graduationdesign.entity.ProvinceExample;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.CityMapper;
import org.graduationdesign.mappers.ProvinceMapper;
import org.graduationdesign.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    ProvinceMapper provinceMapper;

    @Autowired
    CityMapper cityMapper;

    @Override
    public List<Province> getAllProvince() throws HuangShiZheException {
        ProvinceExample provinceExample = new ProvinceExample();
        ProvinceExample.Criteria criteria = provinceExample.createCriteria();
        List<Province> provinces = provinceMapper.selectByExample(provinceExample);
        return provinces;
    }

    @Override
    public List<City> getCitiesByProvinceId(Integer province) throws HuangShiZheException {
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andProvinceIdEqualTo(province);
        List<City> cities = cityMapper.selectByExample(cityExample);
        return cities;
    }

    @Override
    public List<Province> getProvinceByKeyword(String keyword) throws HuangShiZheException {
        ProvinceExample provinceExample = new ProvinceExample();
        ProvinceExample.Criteria criteria = provinceExample.createCriteria();
        criteria.andProvinceNameLike(keyword);
        List<Province> provinces = provinceMapper.selectByExample(provinceExample);
        return provinces;
    }

    @Override
    public List<City> getCityByKeyword(String keyword) throws HuangShiZheException {
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andNameLike(keyword);
        List<City> cities = cityMapper.selectByExample(cityExample);
        return cities;
    }

    @Override
    public City getCityByName(@NotNull(message = "城市名不能为空") String cityName) throws HuangShiZheException {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andNameEqualTo(cityName);
        List<City> cities = cityMapper.selectByExample(cityExample);
        if(CollectionUtils.isEmpty(cities)){
            throw new HuangShiZheException(ResultCodeEnum.CITY_NOT_EXIST);
        }
        return cities.get(0);
    }

    @Override
    public Province getProvinceByName(@NotNull(message = "省名不能为空") String provinceName) throws HuangShiZheException {
        ProvinceExample provinceExample=new ProvinceExample();
        provinceExample.createCriteria().andProvinceNameEqualTo(provinceName);
        List<Province> provinces=provinceMapper.selectByExample(provinceExample);

        if(CollectionUtils.isEmpty(provinces)){
            throw new HuangShiZheException(ResultCodeEnum.PROVINCE_NOT_EXIT);
        }

        return provinces.get(0);
    }
}
