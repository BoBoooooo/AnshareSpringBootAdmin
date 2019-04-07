package com.anshare.project.service.inter.business;
import com.anshare.project.model.business.SixStaff;
import com.anshare.project.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by Anshare on 2019/02/04.
 */
public interface SixStaffService extends Service<SixStaff> {
    public List<Map<String, Object>> list() ;

}
