package com.shoestp.test.dao;

import com.shoestp.test.entity.Test;

/**
 * @description: 数据访问层自定义接口
 * @author: lingjian
 * @create: 2019/9/23 11:38
 */
public interface TestDao {

  /**
   * 根据id获取Test实体类对象
   *
   * @param id id
   * @return Test对象
   */
  Test getTest(Integer id);
}
