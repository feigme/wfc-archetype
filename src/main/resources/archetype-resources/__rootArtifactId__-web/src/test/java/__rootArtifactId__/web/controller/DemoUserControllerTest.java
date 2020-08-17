package ${package}.${rootArtifactId}.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import ${package}.${rootArtifactId}.BootApplication;
import ${package}.${rootArtifactId}.dal.demo.entity.DemoUserDO;
import ${package}.${rootArtifactId}.web.RestResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author 飞影
 * @create by 2019-09-03 17:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@AutoConfigureMockMvc
public class DemoUserControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     * get
     */
    @Test
    public void testGet() throws Exception {
        // 准备请求url 不用带ip、端口、项目名称等 直接写接口的映射地址就可以了
        String url = "/user/1";

        /*
         * 构建request 发送请求GET请求 MockMvcRequestBuilders 中有很多 请求方式。像get、post、put、delete等等
         */
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        // 拿到请求返回码
        int status = response.getStatus();
        // 拿到结果
        String contentAsString = response.getContentAsString();

        System.out.printf(contentAsString);
        Assert.assertEquals(200, status);
        DemoUserDO user = JSON.parseObject(contentAsString, new TypeReference<RestResult<DemoUserDO>>() {
        }).getData();
        Assert.assertEquals("Jone", user.getName());
    }

    /**
     * post
     */
    @Test
    public void testPost() throws Exception {
        // uri
        String uri = "/user";

        DemoUserDO user = new DemoUserDO();
        user.setName("test-a");
        user.setAge(18);
        user.setEmail("testsa@wfc.com");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user))
                .accept(MediaType.APPLICATION_JSON)) // 断言返回结果是json
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        // 拿到请求返回码
        int status = response.getStatus();
        // 拿到结果
        String contentAsString = response.getContentAsString();

        System.out.printf(contentAsString);
        Assert.assertEquals(200, status);
        Integer n = JSON.parseObject(contentAsString, new TypeReference<RestResult<Integer>>() {
        }).getData();
        Assert.assertEquals(Integer.valueOf(1), n);
    }

    /**
     * put
     */
    @Test
    public void testPut() throws Exception {
        // uri
        String uri = "/user/2";

        DemoUserDO user = new DemoUserDO();
        user.setName("test-a");
        user.setAge(18);
        user.setEmail("testsa@wfc.com");

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user))
                .accept(MediaType.APPLICATION_JSON)) // 断言返回结果是json
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        // 拿到请求返回码
        int status = response.getStatus();
        // 拿到结果
        String contentAsString = response.getContentAsString();

        System.out.printf(contentAsString);
        Assert.assertEquals(200, status);
        Integer n = JSON.parseObject(contentAsString, new TypeReference<RestResult<Integer>>() {
        }).getData();
        Assert.assertEquals(Integer.valueOf(1), n);
    }

    /**
     * delete
     */
    @Test
    public void testDelete() throws Exception {
        // uri
        String uri = "/user/1";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        // 拿到请求返回码
        int status = response.getStatus();
        // 拿到结果
        String contentAsString = response.getContentAsString();

        System.out.printf(contentAsString);
        Assert.assertEquals(200, status);
        Integer n = JSON.parseObject(contentAsString, new TypeReference<RestResult<Integer>>() {
        }).getData();
        Assert.assertEquals(Integer.valueOf(1), n);
    }

    /**
     * get
     */
    @Test
    public void testException() throws Exception {
        // 准备请求url 不用带ip、端口、项目名称等 直接写接口的映射地址就可以了
        String url = "/user/1xx";

        /*
         * 构建request 发送请求GET请求 MockMvcRequestBuilders 中有很多 请求方式。像get、post、put、delete等等
         */
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON))
                .andReturn();// 得到返回结果

        MockHttpServletResponse response = mvcResult.getResponse();
        // 拿到请求返回码
        int status = response.getStatus();
        // 拿到结果
        String contentAsString = response.getContentAsString();

        System.out.printf(contentAsString);
        Assert.assertEquals(200, status);
        int code = JSON.parseObject(contentAsString, new TypeReference<RestResult<String>>() {
        }).getCode();
        Assert.assertEquals(500, code);
    }

}
