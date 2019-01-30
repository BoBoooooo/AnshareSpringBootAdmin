package com.anshare.project.service.impl.system;

import com.anshare.project.dao.system.DeptunitMapper;
import com.anshare.project.model.system.Deptunit;
import com.anshare.project.service.inter.system.DeptunitService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2019/01/30.
 */
@Service
@Transactional
public class DeptunitServiceImpl extends AbstractService<Deptunit> implements DeptunitService {
    @Resource
    private DeptunitMapper deptunitMapper;

}
