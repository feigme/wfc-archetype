package ${package}.${rootArtifactId}.adapter.http.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 飞影
 * @create by 2020-03-21 18:37
 */
@Configuration
public class HttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }

}
