package ${package}.${rootArtifactId}.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package}.${rootArtifactId}.dal.entity.DemoUserDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author 飞影
 * @create by 2019-08-30 10:51
 */
public interface DemoUserMapper extends BaseMapper<DemoUserDO> {

    /**
     * 通过xml定义sql查询
     *
     * @param name
     * @return
     */
    DemoUserDO getUserByName(String name);

    IPage<DemoUserDO> selectLike(IPage<DemoUserDO> page, @Param("name") String name);

}