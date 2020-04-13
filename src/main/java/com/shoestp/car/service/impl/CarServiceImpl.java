package com.shoestp.car.service.impl;

import com.shoestp.car.entity.Car;
import com.shoestp.car.repository.CarRepository;
import com.shoestp.car.service.CarService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * (Car)表服务实现类
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
@Service("CarService")
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;

  public CarServiceImpl(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  @Override
  public Car getById(Long id) {
    return carRepository.getCar(id);
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param page 分页对象
   * @return 对象列表
   */
  @Override
  public Page<Car> listByPage(Pageable page) {
    return carRepository.findAll(page);
  }

  /**
   * 新增数据/编辑数据
   *
   * @param car 实例对象
   */
  @Override
  public void save(Car car) {
    carRepository.save(car);
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  @Override
  public void deleteById(Long id) {
    carRepository.deleteById(id);
  }
}
