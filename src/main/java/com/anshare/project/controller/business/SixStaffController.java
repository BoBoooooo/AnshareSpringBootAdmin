package com.anshare.project.controller.business;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.business.SixStaff;
import com.anshare.project.service.inter.business.SixStaffService;
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
@RequestMapping("/six_staff")
@Api(value = "SixStaff管理", description = "SixStaff管理")

public class SixStaffController {
    @Resource
    private SixStaffService sixStaffService;
    @ApiOperation(value = "addSixStaff")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody SixStaff sixStaff) {
        sixStaffService.save(sixStaff,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteSixStaff")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        sixStaffService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateSixStaff")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody SixStaff sixStaff) {
        sixStaffService.update(sixStaff);
        return ResultGenerator.genSuccessResult("更新成功");
    }


    @ApiOperation(value = "detailSixStaff")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        SixStaff sixStaff = sixStaffService.findById(id);
        return ResultGenerator.genSuccessResult(sixStaff);
    }
    @ApiOperation(value = "listSixStaff")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SixStaff> list = sixStaffService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/getObj")

    public Result getObj() {
        return ResultGenerator.genSuccessResult(new SixStaff());
    }

}
