package ${package}.${rootArtifactId};

import ${package}.${rootArtifactId}.config.MybatisConfig;
import ${package}.${rootArtifactId}.demo.entity.User;
import ${package}.${rootArtifactId}.demo.mapper.UserMapper;
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
@SpringBootTest(classes = MybatisConfig.class)
@Transactional
public class MybatisPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println("----- selectAll method test ------");
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("test-a");
        user.setAge(18);
        user.setEmail("testsa@wfc.com");
        int n = userMapper.insert(user);
        Assert.assertEquals(1, n);
        Assert.assertNotNull(user.getId());
        System.out.println("id_worker: " + user.getId());
        Assert.assertEquals(19, user.getId().toString().length());
    }
}
