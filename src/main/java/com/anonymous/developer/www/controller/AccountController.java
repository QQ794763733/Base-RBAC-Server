package com.anonymous.developer.www.controller;

import com.anonymous.developer.www.common.CommonResult;
import com.anonymous.developer.www.parameter.PageRequestParam;
import com.anonymous.developer.www.service.AccountService;
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
 * @Description: 账户控制器
 * @Datetime: 2019/9/16 9:16 下午
 */
@Api(tags = "账户接口")
@RestController
@RequestMapping(value = "/api/account")
public class AccountController extends BaseController{
    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "通过账户名精确查找账户")
    @ApiParam(name = "accountName",value = "用户名",defaultValue = "xiaoyu",required = true)
    @GetMapping(value = "/findByAccountName")
    public CommonResult findByAccountName(@RequestParam(value = "accountName") String accountName){
        if(accountName.isEmpty()){
            return CommonResult.fail("用户名为空！");
        }
        return CommonResult.success(accountService.findByAccountName(accountName));
    }

    @ApiOperation(value = "得到当前分页的账户数据")
    @PostMapping("/getCurrentPageData")
    public CommonResult getCurrentPageData(@RequestBody @Valid PageRequestParam pageRequestParam){
        return CommonResult.success(accountService.getCurrentPageData(pageRequestParam.getKeyWord(),pageRequestParam.getCurrentPage(),pageRequestParam.getPageSize()));
    }
}