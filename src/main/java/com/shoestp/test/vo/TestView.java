package com.shoestp.test.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * (Test)表前端展示类
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
@Data
@ApiModel(value = "TestVO", description = "test实体类对应的VO前端展示类")
public class TestView {

  @ApiModelProperty(value = "id", name = "id", dataType = "int", example = "14")
  private Integer id;

  @ApiModelProperty(value = "名称", name = "name", dataType = "String", example = "张三")
  private String name;

  @ApiModelProperty(value = "性别", name = "gender", dataType = "String", example = "男")
  private String gender;
}
