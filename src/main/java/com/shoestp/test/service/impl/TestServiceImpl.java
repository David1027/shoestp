package com.shoestp.test.service.impl;


import com.shoestp.test.repository.TestRepository;
import com.shoestp.test.entity.Test;
import com.shoestp.test.vo.TestView;
import com.shoestp.test.mapper.TestMapper;
import com.shoestp.test.service.TestService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import com.shoestp.common.pojo.PageView;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.shoestp.common.exception.WebMessageException;
import com.shoestp.common.enums.ResultEnum;

/**
 * (Test)表服务实现类
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
@Service("TestService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    private TestMapper testMapper = new TestMapper();
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestView getById(Integer id) {
        if (null == testRepository.getTest(id)) {
            throw new WebMessageException(ResultEnum.FAILED.getCode(), "这个[ " + id + " ]id对应的查询结果不存在");
        }
        return testMapper.modelMapperConfig(true).map(testRepository.getTest(id), TestView.class);
    }

    /**
     * 多条件分页查询所有数据
     *
     * @param pageable 分页对象
     * @param condition 查询条件
     * @return 对象列表
     */
    @Override
    public PageView<TestView> listByPage(String condition, Pageable pageable) {
        Page<Test> page = testRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> temp = new ArrayList<>();
            if (condition != null) {
                temp.add(criteriaBuilder.and(
                        criteriaBuilder.like(root.get("id"), "%" + condition + "%")));
            }
            return criteriaBuilder.and(temp.toArray(new Predicate[0]));
        }, pageable);
        return PageView.of(page.getTotalElements(),testMapper.modelMapperConfig(true)
        .map(page.getContent(), new TypeToken<List<TestView>>() {
        }.getType()));
    }

    /**
     * 新增数据/编辑数据
     *
     * @param testView 实例对象
     */
    @Override
    public void save(TestView testView) {
        testRepository.save(testMapper.modelMapperConfig(false).map(testView,Test.class));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(Integer id) {
        testRepository.deleteById(id);
    }
}