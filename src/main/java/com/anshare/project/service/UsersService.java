package com.anshare.project.service;
import com.anshare.project.model.Users;
import com.anshare.project.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2018/09/18.
 */
public interface UsersService extends Service<Users> {
    public List<Map<String, Object>> list();


}
