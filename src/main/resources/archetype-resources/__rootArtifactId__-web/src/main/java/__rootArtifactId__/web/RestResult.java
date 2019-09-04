package ${package}.${rootArtifactId}.web;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 飞影
 * @create by 2019-09-03 22:24
 */
@Data
public class RestResult<T> implements Serializable {

    private int     code;
    private boolean success;
    private String  message;
    private T       data;
    private int     totalCount;

    public RestResult(){
    }

    public static <T> RestResult newInstance(int code, String message, T data, int totalCount) {
        RestResult result = new RestResult();
        result.code = code;
        result.success = code == 200;
        result.message = message;
        result.data = data;
        result.totalCount = totalCount;
        return result;
    }

    public static <T> RestResult newInstance(int code, String message, T data) {
        return newInstance(code, message, data, 0);
    }

    public static <T> RestResult success() {
        return newInstance(200, "", (Object) null);
    }

    public static <T> RestResult success(T data) {
        return newInstance(200, "", data);
    }

    public static <T> RestResult success(List<T> data, int totalCount) {
        return newInstance(200, "", data, totalCount);
    }

    public static <T> RestResult invalidParams(String message) {
        return newInstance(400, message, (Object) null);
    }

    public static <T> RestResult failure(T data, String message) {
        return newInstance(500, message, data);
    }

    public static <T> RestResult failure(String message) {
        return newInstance(500, message, (Object) null);
    }

}
