package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.common.CommonResult;
import com.anonymous.developer.www.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 菜单控制器
 * @Datetime: 2019/9/24 5:07 下午
 */
@Api(tags = "后台菜单接口")
@RestController
@RequestMapping(value = "/api/menu")
public class MenuController extends BaseController{
    @Autowired
    private MenuService menuService;

    @RequiresAuthentication
    @ApiOperation(value = "获取所有菜单")
    @GetMapping("/getAll")
    public CommonResult getAllMenu(){
        return CommonResult.success(menuService.getAll());
    }
}
