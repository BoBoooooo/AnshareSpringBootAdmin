package com.anshare.project.core.Util;

import com.anshare.project.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

//用List构建带有层次结构的json数据
//List父子节点构造树形Json
public class TreeUtil {
    //将list集合转成树形结构的list集合
    public static List<MenuModel> listToTree(List<MenuModel> list) {
        //用递归找子。
        List<MenuModel> treeList = new ArrayList<MenuModel>();
        for (MenuModel tree : list) {
            if (tree.getParentid().equals("00000000-0000-0000-0000-000000000000")) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    //寻找子节点
    private static MenuModel findChildren(MenuModel tree, List<MenuModel> list) {
        for (MenuModel node : list) {
            if (node.getParentid().equals(tree.getId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<MenuModel>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
