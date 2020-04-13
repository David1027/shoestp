package com.shoestp.car.entity;

import javax.persistence.*;

import com.shoestp.car.enums.OCarType;

import lombok.Data;

/**
 * @description: 车类型基类
 * @author: lingjian
 * @create: 2020/4/13 10:01
 */
@Entity
@Table(name = "car_type")
@Data
public class CarType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** 车类型名称 */
  private String name;

  /** 车类型 */
  @Enumerated(EnumType.STRING)
  private OCarType type;
}
