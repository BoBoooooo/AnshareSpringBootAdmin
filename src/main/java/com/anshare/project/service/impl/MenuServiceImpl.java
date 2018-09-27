package com.anshare.project.service.impl;

import com.anshare.project.dao.MenuMapper;
import com.anshare.project.model.Menu;
import com.anshare.project.model.MenuModel;
import com.anshare.project.service.MenuService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.anshare.project.core.TreeUtil;
import java.util.ArrayList;
import java.util.List;
import com.anshare.project.model.Menu;
import com.anshare.project.model.Meta;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/09/27.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;




    //查询所有菜单列表
    public List<MenuModel> list() {

        List<Menu> json_ = menuMapper.selectAll();

        //定义list集合,存储从数据库查询出的所有记录
        List<MenuModel> menuList = new ArrayList<MenuModel>();

        // String id, String pid, String path, String redirect, String name, String component, Boolean alwaysShow, String menu
        //遍历集合
        for (Menu json : json_) {
            //手动封装Menu实体类对象
            MenuModel menu = new MenuModel(
                    json.getId(),
                    json.getParentid(),
                    json.getPath(),
                    json.getRedirect(),
                    json.getName(),
                    json.getComponent(),
                    json.getIcon(),
                    json.getTitle(),
                    new Meta(json.getTitle())
            );


            //添加每个实体类对象到list集合
            menuList.add(menu);
        }

        //调用TreeTest工具类方法生成树形结构的List集合
        List<MenuModel> treeList = TreeUtil.listToTree(menuList);

        //使用fastjson对树形list件序列化转成json字符串,过滤掉属性值为null的属性
       // String message = JSON.toJSONString(treeList, SerializerFeature.PrettyFormat);

        //重新将json字符串转成jsonObject对象,返回给前端
        return treeList;
    }


}
