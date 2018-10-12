package com.anshare.project.dao;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.Person;
import java.util.Map;
import java.util.List;
public interface PersonMapper extends Mapper<Person> {
    public List<Map<String,Object>> getObj();
}