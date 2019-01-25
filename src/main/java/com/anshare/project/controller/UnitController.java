package com.anshare.project.controller;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.TreeModel;
import com.anshare.project.model.Unit;
import com.anshare.project.service.UnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2019/01/24.
*/
@RestController
@RequestMapping("/unit")
@Api(value = "Unit管理", description = "Unit管理")

public class UnitController {
    @Resource
    private UnitService unitService;
    @ApiOperation(value = "addUnit")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Unit unit) {
        unitService.save(unit,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteUnit")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        unitService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateUnit")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Unit unit) {
        unitService.update(unit);
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @ApiOperation(value = "获取Unit对象所有字段")

    @PostMapping("/Getkey")
    public Result Getkey() {
Unit unit = new Unit();
        return ResultGenerator.genSuccessResult(unit);
    }



    @ApiOperation(value = "detailUnit")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Unit unit = unitService.findById(id);
        return ResultGenerator.genSuccessResult(unit);
    }
    @ApiOperation(value = "listUnit")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Unit> list = unitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/treelist")
    public Result treelist() {
        List<TreeModel> list = unitService.GetTree();
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "返回空对象")
    @PostMapping("/getObj")
    public Result getObj() {
        return ResultGenerator.genSuccessResult(new Unit());
    }




}
