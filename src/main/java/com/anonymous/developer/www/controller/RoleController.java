package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.common.CommonResult;
import com.anonymous.developer.www.model.Role;
import com.anonymous.developer.www.parameter.PageRequestParam;
import com.anonymous.developer.www.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 角色控制器
 * @Datetime: 2019/9/21 9:07 下午
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping(value = "/api/role")
public class RoleController extends BaseController{
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "得到当前分页的角色数据")
    @GetMapping("/getCurrentPageData")
    public CommonResult getCurrentPageData(@Valid PageRequestParam pageRequestParam){
        return CommonResult.success(roleService.getCurrentPageData(pageRequestParam.getKeyWord(),pageRequestParam.getCurrentPage(),pageRequestParam.getPageSize()));
    }

    @ApiOperation(value = "通过角色ID删除角色")
    @ApiParam(name = "roleId",value = "角色ID",defaultValue = "1",required = true)
    @DeleteMapping("/deleteByRoleId")
    public CommonResult deleteByRoleId(@RequestParam(value = "roleId") Integer roleId){
        if(roleService.deleteByRoleId(roleId)){
            return CommonResult.success(true);
        }
        return CommonResult.fail(false);
    }

    @ApiOperation(value = "增加角色")
    @PostMapping("/addRole")
    public CommonResult addRole(@RequestBody Role role){
        return CommonResult.success(roleService.addRole(role));
    }

    @ApiOperation(value = "更新角色")
    @PutMapping("/updateByRoleId")
    public CommonResult updateByRoleId(Role role){
        return CommonResult.success(roleService.updateByRoleId(role));
    }
}