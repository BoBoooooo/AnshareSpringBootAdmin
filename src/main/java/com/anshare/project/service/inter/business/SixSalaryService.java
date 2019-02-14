package com.anshare.project.service.inter.business;
import com.anshare.project.model.business.SixSalary;
import com.anshare.project.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2019/02/04.
 */
public interface SixSalaryService extends Service<SixSalary> {
    public List<Map<String, Object>> list() ;

}
