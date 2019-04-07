package com.anshare.project.dao.business;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.business.SixStaff;

import java.util.List;
import java.util.Map;

public interface SixStaffMapper extends Mapper<SixStaff> {
    public List<Map<String, Object>> list();

}