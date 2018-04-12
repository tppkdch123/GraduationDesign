package org.graduationdesign.service;

import org.graduationdesign.entity.City;
import org.graduationdesign.entity.Province;
import org.graduationdesign.exception.HuangShiZheException;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface LocationService {

    List<Province> getAllProvince() throws HuangShiZheException;

    List<City> getCitiesByProvinceId(@NotNull(message = "provinceId不能为空") Integer provinceId) throws HuangShiZheException;

    List<Province> getProvinceByKeyword(@NotNull(message="关键字不能为空") String keyword) throws HuangShiZheException;

    List<City> getCityByKeyword(@NotNull(message = "关键字不能为空") String keyword) throws HuangShiZheException;

    City getCityByName(@NotNull(message="城市名不能为空") String cityName) throws HuangShiZheException;

    Province getProvinceByName(@NotNull(message="省名不能为空") String provinceName) throws HuangShiZheException;
}
