package com.anshare.project.model;

import lombok.Data;
import java.util.List;
@Data

public class ListQuery {

    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 页码
     */
    private int pageIndex;

    /**
     * 搜索条件
     */
    private List<ListQueryItem> searchArr;


}