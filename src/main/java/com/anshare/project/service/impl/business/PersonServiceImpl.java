package com.anshare.project.service.impl.business;

import com.anshare.project.dao.business.PersonMapper;
import com.anshare.project.model.business.Person;
import com.anshare.project.service.inter.business.PersonService;
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
