package com.anshare.project.service.impl;

import com.anshare.project.dao.AffixMapper;
import com.anshare.project.model.Affix;
import com.anshare.project.service.AffixService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/10/05.
 */
@Service
@Transactional
public class AffixServiceImpl extends AbstractService<Affix> implements AffixService {
    @Resource
    private AffixMapper affixMapper;

}
