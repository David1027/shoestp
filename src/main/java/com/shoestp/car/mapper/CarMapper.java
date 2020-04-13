package com.shoestp.car.mapper;

import java.util.List;

import com.shoestp.car.entity.Car;
import com.shoestp.car.vo.CarDto;
import com.shoestp.common.pojo.PageView;
import com.shoestp.common.utils.TranslateUtil;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

/**
 * @description: 车实体映射接口
 * @author: lingjian
 * @create: 2020/4/13 10:49
 */

@Mapper(componentModel = "spring",imports = TranslateUtil.class)
public interface CarMapper {

  @Mapping(source = "numberOfSeats", target = "seatCount")
  @Mapping(source = "carType.id", target = "carTypeId")
  @Mapping(
      expression = "java( TranslateUtil.translate(car.getCarType().getName()) )",
      target = "carTypeName")
  @Mapping(source = "carType.type", target = "type")
  CarDto carToCarDto(Car car);

  List<CarDto> carsToCarDtos(List<Car> car);

  default PageView<CarDto> carPagesTocarDtoPages(Page<Car> pages) {
    return new PageView<>(pages.getTotalElements(), carsToCarDtos(pages.getContent()));
  }
}
