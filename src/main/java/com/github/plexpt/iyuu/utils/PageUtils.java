

package com.github.plexpt.iyuu.utils;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * 分页工具类
 *
 * @author ADMIN
 */
@Data
@ToString
public class PageUtils<T> {
    /**
     * 总记录数
     */
    protected int totalCount;
    /**
     * 每页记录数
     */
    protected int pageSize;
    /**
     * 总页数
     */
    protected int totalPage;
    /**
     * 当前页数
     */
    protected int currPage;
    /**
     * 列表数据
     */
    protected List<T> list;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }


}
