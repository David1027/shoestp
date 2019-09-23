package com.shoestp.test.repository;


import com.shoestp.common.repository.BaseRepository;
import com.shoestp.test.entity.Test;
import com.shoestp.test.dao.TestDao;

/**
 * (Test)表数据库访问层接口
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
public interface TestRepository extends BaseRepository<Test,Integer>, TestDao {}