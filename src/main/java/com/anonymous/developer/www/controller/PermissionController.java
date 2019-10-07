package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.common.CommonResult;
import com.anonymous.developer.www.parameter.PageRequestParam;
import com.anonymous.developer.www.service.PermissionService;
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
 * @Description: 权限控制器
 * @Datetime: 2019/9/21 9:07 下午
 */
@Api(tags = "权限接口")
@RestController
@RequestMapping(value = "/api/permission")
public class PermissionController extends BaseController{
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "得到当前分页的权限数据")
    @PostMapping("/getCurrentPageData")
    public CommonResult getCurrentPageData(@RequestBody @Valid PageRequestParam pageRequestParam){
        return CommonResult.success(permissionService.getCurrentPageData(pageRequestParam.getKeyWord(),pageRequestParam.getCurrentPage(),pageRequestParam.getPageSize()));
    }

    @ApiOperation(value = "通过权限ID删除权限")
    @ApiParam(name = "permissionId",value = "权限ID",defaultValue = "1",required = true)
    @DeleteMapping("/deleteByPermissionId")
    public CommonResult deleteByAccountId(@RequestParam(value = "permissionId") Integer permissionId){
        if(permissionService.deleteByPermissionId(permissionId)){
            return CommonResult.success(true);
        }
        return CommonResult.fail(false);
    }
}