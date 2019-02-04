package com.anshare.project.controller.business;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.business.SixRewardorpunish;
import com.anshare.project.service.inter.business.SixRewardorpunishService;
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
@RequestMapping("/six_rewardorpunish")
@Api(value = "SixRewardorpunish管理", description = "SixRewardorpunish管理")

public class SixRewardorpunishController {
    @Resource
    private SixRewardorpunishService sixRewardorpunishService;
    @ApiOperation(value = "addSixRewardorpunish")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody SixRewardorpunish sixRewardorpunish) {
        sixRewardorpunishService.save(sixRewardorpunish,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteSixRewardorpunish")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        sixRewardorpunishService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateSixRewardorpunish")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody SixRewardorpunish sixRewardorpunish) {
        sixRewardorpunishService.update(sixRewardorpunish);
        return ResultGenerator.genSuccessResult("更新成功");
    }


    @ApiOperation(value = "detailSixRewardorpunish")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        SixRewardorpunish sixRewardorpunish = sixRewardorpunishService.findById(id);
        return ResultGenerator.genSuccessResult(sixRewardorpunish);
    }
    @ApiOperation(value = "listSixRewardorpunish")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<SixRewardorpunish> list = sixRewardorpunishService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/getObj")

    public Result getObj() {
        return ResultGenerator.genSuccessResult(new SixRewardorpunish());
    }


}
