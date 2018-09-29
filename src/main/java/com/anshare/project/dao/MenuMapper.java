package com.anshare.project.dao;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.Menu;

import java.util.List;
import java.util.Map;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> GetMenuTreeByRoleID(String ID);

}