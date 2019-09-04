package ${package}.${rootArtifactId}.web.controller;

import ${package}.${rootArtifactId}.demo.entity.User;
import ${package}.${rootArtifactId}.demo.mapper.UserMapper;
import ${package}.${rootArtifactId}.web.RestResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable("id") Long id) {
        return RestResult.success(userMapper.selectById(id));
    }

    @ApiOperation(value = "新增用户信息", notes = "用户-新增用户信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request, @RequestBody User user) {
        return RestResult.success(userMapper.insert(user));
    }

    @ApiOperation(value = "更新用户信息", notes = "用户-更新用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Object updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return RestResult.success(userMapper.updateById(user));
    }

    @ApiOperation(value = "删除用户信息", notes = "用户-删除用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") Long id) {
        return RestResult.success(userMapper.deleteById(id));
    }

}