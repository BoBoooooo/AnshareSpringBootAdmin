package com.anshare.project.service.impl.system;

import com.anshare.project.dao.system.UsersMapper;
import com.anshare.project.model.system.Users;
import com.anshare.project.service.inter.system.UsersService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2018/09/18.
 */
@Service
@Transactional
public class UsersServiceImpl extends AbstractService<Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

    public List<Map<String, Object>> list() {

        return usersMapper.list();
    }


}
