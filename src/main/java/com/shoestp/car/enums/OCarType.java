package com.shoestp.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 车类型
 * @author: lingjian
 * @create: 2020/4/13 10:05
 */
@Getter
@AllArgsConstructor
public enum OCarType {

  /** 小型车 */
  SMALL("小型车"),
  /** 中型车 */
  MIDSIZE("小型车"),
  /** 大型车 */
  LARGE("小型车");

  private String description;
}
