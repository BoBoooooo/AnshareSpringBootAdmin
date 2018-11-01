package com.anshare.project.dao;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.Form;

import java.util.List;
import java.util.Map;

public interface FormMapper extends Mapper<Form> {

    public List<Map<String,Object>> getTables();

}