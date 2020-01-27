package com.cn.api;

import com.cn.pojo.Advice;
import com.cn.pojo.Result;
import com.cn.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 20:39
 */
@Api(value = "负责用户管理接口")
public interface UserControllerApi {

    @ApiOperation("登录操作")
    public Result login(String username, String password, String remember, HttpServletResponse response);

    @ApiOperation("用户建议")
    public Result advice(Advice advice, HttpServletRequest request);

    @ApiOperation("用户注册")
    public Result register(User user);

    @ApiOperation("获取用户名")
    public Result getUserName(String id);
}
