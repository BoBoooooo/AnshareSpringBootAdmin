package com.anshare.project.service.impl.system;

import com.anshare.project.core.AbstractService;
import com.anshare.project.core.Util.TreeUtil;
import com.anshare.project.dao.system.UnitMapper;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.model.system.Unit;
import com.anshare.project.service.inter.system.UnitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anshare on 2019/01/24.
 */
@Service
@Transactional
public class UnitServiceImpl extends AbstractService<Unit> implements UnitService {
    @Resource
    private UnitMapper unitMapper;

    //查询所有菜单列表
    public List<TreeModel> GetTree() {

        List<Unit> json_ = unitMapper.selectAll();

        //定义list集合,存储从数据库查询出的所有记录
        List<TreeModel> list = new ArrayList<TreeModel>();

        // String id, String pid, String path, String redirect, String name, String component, Boolean alwaysShow, String menu
        //遍历集合
        for (Unit json : json_) {
            //手动封装Menu实体类对象
            TreeModel menu = new TreeModel(
                    json.getId(),
                    json.getParentid(),
                    json.getUnitname(),
                    json.getSequence()

            );


            //添加每个实体类对象到list集合
            list.add(menu);
        }

        //调用TreeTest工具类方法生成树形结构的List集合
        List<TreeModel> treeList = TreeUtil.listToTree(list);

        return treeList;
    }
}
