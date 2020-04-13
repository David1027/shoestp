package com.shoestp.car.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * @description: 车基类
 * @author: lingjian
 * @create: 2020/4/13 9:56
 */
@Entity
@Table(name = "car")
@Data
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 名称 */
  private String name;

  /** 车座位数 */
  private Integer numberOfSeats;

  /** 车类型 */
  @ManyToOne
  @JoinColumn(name = "car_type", insertable = false, updatable = false)
  private CarType carType;
}
