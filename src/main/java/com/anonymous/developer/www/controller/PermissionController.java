package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 权限控制器
 * @Datetime: 2019/9/21 9:07 下午
 */
@RestController
public class PermissionController extends BaseController{
    @Autowired
    private PermissionService permissionService;

    /*@ApiOperation(value = "获取当前账户的菜单权限")
    @GetMapping(value = "/Api/Permission/getMenus")
    public CommonResult getdMenus(){
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated() || subject.getSession().getAttribute("AccountName")==null){
            return CommonResult.fail(false);
        }
        return CommonResult.success(permissionService.findByPermissionType(EnumPermissionType.MENU));
    }*/
}
