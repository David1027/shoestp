package com.shoestp.test.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * (Test)表实体类
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
@Entity
@Table(name = "test")
@Data
public class Test {

    @Id
    @GeneratedValue
    /**id */
    @Column(name = "id")
    private Integer id;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;
}
