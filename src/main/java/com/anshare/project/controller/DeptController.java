package com.anshare.project.controller;
import com.anshare.project.core.Result;
import com.anshare.project.core.ResultGenerator;
import com.anshare.project.model.Dept;
import com.anshare.project.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2018/09/18.
*/
@RestController
@RequestMapping("/dept")
@Api(value = "Dept管理", description = "Dept管理")

public class DeptController {
    @Resource
    private DeptService deptService;
    @ApiOperation(value = "addDept")

    @PostMapping("/add")
    public Result add(Dept dept) {
        deptService.save(dept);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "deleteDept")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        deptService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "updateDept")

    @PostMapping("/update")
    public Result update(Dept dept) {
        deptService.update(dept);
        return ResultGenerator.genSuccessResult();
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
}
