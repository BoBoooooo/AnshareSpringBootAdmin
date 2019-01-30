package com.anshare.project.service.inter.business;
import com.anshare.project.model.business.Person;
import com.anshare.project.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2018/10/08.
 */
public interface PersonService extends Service<Person> {
    public List<Map<String,Object>> getObj();

}
