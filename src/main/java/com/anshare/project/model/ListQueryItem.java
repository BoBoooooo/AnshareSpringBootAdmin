package com.anshare.project.model;

import lombok.Data;
@Data

public class ListQueryItem {


    /**
     * 搜索条件
     */
    private String searchKey;

    private String searchOperator;


    private String searchValue;

}