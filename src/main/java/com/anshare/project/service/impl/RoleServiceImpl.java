package com.anshare.project.service.impl;

import com.anshare.project.dao.RoleMapper;
import com.anshare.project.model.Role;
import com.anshare.project.service.RoleService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/09/20.
 */
@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

}
