package com.shoestp.demo.service;

import java.util.List;

import com.shoestp.demo.dto.TestView;
import com.shoestp.demo.entity.Test;

/**
 * @description: 测试服务层接口
 * @author: lingjian
 * @create: 2019/7/12 15:17
 */
public interface TestService {

    void insert(TestView testView);

    void remove(Integer id);

    void update(TestView testView);

    List<Test> list();
}
