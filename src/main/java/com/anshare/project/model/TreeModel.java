package com.anshare.project.model;

import lombok.Data;
import java.util.List;

@Data
public class TreeModel {
    private String id;
    private String parentId;
    private String nodeName;
    private int sortCode;
private  List<TreeModel> children;


public TreeModel(String id , String partentId, String nodeName, int sortCode){

    this.id = id;
    this.parentId = partentId;
    this.nodeName = nodeName;
    this.sortCode = sortCode;
}


}