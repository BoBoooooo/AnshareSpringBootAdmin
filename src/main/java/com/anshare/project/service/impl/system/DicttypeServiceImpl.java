package com.anshare.project.service.impl.system;

import com.anshare.project.core.AbstractService;
import com.anshare.project.core.Util.TreeUtil;
import com.anshare.project.dao.system.DicttypeMapper;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.model.system.Dicttype;
import com.anshare.project.service.inter.system.DicttypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Anshare on 2019/01/30.
 */
@Service
@Transactional
public class DicttypeServiceImpl extends AbstractService<Dicttype> implements DicttypeService {
    @Resource
    private DicttypeMapper dicttypeMapper;


    public List<TreeModel> GetTree() {

        List<Dicttype> json_ = dicttypeMapper.selectAll();

        //定义list集合,存储从数据库查询出的所有记录
        List<TreeModel> list = new ArrayList<TreeModel>();

        //遍历集合
        for (Dicttype json : json_) {
            //手动封装Menu实体类对象
            TreeModel menu = new TreeModel(
                    json.getId(),
                    json.getPid(),
                    json.getName(),
                    json.getSort()

            );


            //添加每个实体类对象到list集合
            list.add(menu);
        }

        //调用TreeTest工具类方法生成树形结构的List集合
        List<TreeModel> treeList = TreeUtil.listToTree(list);

        return treeList;
    }

}
