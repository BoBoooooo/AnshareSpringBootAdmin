package com.anshare.project.service.impl;

import com.anshare.project.dao.AttendanceMapper;
import com.anshare.project.model.Attendance;
import com.anshare.project.service.AttendanceService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Anshare on 2018/09/18.
 */
@Service
@Transactional
public class AttendanceServiceImpl extends AbstractService<Attendance> implements AttendanceService {
    @Resource
    private AttendanceMapper attendanceMapper;

}
