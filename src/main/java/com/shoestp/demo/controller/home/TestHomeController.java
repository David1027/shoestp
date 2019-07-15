package com.shoestp.demo.controller.home;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shoestp.demo.dto.TestView;
import com.shoestp.demo.entity.Test;
import com.shoestp.demo.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 测试控制层
 * @author: lingjian
 * @create: 2019/7/12 15:18
 */
@RestController
@RequestMapping("/home/test/")
@Api(tags = "home包下testController相关api")
public class TestHomeController {

    @Autowired
    private TestService testService;

    @ApiOperation("新增测试")
    @PostMapping("insert")
    public void insert(TestView testView) {
        testService.insert(testView);
    }

    @ApiOperation("删除测试")
    @ApiImplicitParam(name = "id", value = "测试类id", paramType = "query",
            defaultValue = "1", example = "2")
    @GetMapping("remove")
    public void remove(@RequestParam Integer id) {
        testService.remove(id);
    }

    @ApiOperation("更新测试")
    @PostMapping("update")
    public void update(@RequestBody TestView testView) {
        testService.update(testView);
    }

    @ApiOperation("获取测试")
    @GetMapping("list")
    public List<Test> list() {
        return testService.list();
    }
}
