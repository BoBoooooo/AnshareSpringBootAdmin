package com.anshare.project.service.impl.business;

import com.anshare.project.dao.business.SixNoticeMapper;
import com.anshare.project.model.business.SixNotice;
import com.anshare.project.service.inter.business.SixNoticeService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2019/02/04.
 */
@Service
@Transactional
public class SixNoticeServiceImpl extends AbstractService<SixNotice> implements SixNoticeService {
    @Resource
    private SixNoticeMapper sixNoticeMapper;

}
