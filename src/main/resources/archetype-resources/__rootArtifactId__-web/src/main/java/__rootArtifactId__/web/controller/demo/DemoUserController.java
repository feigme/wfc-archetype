package ${package}.${rootArtifactId}.web.demo.controller;

import ${package}.${rootArtifactId}.dal.demo.entity.DemoUserDO;
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

/**
 * @author 飞影
 * @create by 2020-03-21 18:35
 */
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
    public Object addUser(HttpServletRequest request, @RequestBody DemoUserDO user) {
        return RestResult.success(demoUserMapper.insert(user));
    }

    @ApiOperation(value = "更新用户信息", notes = "用户-更新用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Object updateUser(@PathVariable("id") Long id, @RequestBody DemoUserDO user) {
        user.setId(id);
        return RestResult.success(demoUserMapper.updateById(user));
    }

    @ApiOperation(value = "删除用户信息", notes = "用户-删除用户信息")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") Long id) {
        return RestResult.success(demoUserMapper.deleteById(id));
    }

}