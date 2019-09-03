package ${package}.${rootArtifactId}.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @ApiOperation(value="应用状态检查", notes="根据url做心跳检查, 看服务是否正常")
    @RequestMapping(value = "ok", method = RequestMethod.GET)
    public String ok() {
        return "ok";
    }

}