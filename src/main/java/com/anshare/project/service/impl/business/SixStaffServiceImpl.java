package com.anshare.project.service.impl.business;

import com.anshare.project.dao.business.SixStaffMapper;
import com.anshare.project.model.business.SixStaff;
import com.anshare.project.service.inter.business.SixStaffService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2019/02/04.
 */
@Service
@Transactional
public class SixStaffServiceImpl extends AbstractService<SixStaff> implements SixStaffService {
    @Resource
    private SixStaffMapper sixStaffMapper;
    public List<Map<String, Object>> list() {
        return sixStaffMapper.list();
    }
}
