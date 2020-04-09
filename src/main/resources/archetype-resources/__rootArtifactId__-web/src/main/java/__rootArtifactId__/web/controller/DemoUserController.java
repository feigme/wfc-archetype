package ${package}.${rootArtifactId}.web.controller;

import ${package}.${rootArtifactId}.dal.demo.entity.DemoUser;
import ${package}.${rootArtifactId}.dal.demo.mapper.DemoUserMapper;
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
public class DemoUserController {

    @Autowired
    private DemoUserMapper demoUserMapper;

    @ApiOperation(value = "获取用户信息", notes = "根据id获取用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable("id") Long id) {
        return RestResult.success(demoUserMapper.selectById(id));
    }

    @ApiOperation(value = "新增用户信息", notes = "用户-新增用户信息")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request, @RequestBody DemoUser user) {
        return RestResult.success(demoUserMapper.insert(user));
    }

    @ApiOperation(value = "更新用户信息", notes = "用户-更新用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Object updateUser(@PathVariable("id") Long id, @RequestBody DemoUser user) {
        user.setId(id);
        return RestResult.success(demoUserMapper.updateById(user));
    }

    @ApiOperation(value = "删除用户信息", notes = "用户-删除用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") Long id) {
        return RestResult.success(demoUserMapper.deleteById(id));
    }

}