package com.shoestp.test.vo.mapper;


import com.shoestp.test.entity.Test;
import com.shoestp.test.vo.TestView;
import org.modelmapper.ModelMapper;

/**
 * (Test)的DTO和DO转换类
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
public class TestMapper {

    private TestMapper() {}
    
    private static ModelMapper modelMapper = null;
    
    /**
     * DO转为DTO
     */
    private static void typeMapperDOToDTO() {
        modelMapper.createTypeMap(Test.class, TestView.class).addMappings(mapper ->
                mapper.map(Test::getId, TestView::setId));
    }

    /**
     * DTO转为DO
     */
    private static void typeMapperDTOToDO() {
        modelMapper.createTypeMap(TestView.class, Test.class).addMappings(mapper ->
                mapper.map(TestView::getId, Test::setId));
    }

    /**
     * DO与DTO之间的转化方法
     *
     * @param flag 布尔值 true：DO->DTO，false：DTO->DO
     * @return ModelMapper对象
     */
    public static ModelMapper modelMapperConfig(Boolean flag) {
        modelMapper = new ModelMapper();
        if (flag) {
            typeMapperDOToDTO();
        } else {
            typeMapperDTOToDO();
        }
        return modelMapper;
    }
}