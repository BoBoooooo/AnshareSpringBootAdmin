package com.anshare.project.service.impl;

import com.anshare.project.dao.PersonMapper;
import com.anshare.project.model.Person;
import com.anshare.project.service.PersonService;
import com.anshare.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;
import java.util.List;

/**
 * Created by Anshare on 2018/10/08.
 */
@Service
@Transactional
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {
    @Resource
    private PersonMapper personMapper;

    public List<Map<String,Object>> getObj(){

      return  personMapper.getObj();

    }

}
