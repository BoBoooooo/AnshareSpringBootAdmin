package com.anshare.project.controller;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.Attendance;
import com.anshare.project.service.AttendanceService;
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
@RequestMapping("/attendance")
@Api(value = "Attendance管理", description = "Attendance管理")

public class AttendanceController {
    @Resource
    private AttendanceService attendanceService;
    @ApiOperation(value = "addAttendance")

    @PostMapping("/add")
    public Result add(Attendance attendance) {
        attendanceService.save(attendance);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "deleteAttendance")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        attendanceService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "updateAttendance")

    @PostMapping("/update")
    public Result update(Attendance attendance) {
        attendanceService.update(attendance);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "detailAttendance")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Attendance attendance = attendanceService.findById(id);
        return ResultGenerator.genSuccessResult(attendance);
    }
    @ApiOperation(value = "listAttendance")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Attendance> list = attendanceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
