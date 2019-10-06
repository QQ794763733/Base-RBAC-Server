package com.anonymous.developer.www.mapper;

import com.anonymous.developer.www.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    Account selectByPrimaryKey(Integer accountId);

    Account selectByAccountName(String accountName);

    List<Account> selectLimit(@Param("keyWord") String keyWord,@Param("startRow") int startRow,@Param("endRow") int endRow);

    int selectCountAll();

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);

    int updateLoginDatetimeByAccountName(String accountName);
}