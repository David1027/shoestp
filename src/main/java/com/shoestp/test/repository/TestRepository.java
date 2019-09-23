package com.shoestp.test.repository;

import com.shoestp.common.repository.BaseRepository;
import com.shoestp.test.dao.TestDao;
import com.shoestp.test.entity.Test;

/**
 * @description: Test数据访问层接口
 * @author: lingjian
 * @create: 2019/9/23 13:35
 */
public interface TestRepository extends BaseRepository<Test, Integer>, TestDao {}
