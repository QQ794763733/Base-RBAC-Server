package com.anonymous.developer.www.serviceimpl;

import com.anonymous.developer.www.dto.PageData;
import com.anonymous.developer.www.mapper.AccountMapper;
import com.anonymous.developer.www.model.Account;
import com.anonymous.developer.www.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 账户服务实现类
 * @Datetime: 2019/9/16 8:10 下午
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByAccountName(String accountName) {
        if(accountName!=null && !accountName.isEmpty()) return accountMapper.selectByAccountName(accountName);
        return null;
    }

    @Override
    public PageData getCurrentPageData(String keyWord, int currentPage, int pageSize) {
        int startRow = (currentPage-1)*pageSize;
        int endRow = startRow + pageSize;
        PageData pageData = new PageData();
        pageData.setTotal(accountMapper.selectCountAll());
        pageData.setPageSize(pageSize);
        pageData.setData(accountMapper.selectLimit(keyWord,startRow,endRow));
        return pageData;
    }

    @Override
    public boolean updateLoginDatetimeByAccountName(String accountName) {
        return accountMapper.updateLoginDatetimeByAccountName(accountName)>0;
    }

    @Override
    public boolean deleteByAccountId(Integer accountId) {
        return accountMapper.deleteByPrimaryKey(accountId)>0;
    }
}