package com.shoestp.test.dao.impl;

import com.shoestp.test.entity.Test;
import com.shoestp.test.dao.TestDao;
import com.shoestp.test.entity.QTest;
import com.shoestp.common.dao.BaseDao;

import org.springframework.stereotype.Repository;

/**
 * (Test)表数据库访问层自定义接口实现类
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
@Repository
public class TestDaoImpl extends BaseDao implements TestDao {

  /**
   * 根据id获取Test实体类对象
   *
   * @param id id
   * @return Test对象
   */
  @Override
  public Test getTest(Integer id) {
    QTest qTest = QTest.test;
    return queryFactory.selectFrom(qTest).where(qTest.id.eq(id)).fetchOne();
  }
}
