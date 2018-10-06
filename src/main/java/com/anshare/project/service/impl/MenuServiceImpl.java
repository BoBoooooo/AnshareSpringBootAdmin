package com.anshare.project.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.AbstractService;
import com.anshare.project.core.Util.TreeUtil;
import com.anshare.project.dao.MenuMapper;
import com.anshare.project.model.Menu;
import com.anshare.project.model.MenuModel;
import com.anshare.project.model.Meta;
import com.anshare.project.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anshare on 2018/09/27.
 */
@Service
@Transactional
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;




    //查询所有菜单列表
    public List<MenuModel> GetMenuTree() {

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
//        String message = JSON.toJSONString(treeList, SerializerFeature.PrettyFormat);
//        List<MenuModel> treelist_ = JSON.parseArray(message,MenuModel.class);
        //重新将json字符串转成jsonObject对象,返回给前端
        return treeList;
    }


    //查询某个角色所拥有的菜单


    public List<MenuModel> GetMenuTreeByRoleID(String RoleID) {

        List<Menu> json_ = menuMapper.GetMenuTreeByRoleID(RoleID);

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
        JSONObject jsonobj = new JSONObject();
        treeList = (List<MenuModel>)JSON.toJSON(treeList);



        //使用fastjson对树形list件序列化转成json字符串,过滤掉属性值为null的属性
      //  String message = JSON.toJSONString(treeList, SerializerFeature.PrettyFormat);
       // List<MenuModel> treelist_ = JSON.parseArray(message,MenuModel.class);
        //重新将json字符串转成jsonObject对象,返回给前端
        return treeList;
    }



    //查询某个角色所拥有的菜单(不过滤ID等属性)


    public List<MenuModel> GetMenuTreeByRoleIDWithAllProp(String RoleID) {

        List<Menu> json_ = menuMapper.GetMenuTreeByRoleID(RoleID);

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


        return treeList;
    }


}
