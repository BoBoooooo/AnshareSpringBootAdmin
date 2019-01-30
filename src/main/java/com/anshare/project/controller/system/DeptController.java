package com.anshare.project.controller.system;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.system.Dept;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.service.inter.system.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2018/09/27.
*/
@RestController
@RequestMapping("/dept")
@Api(value = "Dept管理", description = "Dept管理")

public class DeptController {
    @Resource
    private DeptService deptService;
    @ApiOperation(value = "addDept")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Dept dept) {
        deptService.save(dept,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteDept")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        deptService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateDept")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return ResultGenerator.genSuccessResult("更新成功");
    }
    @ApiOperation(value = "detailDept")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Dept dept = deptService.findById(id);
        return ResultGenerator.genSuccessResult(dept);
    }
    @ApiOperation(value = "listDept")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Dept> list = deptService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "返回tree格式json")

    @PostMapping("/treelist")
    public Result treelist() {
        List<TreeModel> list = deptService.GetTree();
        return ResultGenerator.genSuccessResult(list);
    }
    @ApiOperation(value = "返回空对象")
    @PostMapping("/getObj")
    public Result getObj() {
        return ResultGenerator.genSuccessResult(new Dept());
    }



}
