package com.anshare.project.controller.business;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.business.SixNotice;
import com.anshare.project.model.other.ListQuery;
import com.anshare.project.service.inter.business.SixNoticeService;
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
@RequestMapping("/six_notice")
@Api(value = "SixNotice管理", description = "SixNotice管理")

public class SixNoticeController {
    @Resource
    private SixNoticeService sixNoticeService;
    @ApiOperation(value = "addSixNotice")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody SixNotice sixNotice) {
        sixNoticeService.save(sixNotice,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteSixNotice")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        sixNoticeService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateSixNotice")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody SixNotice sixNotice) {
        sixNoticeService.update(sixNotice);
        return ResultGenerator.genSuccessResult("更新成功");
    }


    @ApiOperation(value = "detailSixNotice")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        SixNotice sixNotice = sixNoticeService.findById(id);
        return ResultGenerator.genSuccessResult(sixNotice);
    }
    @ApiOperation(value = "listSixNotice")

    @PostMapping("/list")
    public Result list(@RequestBody ListQuery params)
    {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());

        List<SixNotice> list = sixNoticeService.findByConditionSuperQuery(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/getObj")
    public Result getObj() {
        return ResultGenerator.genSuccessResult(new SixNotice());
    }


}
