package com.anshare.project.dao.business;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.business.SixRewardorpunish;

import java.util.List;
import java.util.Map;

public interface SixRewardorpunishMapper extends Mapper<SixRewardorpunish> {
    public List<Map<String, Object>> list();

}