package com.anshare.project.controller;
import com.anshare.project.core.Result;
import com.anshare.project.core.ResultGenerator;
import com.anshare.project.model.Role;
import com.anshare.project.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2018/09/20.
*/
@RestController
@RequestMapping("/role")
@Api(value = "Role管理", description = "Role管理")

public class RoleController {
    @Resource
    private RoleService roleService;
    @ApiOperation(value = "addRole")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Role role) {
        roleService.save(role);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteRole")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        roleService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
    @ApiOperation(value = "updateRole")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Role role) {

        roleService.update(role);
        return ResultGenerator.genSuccessResult("更新成功");
    }
    @ApiOperation(value = "detailRole")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Role role = roleService.findById(id);
        return ResultGenerator.genSuccessResult(role);
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
