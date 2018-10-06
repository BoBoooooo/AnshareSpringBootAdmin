package com.anshare.project.service;
import com.anshare.project.core.Service;
import com.anshare.project.model.Menu;
import com.anshare.project.model.MenuModel;

import java.util.List;


/**
 * Created by Anshare on 2018/09/27.
 */
public interface MenuService extends Service<Menu> {
    public List<MenuModel> GetMenuTree();
    public List<MenuModel> GetMenuTreeByRoleID (String RoleID);
    public List<MenuModel> GetMenuTreeByRoleIDWithAllProp (String RoleID);

}
