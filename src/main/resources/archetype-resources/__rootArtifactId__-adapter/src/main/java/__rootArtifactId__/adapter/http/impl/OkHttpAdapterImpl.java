package ${package}.${rootArtifactId}.adapter.http.impl;

import ${package}.${rootArtifactId}.adapter.http.HttpAdapter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 飞影
 * @create by 2020-03-21 18:36
 */
@Slf4j
@Service("httpAdapter")
public class OkHttpAdapterImpl implements HttpAdapter {

    @Autowired
    private OkHttpClient okHttpClient;

    @Override
    public String doPost(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();

        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        log.info("post request, url: {}", url);

        return execute(request);
    }

    @Override
    public String doGet(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(url);
        if (params != null && params.keySet().size() > 0) {
            boolean firstFlag = true;
            for (String key : params.keySet()) {
                if (firstFlag) {
                    sb.append("?").append(key).append("=").append(params.get(key));
                    firstFlag = false;
                } else {
                    sb.append("&").append(key).append("=").append(params.get(key));
                }
            }
        }

        Request.Builder builder = new Request.Builder();
        // TODO header

        Request request = builder.url(sb.toString()).build();
        log.info("get request, url: {}", sb.toString());
        return execute(request);
    }

    private String execute(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            log.error("okHttp has error", e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }
}
