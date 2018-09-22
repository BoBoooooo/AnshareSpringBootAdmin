package com.anshare.project.service.impl;

import com.anshare.project.dao.DeptMapper;
import com.anshare.project.model.Dept;
import com.anshare.project.service.DeptService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/09/18.
 */
@Service
@Transactional
public class DeptServiceImpl extends AbstractService<Dept> implements DeptService {
    @Resource
    private DeptMapper deptMapper;

}
