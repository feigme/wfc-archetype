package ${package}.${rootArtifactId}.dal.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 飞影
 * @create by 2019-08-30 11:00
 */
@Configuration
@MapperScan("${package}.${rootArtifactId}.dal.*.mapper")
public class MybatisConfig {

    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
