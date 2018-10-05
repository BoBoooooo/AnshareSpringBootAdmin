package com.anshare.project.controller;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.Menu;
import com.anshare.project.model.MenuModel;
import com.anshare.project.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2018/09/27.
*/
@RestController
@RequestMapping("/menu")
@Api(value = "Menu管理", description = "Menu管理")

public class MenuController {
    @Resource
    private MenuService menuService;
    @ApiOperation(value = "addMenu")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteMenu")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        menuService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateMenu")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Menu menu) {
        menuService.update(menu);
        return ResultGenerator.genSuccessResult("更新成功");
    }
    @ApiOperation(value = "detailMenu")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }
    @ApiOperation(value = "返回tree格式json")

    @PostMapping("/treelist")
    public Result treelist(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<MenuModel> list = menuService.GetMenuTree();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "menulist")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Menu> list = menuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "获取某个角色拥有的菜单tree json")

    @PostMapping("/MenuTreeByRoleID")
    public Result list(@RequestParam String roleid) {
        List<MenuModel> list = menuService.GetMenuTreeByRoleID(roleid);
        return ResultGenerator.genSuccessResult(list);
    }
}