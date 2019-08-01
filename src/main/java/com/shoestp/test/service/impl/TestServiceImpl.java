package com.shoestp.test.service.impl;


import com.shoestp.test.dao.TestDao;
import com.shoestp.test.entity.Test;
import com.shoestp.test.vo.TestView;
import com.shoestp.test.vo.mapper.TestMapper;
import com.shoestp.test.service.TestService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * (Test)表服务实现类
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
@Service("TestService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestView getById(Integer id) {
        return TestMapper.modelMapperConfig(true).map(testDao
                .getTest(id), TestView.class);
    }

    /**
     * 多条件分页查询所有数据
     *
     * @param pageable  分页对象
     * @param condition 查询条件
     * @return 对象列表
     */
    @Override
    public Page<TestView> listByPage(String condition, Pageable pageable) {
        Page<Test> page = testDao.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> temp = new ArrayList<>();
            if (condition != null) {
                temp.add(criteriaBuilder.and(
                        criteriaBuilder.like(root.get("condition"), "%" + condition + "%")));
            }
            return criteriaBuilder.and(temp.toArray(new Predicate[temp.size()]));
        }, pageable);
        List<TestView> list = TestMapper.modelMapperConfig(true)
                .map(page.getContent(), new TypeToken<List<TestView>>() {
                }.getType());
        return new PageImpl<>(list, pageable, page.getTotalElements());
    }

    /**
     * 新增数据/编辑数据
     *
     * @param testView 实例对象
     */
    @Override
    public void save(TestView testView) {
        testDao.save(TestMapper.modelMapperConfig(false).map(testView, Test.class));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
        testDao.deleteById(id);
    }
}
