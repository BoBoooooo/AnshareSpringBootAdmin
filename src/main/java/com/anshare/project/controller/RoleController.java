package com.anshare.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.MenuModel;
import com.anshare.project.model.Role;
import com.anshare.project.model.Rolemenu;
import com.anshare.project.service.MenuService;
import com.anshare.project.service.RoleService;
import com.anshare.project.service.RolemenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Anshare on 2018/09/20.
 */
@RestController
@RequestMapping("/role")
@Api(value = "Role管理", description = "Role管理")

public class RoleController {
    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;
    @Resource
    private RolemenuService rolemenuService;


    @ApiOperation(value = "addRole")

    @PostMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Map<String, Object> temp) {
        Role role = (Role) temp.get("Role");
        List<String> menuid = (List<String>) temp.get("MenuList"); //角色勾选的菜单id数组
        List<Rolemenu> rolemenulist = new ArrayList<Rolemenu>();

        String guid = UUID.randomUUID().toString();

        role.setId(guid); //手动赋值id

        for (String str : menuid) {
            Rolemenu t = new Rolemenu();
            t.setRoleid(role.getId());
            t.setMenuid(str);
            rolemenulist.add(t);
        }
        rolemenuService.save(rolemenulist); //batch批量insert
        roleService.save(role,false);
        return ResultGenerator.genSuccessResult("保存成功");
    }

    @ApiOperation(value = "deleteRole")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {


        //先清空rolemenu表中roleid相关数据

        Condition condition = new Condition(Rolemenu.class);
        condition.createCriteria().andEqualTo("roleid", id);

        rolemenuService.deleteByCondition(condition);
        roleService.deleteById(id);

        return ResultGenerator.genSuccessResult("删除成功");



    }
//    @ApiOperation(value = "updateRole")
//
//    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
//    public Result update(@RequestBody Role role) {
//
//        roleService.update(role);
//        return ResultGenerator.genSuccessResult("更新成功");
//    }


    @ApiOperation(value = "updateRole")

    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Map<String, Object> temp) {
        Role role = (Role) temp.get("Role");
        List<String> menuid = (List<String>) temp.get("MenuList"); //角色勾选的菜单id数组

        //先清空rolemenu表中roleid相关数据

        Condition condition = new Condition(Rolemenu.class);
        condition.createCriteria().andEqualTo("roleid", role.getId());

        rolemenuService.deleteByCondition(condition);


        List<Rolemenu> rolemenulist = new ArrayList<Rolemenu>();


        for (String str : menuid) {
            Rolemenu t = new Rolemenu();
            t.setRoleid(role.getId());
            t.setMenuid(str);
            rolemenulist.add(t);
        }
        rolemenuService.save(rolemenulist); //batch批量insert
        roleService.update(role);
        return ResultGenerator.genSuccessResult("更新成功");
    }


    @ApiOperation(value = "detailRole")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Role role = roleService.findById(id);
        List<MenuModel> menuList = menuService.GetMenuTreeByRoleID(id);

        List<String> menuid_list = new ArrayList<String>();

        for (MenuModel a : menuList) {
            menuid_list.add(a.getId());
        }
        JSONObject temp = new JSONObject();
        temp.put("Role", role);
        temp.put("MenuList", menuid_list);
        return ResultGenerator.genSuccessResult(temp);
    }

    @ApiOperation(value = "listRole")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Role> list = roleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
