package com.ztf.back.util;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * ClassName:PageInfoResult
 * Package:IntelliJ IDEA
 * Description:
 *
 * @Author ztf
 * @Create 2025/5/29-13:42
 * @Version 1.0
 */
@Data
public class PageInfoResult<T> {
    private List<T> list;
    private long total;
    private int pageNum;
    private int pageSize;


    public PageInfoResult(PageInfo<T> pageInfo) {
        this.list = pageInfo.getList();
        this.total = pageInfo.getTotal();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
    }
}
