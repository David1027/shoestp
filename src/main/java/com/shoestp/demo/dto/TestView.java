package com.shoestp.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 测试类DTO层
 * @author: lingjian
 * @create: 2019/7/12 15:28
 */
@Data
@ApiModel("测试前端展示类")
public class TestView {
    @ApiModelProperty(value="测试id")
    private Integer id;
    @ApiModelProperty(value="测试名称",example = "zhangsan")
    private String name;
}
