package com.shoestp.demo.service.impl;

import java.util.List;

import com.shoestp.demo.dao.TestDao;
import com.shoestp.demo.dto.TestView;
import com.shoestp.demo.entity.Test;
import com.shoestp.demo.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 测试服务层实现类
 * @author: lingjian
 * @create: 2019/7/12 15:17
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public void insert(TestView testView) {
        Test test = new Test();
        test.setName(testView.getName());
        testDao.save(test);
    }

    @Override
    public void remove(Integer id) {
        testDao.deleteById(id);
    }

    @Override
    public void update(TestView testView) {
        Test test = testDao.getOne(testView.getId());
        test.setName(testView.getName());
        testDao.saveAndFlush(test);
    }

    @Override
    public List<Test> list() {
        return testDao.findAll();
    }
}
