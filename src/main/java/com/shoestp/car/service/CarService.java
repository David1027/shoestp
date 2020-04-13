package com.shoestp.car.service;

import com.shoestp.car.entity.Car;
import com.shoestp.common.pojo.PageView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * (Car)表服务接口
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
public interface CarService {
  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  Car getById(Long id);

  /**
   * 多条件分页查询所有数据
   *
   * @param pageable 分页对象
   * @return 对象列表
   */
  Page<Car> listByPage(Pageable pageable);

  /**
   * 新增数据/编辑数据
   *
   * @param carView 实例对象
   */
  void save(Car carView);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  void deleteById(Long id);
}
