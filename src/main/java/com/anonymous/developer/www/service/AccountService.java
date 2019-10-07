package com.anonymous.developer.www.service;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.model.Account;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 账户服务类接口
 * @Datetime: 2019/9/15 8:23 下午
 */
public interface AccountService {
    /**
     * 通过账户名称精确查找账户
     * @param accountName
     * @return
     */
    Account findByAccountName(String accountName);

    /**
     * 通过关键字、当前页、页尺寸、查找用户
     * @param keyWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageData getCurrentPageData(String keyWord, int currentPage, int pageSize);

    /**
     * 通过账户名称修改登录时间
     * @param accountName
     * @return
     */
    boolean updateLoginDatetimeByAccountName(String accountName);

    /**
     * 通过账户ID删除账户
     * @param accountId
     * @return
     */
    boolean deleteByAccountId(Integer accountId);
}
