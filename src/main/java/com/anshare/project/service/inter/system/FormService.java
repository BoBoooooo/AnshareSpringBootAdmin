package com.anshare.project.service.inter.system;
import com.anshare.project.model.system.Form;
import com.anshare.project.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2018/11/01.
 */
public interface FormService extends Service<Form> {
    public List<Map<String,Object>> getTables();
    public List<Map<String,Object>> getObj(String tablename);


}
