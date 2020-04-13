package com.shoestp.car.controller;

import java.util.List;

import com.shoestp.car.entity.Car;
import com.shoestp.car.mapper.CarMapper;
import com.shoestp.car.service.CarService;
import com.shoestp.car.vo.CarDto;
import com.shoestp.common.pojo.PageView;
import com.shoestp.common.pojo.Result;
import com.shoestp.common.utils.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * (Car)表控制层
 *
 * @author lingjian
 * @since 2020-04-13 10:23:18
 */
@RestController
@RequestMapping("/car/")
@Api(tags = "CarController相关api")
public class CarController {
  /** 服务对象 */
  @Autowired private CarService carService;
  @Autowired private CarMapper carMapper;

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("getbyid")
  @ApiOperation("通过主键查询单条数据")
  public Result getById(@RequestParam Long id) {
    CarDto carDto = carMapper.carToCarDto(carService.getById(id));
    return ResultUtil.success(carDto);
  }

  /**
   * 多条件分页查询所有数据
   *
   * @param page 分页对象
   * @param size 分页对象
   * @return 所有数据
   */
  @GetMapping("list")
  @ApiOperation("多条件分页查询所有数据")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "page", value = "开始页码", required = true, defaultValue = "0"),
    @ApiImplicitParam(name = "size", value = "显示条数", required = true, defaultValue = "20")
  })
  public Result selectAll(Integer page, Integer size) {
    Page<Car> cars = carService.listByPage(PageRequest.of(page, size));
    PageView<CarDto> carDtoPages = carMapper.carPagesTocarDtoPages(cars);
    return ResultUtil.success(carDtoPages);
  }

  /**
   * 新增数据/编辑数据
   *
   * @param carDto 实体对象
   * @return 新增结果
   */
  @PostMapping("save")
  @ApiOperation("新增/编辑数据")
  public Result save(@RequestBody Car carDto) {
    carService.save(carDto);
    return ResultUtil.success();
  }

  /**
   * 删除数据
   *
   * @param id 主键
   * @return 删除结果
   */
  @DeleteMapping
  @ApiOperation("删除数据")
  public Result delete(@RequestParam Long id) {
    carService.deleteById(id);
    return ResultUtil.success();
  }
}
