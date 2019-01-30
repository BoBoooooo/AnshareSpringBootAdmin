package com.anshare.project.service.inter.system;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.model.system.Dicttype;
import com.anshare.project.core.Service;

import java.util.List;


/**
 * Created by Anshare on 2019/01/30.
 */
public interface DicttypeService extends Service<Dicttype> {
    public List<TreeModel> GetTree();

}
