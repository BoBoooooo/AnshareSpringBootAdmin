package com.anshare.project.dao.system;

import com.anshare.project.core.Mapper;
import com.anshare.project.model.system.Users;
import java.util.Map;
import java.util.List;

public interface UsersMapper extends Mapper<Users> {


    public List<Map<String, Object>> list();



}