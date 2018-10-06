package com.anshare.project.service.impl;

import com.anshare.project.dao.RolemenuMapper;
import com.anshare.project.model.Rolemenu;
import com.anshare.project.service.RolemenuService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/10/06.
 */
@Service
@Transactional
public class RolemenuServiceImpl extends AbstractService<Rolemenu> implements RolemenuService {
    @Resource
    private RolemenuMapper rolemenuMapper;

}
