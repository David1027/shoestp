package com.shoestp.car.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Car)表前端展示类
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
@Data
public class CarDto {

  /** 车主键 */
  private Long id;
  /** 车名称 */
  private String name;
  /** 车座位数 */
  private Integer seatCount;
  /** 车类型主键 */
  private Long carTypeId;
  /** 车类型名称 */
  private String carTypeName;
  /** 车类型 */
  private String type;
}
