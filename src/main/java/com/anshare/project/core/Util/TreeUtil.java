package com.anshare.project.core.Util;

import com.anshare.project.model.other.TreeModel;

import java.util.ArrayList;
import java.util.List;

//用List构建带有层次结构的json数据
//List父子节点构造树形Json
public class TreeUtil {
    //将list集合转成树形结构的list集合
    public static List<TreeModel> listToTree(List<TreeModel> list) {
        //用递归找子。
        List<TreeModel> treeList = new ArrayList<TreeModel>();

        for (TreeModel tree : list) {
            if (tree.getParentId().equals("00000000-0000-0000-0000-000000000000")) {
                treeList.add(findChildren(tree, list));
            }
        }


        return treeList;
    }

    //寻找子节点
    private static TreeModel findChildren(TreeModel tree, List<TreeModel> list) {
        for (TreeModel node : list) {
            if (node.getParentId().equals(tree.getId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<TreeModel>());
                }
                tree.getChildren().add(findChildren(node, list));
            }
        }
        return tree;
    }

}
