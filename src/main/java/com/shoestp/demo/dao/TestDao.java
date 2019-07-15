package com.shoestp.demo.dao;

import com.shoestp.demo.entity.Test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 测试类数据访问层
 * @author: lingjian
 * @create: 2019/7/12 15:15
 */
public interface TestDao extends JpaRepository<Test,Integer> {
}
