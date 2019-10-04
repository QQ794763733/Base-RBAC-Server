package com.anonymous.developer.www.parameter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: 分页接口参数
 * @Datetime: 2019/10/3 9:01 下午
 */
public class PageRequestParam {
    @NotNull(message = "当前页不能为空")
    private int currentPage;
    @Min(0)
    private int pageSize;
    @NotNull
    private String keyWord;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
