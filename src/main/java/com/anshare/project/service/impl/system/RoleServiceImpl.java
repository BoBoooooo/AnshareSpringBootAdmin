package com.anshare.project.service.impl.system;

import com.anshare.project.dao.system.RoleMapper;
import com.anshare.project.model.system.Role;
import com.anshare.project.service.inter.system.RoleService;
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
