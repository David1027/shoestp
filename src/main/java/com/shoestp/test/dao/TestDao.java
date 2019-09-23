package com.shoestp.test.dao;

import com.shoestp.test.entity.Test;

/**
 * (Test)表数据库访问层自定义接口
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
public interface TestDao {
  /**
   * 通过id查询Test单个对象
   *
   * @param id id
   * @return Test实体类
   */
  Test getTest(Integer id);
}
