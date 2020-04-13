package com.shoestp.car.dao;


import com.shoestp.car.entity.Car;

/**
 * (Car)表数据库访问层自定义接口
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
public interface CarDao  {
    /**
     * 通过id查询Car单个对象
     * @param id id
     * @return Car实体类
     */
    Car getCar(Long id);
}
