package ${package}.${rootArtifactId}.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 飞影
 * @create by 2019-08-30 11:00
 */
@Configuration
@MapperScan("${package}.${rootArtifactId}.*.mapper")
public class MybatisConfig {
}
