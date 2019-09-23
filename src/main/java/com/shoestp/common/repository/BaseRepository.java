package com.shoestp.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * (Test)表数据库访问层
 *
 * @author lingjian
 * @since 2019-08-22 14:34:00
 */
@NoRepositoryBean
public interface BaseRepository<T, TD>
    extends JpaRepository<T, TD>, JpaSpecificationExecutor<T>, PagingAndSortingRepository<T, TD> {}
