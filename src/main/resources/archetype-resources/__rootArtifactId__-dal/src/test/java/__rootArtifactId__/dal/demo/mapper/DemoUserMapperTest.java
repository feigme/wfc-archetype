package ${package}.${rootArtifactId}.dal.demo.mapper;

import ${package}.${rootArtifactId}.dal.config.MybatisConfig;
import ${package}.${rootArtifactId}.dal.config.DataSourceConfig;
import ${package}.${rootArtifactId}.dal.demo.entity.DemoUser;
import ${package}.${rootArtifactId}.dal.demo.mapper.DemoUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 飞影
 * @create by 2019-08-30 10:33
 */
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = { MybatisConfig.class, DataSourceConfig.class })
@Transactional
public class DemoUserMapperTest {

    @Resource
    private DemoUserMapper demoUserMapper;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<DemoUser> userList = demoUserMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        DemoUser user = new DemoUser();
        user.setName("test-a");
        user.setAge(18);
        user.setEmail("testsa@wfc.com");
        int n = demoUserMapper.insert(user);
        Assert.assertEquals(1, n);
        Assert.assertNotNull(user.getId());
        System.out.println("id_worker: " + user.getId());
        Assert.assertEquals(19, user.getId().toString().length());
    }

    @Test
    public void testXmlMapper() {
        DemoUser user = demoUserMapper.findUserByName("Tom");
        Assert.assertNotNull(user);
        Assert.assertEquals(Long.valueOf(3), user.getId());
    }
}
