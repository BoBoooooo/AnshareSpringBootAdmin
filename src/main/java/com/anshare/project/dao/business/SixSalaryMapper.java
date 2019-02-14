package com.anshare.project.dao.business;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.business.SixSalary;

import java.util.List;
import java.util.Map;

public interface SixSalaryMapper extends Mapper<SixSalary> {
    public List<Map<String, Object>> list();

}