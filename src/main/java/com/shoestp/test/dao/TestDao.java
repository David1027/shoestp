package com.shoestp.test.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.shoestp.test.entity.Test;

/**
 * (Test)表数据库访问层
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
public interface TestDao extends JpaRepository<Test,Integer>,JpaSpecificationExecutor<Test>, PagingAndSortingRepository<Test,Integer> {
    /**
     * 通过id查询Test单个对象
     * @param id id
     * @return Test实体类
     */
    Test getTest(Integer id);
}