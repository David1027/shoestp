package com.shoestp.test;



import com.shoestp.test.vo.TestView;
import com.shoestp.common.BaseTest;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * (Test)测试类
 *
 * @author lingjian
 * @since 2019-07-31 11:31:00
 */
public class TestTest extends BaseTest {

    /**
     * 新增测试
     *
     * @throws Exception 异常
     */
    @Test
    public void saveTest() throws Exception {
        TestView testView = new TestView();
        testView.setName("测试一号");
        testView.setGender("男");
        String uri = "/test/save";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSON.toJSONString(testView))
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn();
        printResult(mvcResult);
    }

    /**
     * 更新测试
     *
     * @throws Exception 异常
     */
    @Test
    public void updateTest() throws Exception {
        TestView testView = new TestView();
        testView.setId(25);
        testView.setName("测试一号");
        testView.setGender("女");
        String uri = "/test/save";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSON.toJSONString(testView))
                        .accept(MediaType.APPLICATION_JSON))
                        .andReturn();
        printResult(mvcResult);
    }

    /**
     * 根据id获取单对象测试
     *
     * @throws Exception 异常
     */
    @Test
    public void getByIdTest() throws Exception {
        String uri = "/test/getbyid?id=14";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .accept(MediaType.APPLICATION_JSON)).andReturn();
        printResult(mvcResult);
    }

    /**
     * 分页获取对象列表
     *
     * @throws Exception 异常
     */
    @Test
    public void selectAllTest() throws Exception {
        String uri = "/test/list?page=0&size=20";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        printResult(mvcResult);
    }

    /**
     * 删除测试
     *
     * @throws Exception 异常
     */
    @Test
    public void deleteTest() throws Exception {
        String uri = "/test/delete?id=25";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.delete(uri)
                        .accept(MediaType.APPLICATION_JSON)).andReturn();
        printResult(mvcResult);
    }

}
