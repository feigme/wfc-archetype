package ${package}.${rootArtifactId}.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 飞影
 * @create by 2019-09-02 21:42
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 标题
     */
    @Value("${swagger.title}")
    private String title;

    /**
     * 基本包
     */
    @Value("${swagger.base.package}")
    private String basePackage;

    /**
     * 描述
     */
    @Value("${swagger.description}")
    private String description;

    /**
     * URL
     */
    @Value("${swagger.url}")
    private String url;

    /**
     * 版本
     */
    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(url)
                .version(version)
                .build();
    }

}