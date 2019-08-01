package com.shoestp.test.dao.impl;



import com.shoestp.test.entity.Test;
import com.shoestp.test.entity.QTest;
import com.shoestp.common.dao.BaseRepository;


/**
 * (Test)表数据库访问层实现类
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
public class TestDaoImpl extends BaseRepository {

    /**
     * 根据id获取Test实体类对象
     *
     * @param id id
     * @return Test对象
     */
    public Test getTest(Integer id) {
        QTest qTest = QTest.test;
        return queryFactory.selectFrom(qTest)
                .where(qTest.id.eq(id)).fetchOne();
    }

}