package com.anshare.project.service.inter.system;

import com.anshare.project.core.Service;
import com.anshare.project.model.system.Dept;

import com.anshare.project.model.other.TreeModel;
import java.util.List;


/**
 * Created by Anshare on 2018/09/27.
 */
public interface DeptService extends Service<Dept> {
    public List<TreeModel> GetTree();
}
