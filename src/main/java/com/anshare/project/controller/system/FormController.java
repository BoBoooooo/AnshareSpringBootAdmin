package com.anshare.project.controller.system;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.system.Form;
import com.anshare.project.service.inter.system.FormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by Anshare on 2018/11/01.
*/
@RestController
@RequestMapping("/form")
@Api(value = "Form管理", description = "Form管理")

public class FormController {
    @Resource
    private FormService formService;
    @ApiOperation(value = "addForm")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Form form) {
        formService.save(form,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }

    @ApiOperation(value = "updateForm")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Form form) {
        formService.update(form);
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @ApiOperation(value = "获取所有的表名")

    @PostMapping("/getTables")
    public Result getTables() {
        List<Map<String,Object>> list =  formService.getTables();
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "获取某表所有字段以及对应的类型，注释")

    @PostMapping("/getKey")
    public Result getkey(@RequestParam String tablename) {
        List<Map<String,Object>> obj = formService.getObj(tablename);
        return ResultGenerator.genSuccessResult(obj);
    }

    @ApiOperation(value = "detailForm")

    @PostMapping("/detail")
    public Result detail(@RequestParam String tablename) {

       Condition condition = new Condition(Form.class);
        condition.createCriteria()
                .andEqualTo("tableName", tablename);

        List<Form> form = formService.findByCondition(condition);

        if(form.size()==0)
            return ResultGenerator.genSuccessResult("首次制作");
        else
        return ResultGenerator.genSuccessResult(form.get(0));
    }



}
