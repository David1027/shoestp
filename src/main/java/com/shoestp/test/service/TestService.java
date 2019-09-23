package com.shoestp.test.service;


import com.shoestp.test.vo.TestView;
import com.shoestp.common.pojo.PageView;
import org.springframework.data.domain.Pageable;

/**
 * (Test)表服务接口
 *
 * @author lingjian
 * @since 2019-09-23 14:03:02
 */
public interface TestService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestView getById(Integer id);

    /**
     * 多条件分页查询所有数据
     *
     * @param pageable 分页对象
     * @param condition 查询条件
     * @return 对象列表
     */
    PageView<TestView> listByPage(String condition, Pageable pageable);

    /**
     * 新增数据/编辑数据
     *
     * @param testView 实例对象
     */
    void save(TestView testView);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Integer id);
}