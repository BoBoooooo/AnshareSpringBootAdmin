package com.anshare.project.service.impl.system;

import com.anshare.project.dao.system.DictMapper;
import com.anshare.project.model.system.Dict;
import com.anshare.project.service.inter.system.DictService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2019/01/30.
 */
@Service
@Transactional
public class DictServiceImpl extends AbstractService<Dict> implements DictService {
    @Resource
    private DictMapper dictMapper;

}
