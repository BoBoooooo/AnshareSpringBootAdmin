package com.anshare.project.service;
import com.anshare.project.model.TreeModel;
import com.anshare.project.model.Unit;
import com.anshare.project.core.Service;

import java.util.List;


/**
 * Created by Anshare on 2019/01/24.
 */
public interface UnitService extends Service<Unit> {
    public List<TreeModel> GetTree();

}
