package ${package}.${rootArtifactId}.adapter.http.impl;

import ${package}.${rootArtifactId}.adapter.http.HttpAdapter;
import ${package}.${rootArtifactId}.adapter.http.config.HttpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 飞影
 * @create by 2020-03-21 23:16
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = {OkHttpAdapterImpl.class, HttpConfig.class})
public class OkHttpAdapterImplTest {

    @Resource(name = "httpAdapter")
    private HttpAdapter httpAdapter;

    @Test
    public void testDoPost() {
        String rsp = httpAdapter.doPost("http://www.baidu.com", null);
        System.out.println(rsp);
    }

    @Test
    public void testDoGet() {
        String rsp = httpAdapter.doGet("http://www.baidu.com", null);
        System.out.println(rsp);
    }
}
