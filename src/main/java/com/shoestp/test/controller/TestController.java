package com.shoestp.test.controller;


import com.shoestp.test.vo.TestView;
import com.shoestp.test.service.TestService;
import com.shoestp.common.pojo.Result;
import com.shoestp.common.utils.ResultUtil;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * (Test)表控制层
 *
 * @author lingjian
 * @since 2019-07-30 16:28:39
 */
@RestController
@RequestMapping("/test/")
@Api(tags = "TestController相关api")
public class TestController {
    /**
     * 服务对象
     */
    @Autowired
    private TestService testService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getbyid")
    @ApiOperation(value = "通过主键查询单条数据", notes = "可选用id=14查询")
    public Result getById(@RequestParam
                          @ApiParam(name = "id", value = "test实体类id", required = true) Integer id) throws Exception {
        return ResultUtil.success(testService.getById(id));
    }

    /**
     * 多条件分页查询所有数据
     *
     * @param page      分页对象
     * @param size      分页对象
     * @param condition 查询条件
     * @return 所有数据
     */
    @GetMapping("list")
    @ApiOperation("多条件分页查询所有数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "搜索字段", dataType = "String", paramType = "query", defaultValue = "zhangsan"),
            @ApiImplicitParam(name = "page", value = "开始页码", dataType = "int", paramType = "query", required = true,
                    defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "显示条数", dataType = "int", paramType = "query", required = true,
                    defaultValue = "20")
    })
    public Result selectAll(String condition, Integer page, Integer size) {
        return ResultUtil.success(testService.listByPage(condition, PageRequest.of(page, size)));
    }

    /**
     * 新增数据/编辑数据
     *
     * @param testView 实体对象
     * @return 新增结果
     */
    @PostMapping("save")
    @ApiOperation("新增/编辑数据")
    public Result save(@RequestBody TestView testView) {
        testService.save(testView);
        return ResultUtil.success();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping("delete")
    @ApiOperation("删除数据")
    public Result delete(@RequestParam Integer id) {
        testService.deleteById(id);
        return ResultUtil.success();
    }
}
