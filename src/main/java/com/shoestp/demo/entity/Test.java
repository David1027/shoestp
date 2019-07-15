package com.shoestp.demo.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * @description: 测试实体类
 * @author: lingjian
 * @create: 2019/7/12 15:13
 */
@Entity
@Table(name = "test")
@Data
public class Test {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;
}
