package com.anshare.project.service.impl.business;

import com.anshare.project.dao.business.SixSalaryMapper;
import com.anshare.project.model.business.SixSalary;
import com.anshare.project.service.inter.business.SixSalaryService;
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
public class SixSalaryServiceImpl extends AbstractService<SixSalary> implements SixSalaryService {
    @Resource
    private SixSalaryMapper sixSalaryMapper;

    public List<Map<String, Object>> list() {

        return sixSalaryMapper.list();
    }


}
