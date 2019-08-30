package ${package}.${rootArtifactId}.demo.entity;

import lombok.Data;

/**
 * @author 飞影
 * @create by 2019-08-30 10:50
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
