package com.anshare.project.service;

import com.anshare.project.core.Service;
import com.anshare.project.model.Dept;

import com.anshare.project.model.TreeModel;
import java.util.List;


/**
 * Created by Anshare on 2018/09/27.
 */
public interface DeptService extends Service<Dept> {
    public List<TreeModel> GetTree();
}
