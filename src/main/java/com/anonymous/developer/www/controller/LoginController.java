package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.common.CommonResult;
import com.anonymous.developer.www.parameter.LoginRequestParam;
import com.anonymous.developer.www.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 登录控制器
 * @Datetime: 2019/10/3 9:06 下午
 */
@Api(tags = "登录接口")
@RestController
public class LoginController extends BaseController{
    @Autowired
    private AccountService accountService;
    @RequiresGuest
    @ApiOperation(value = "登录账户")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody @Valid LoginRequestParam loginRequestParam){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginRequestParam.getAccountName(), loginRequestParam.getAccountPassword());
        if(loginRequestParam.getRememberMe())
            token.setRememberMe(true);
        try {
            subject.login(token);
        }catch (Exception exception){
            return CommonResult.createCommonResult("账户名或密码无效",false);
        }
        //如果登录验证成功
        if(subject.isAuthenticated()) {
            Session session = subject.getSession();
            //将用户名存入Session
            session.setAttribute("AccountName", loginRequestParam.getAccountName());
            //更新登录时间
            accountService.updateLoginDatetimeByAccountName(loginRequestParam.getAccountName());
            return CommonResult.success(true);
        }
        return CommonResult.fail(false);
    }

    @RequiresGuest
    @ApiOperation(value = "注销当前账户")
    @GetMapping(value = "/logout")
    public CommonResult logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.getSession().getAttribute("AccountName")!=null){
            if(subject.isAuthenticated()){
                subject.logout();
            }
        }
        return CommonResult.success(true);
    }

    @RequiresRoles("Administrator")
    @ApiOperation("超级管理员请求测试")
    @GetMapping(value = "/Api/administrator")
    public CommonResult administrator(){
        return CommonResult.success("这是超级管理员才可以请求得到！");
    }

    @RequiresRoles("nobody")
    @ApiOperation("权限测试")
    @GetMapping(value = "/Api/validatePermissionIsWork")
    public CommonResult nobody(){
        return CommonResult.success("没有人可以请求这个地址！如果请求成功！说明权限配置失败！");
    }

    @RequiresGuest
    @ApiOperation(value = "匿名用户请求测试")
    @GetMapping(value = "/anonymous")
    public CommonResult anonymous(){
        return CommonResult.success("请求成功！");
    }

    @RequiresGuest
    @ApiOperation(value = "验证当前账户是否登录")
    @GetMapping(value = "/isAuthentication")
    public CommonResult isAuthentication(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated() && subject.getSession().getAttribute("AccountName")!=null){
            return CommonResult.createCommonResult("当前账户已登录");
        }
        return CommonResult.createCommonResult("当前账户未登录");
    }
}
