package ${package}.${rootArtifactId}.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.${rootArtifactId}.demo.entity.User;

/**
 * @author 飞影
 * @create by 2019-08-30 10:51
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过xml定义sql查询
     *
     * @param name
     * @return
     */
    User findUserByName(String name);

}
