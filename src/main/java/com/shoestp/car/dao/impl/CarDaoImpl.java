package com.shoestp.car.dao.impl;

import com.shoestp.car.dao.CarDao;
import com.shoestp.car.entity.Car;
import com.shoestp.car.entity.QCar;
import com.shoestp.common.dao.BaseDao;

import org.springframework.stereotype.Repository;

/**
 * (Car)表数据库访问层自定义接口实现类
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
@Repository
public class CarDaoImpl extends BaseDao implements CarDao {

  /**
   * 根据id获取Car实体类对象
   *
   * @param id id
   * @return Car对象
   */
  @Override
  public Car getCar(Long id) {
    QCar qCar = QCar.car;
    return queryFactory.selectFrom(qCar).where(qCar.id.eq(id)).fetchOne();
  }
}
