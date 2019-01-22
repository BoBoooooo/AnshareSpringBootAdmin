package com.anshare.project.service.impl;
import com.anshare.project.model.TreeModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.anshare.project.core.AbstractService;
import com.anshare.project.core.Util.TreeUtil;
import com.anshare.project.dao.DeptMapper;
import com.anshare.project.model.Dept;
import com.anshare.project.service.DeptService;
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
public class DeptServiceImpl extends AbstractService<Dept> implements DeptService {
    @Resource
    private DeptMapper deptMapper;




    //查询所有菜单列表
    public List<TreeModel> GetTree() {

        List<Dept> json_ = deptMapper.selectAll();

        //定义list集合,存储从数据库查询出的所有记录
        List<TreeModel> list = new ArrayList<TreeModel>();

        // String id, String pid, String path, String redirect, String name, String component, Boolean alwaysShow, String menu
        //遍历集合
        for (Dept json : json_) {
            //手动封装Menu实体类对象
            TreeModel menu = new TreeModel(
                    json.getId(),
                    json.getParentid(),
                    json.getDeptname(),
                    json.getRank()
            );


            //添加每个实体类对象到list集合
            list.add(menu);
        }

        //调用TreeTest工具类方法生成树形结构的List集合
        List<TreeModel> treeList = TreeUtil.listToTree(list);

        //使用fastjson对树形list件序列化转成json字符串,过滤掉属性值为null的属性
        String message = JSON.toJSONString(treeList, SerializerFeature.PrettyFormat);
        List<TreeModel> treelist_ = JSON.parseArray(message,TreeModel.class);
        //重新将json字符串转成jsonObject对象,返回给前端
        return treelist_;
    }


}
