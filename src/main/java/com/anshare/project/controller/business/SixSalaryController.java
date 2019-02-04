package com.anshare.project.controller.business;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.business.SixRewardorpunish;
import com.anshare.project.model.business.SixSalary;
import com.anshare.project.service.inter.business.SixSalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2019/02/04.
*/
@RestController
@RequestMapping("/six_salary")
@Api(value = "SixSalary管理", description = "SixSalary管理")

public class SixSalaryController {
    @Resource
    private SixSalaryService sixSalaryService;
    @ApiOperation(value = "addSixSalary")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody SixSalary sixSalary) {
        sixSalaryService.save(sixSalary,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteSixSalary")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        sixSalaryService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateSixSalary")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody SixSalary sixSalary) {
        sixSalaryService.update(sixSalary);
        return ResultGenerator.genSuccessResult("更新成功");
    }


    @ApiOperation(value = "detailSixSalary")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        SixSalary sixSalary = sixSalaryService.findById(id);
        return ResultGenerator.genSuccessResult(sixSalary);
    }
    @ApiOperation(value = "listSixSalary")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SixSalary> list = sixSalaryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/getObj")

    public Result getObj() {
        return ResultGenerator.genSuccessResult(new SixSalary());
    }

}
