package com.anshare.project.service.impl;

import com.anshare.project.dao.UsersMapper;
import com.anshare.project.model.Users;
import com.anshare.project.service.UsersService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/09/18.
 */
@Service
@Transactional
public class UsersServiceImpl extends AbstractService<Users> implements UsersService {
    @Resource
    private UsersMapper usersMapper;

}
