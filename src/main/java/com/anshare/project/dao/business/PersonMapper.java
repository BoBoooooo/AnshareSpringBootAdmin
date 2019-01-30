package com.anshare.project.dao.business;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.business.Person;
import java.util.Map;
import java.util.List;
public interface PersonMapper extends Mapper<Person> {
    public List<Map<String,Object>> getObj();
}