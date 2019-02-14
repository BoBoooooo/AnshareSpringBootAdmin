package com.anshare.project.service.impl.business;

import com.anshare.project.dao.business.SixRewardorpunishMapper;
import com.anshare.project.model.business.SixRewardorpunish;
import com.anshare.project.service.inter.business.SixRewardorpunishService;
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
public class SixRewardorpunishServiceImpl extends AbstractService<SixRewardorpunish> implements SixRewardorpunishService {
    @Resource
    private SixRewardorpunishMapper sixRewardorpunishMapper;

    public List<Map<String, Object>> list() {

        return sixRewardorpunishMapper.list();
    }



}
