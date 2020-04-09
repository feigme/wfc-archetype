package ${package}.${rootArtifactId}.dal.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ${package}.${rootArtifactId}.dal.demo.entity.DemoUser;

/**
 * @author 飞影
 * @create by 2019-08-30 10:51
 */
public interface DemoUserMapper extends BaseMapper<DemoUser> {

    /**
     * 通过xml定义sql查询
     *
     * @param name
     * @return
     */
    DemoUser findUserByName(String name);

}
