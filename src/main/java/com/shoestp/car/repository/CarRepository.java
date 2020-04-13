package com.shoestp.car.repository;

import com.shoestp.common.repository.BaseRepository;
import com.shoestp.car.entity.Car;
import com.shoestp.car.dao.CarDao;

/**
 * (Car)表数据库访问层接口
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
public interface CarRepository extends BaseRepository<Car, Long>, CarDao {}
