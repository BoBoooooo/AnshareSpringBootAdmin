package com.anshare.project.dao.system;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.system.Form;

import java.util.List;
import java.util.Map;

public interface FormMapper extends Mapper<Form> {

    public List<Map<String,Object>> getTables();
    public List<Map<String,Object>> getObj(String tablename);

}