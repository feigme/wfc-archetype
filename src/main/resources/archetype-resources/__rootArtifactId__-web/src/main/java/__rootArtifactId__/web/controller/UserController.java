package ${package}.${rootArtifactId}.web.controller;

import ${package}.${rootArtifactId}.demo.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Long id) {
        return "ok";
    }

    @ApiOperation(value = "新增用户信息", notes = "用户-新增用户信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addUser(User user) {
        return "ok";
    }

    @ApiOperation(value = "更新用户信息", notes = "用户-更新用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") Long id, User user) {
        return "ok";
    }

    @ApiOperation(value = "删除用户信息", notes = "用户-删除用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Long id) {
        return "ok";
    }

}