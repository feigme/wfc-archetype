package ${package}.${rootArtifactId}.adapter.http;

import java.util.Map;

/**
 * @author 飞影
 * @create by 2020-03-21 18:35
 */
public interface HttpAdapter {

    /**
     * post 请求
     *
     * @param url
     * @param params
     * @return
     */
    String doPost(String url, Map<String, String> params);

    /**
     * get 请求
     *
     * @param url
     * @param params
     * @return
     */
    String doGet(String url, Map<String, String> params);
}
