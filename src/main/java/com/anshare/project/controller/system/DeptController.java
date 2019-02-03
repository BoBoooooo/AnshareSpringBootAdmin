package com.anshare.project.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.model.system.Dept;
import com.anshare.project.model.system.Deptunit;
import com.anshare.project.service.inter.system.DeptService;
import com.anshare.project.service.inter.system.DeptunitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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

    @Resource
    private DeptunitService deptunitService;
    @ApiOperation(value = "addDept")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody JSONObject jsonObj) {


        String deptstr = jsonObj.getJSONObject("obj").toJSONString();
        String unitlist = jsonObj.getJSONArray("unitlist").toJSONString();


        Dept dept = JSON.parseObject(deptstr,Dept.class);
        List<String>str = JSON.parseArray(unitlist,String.class);

        for (String s : str){

            Deptunit obj = new Deptunit();
            obj.setDeptid(dept.getId());
            obj.setUnitid(s);
            deptunitService.save(obj,true);
        }

        deptService.save(dept,false);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteDept")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        deptService.deleteById(id);


        tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(Deptunit.class);
        Example.Criteria criteria  = condition.createCriteria()
                .andEqualTo("deptid",id);

        deptunitService.deleteByCondition(condition);



        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateDept")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody JSONObject jsonObj) {


        String deptstr = jsonObj.getJSONObject("obj").toJSONString();
        String unitlist = jsonObj.getJSONArray("unitlist").toJSONString();


        Dept dept = JSON.parseObject(deptstr,Dept.class);
        List<String>str = JSON.parseArray(unitlist,String.class);


        tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(Deptunit.class);
        Example.Criteria criteria  = condition.createCriteria()
                .andEqualTo("deptid",dept.getId());

        deptunitService.deleteByCondition(condition);

        for (String s : str){

            Deptunit obj = new Deptunit();
            obj.setDeptid(dept.getId());
            obj.setUnitid(s);
            deptunitService.save(obj,true);
        }

        deptService.update(dept);
        return ResultGenerator.genSuccessResult("更新成功");
    }
    @ApiOperation(value = "detailDept")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Dept dept = deptService.findById(id);

        tk.mybatis.mapper.entity.Condition condition = new tk.mybatis.mapper.entity.Condition(Deptunit.class);
        Example.Criteria criteria  = condition.createCriteria()
                .andEqualTo("deptid",id);


        List<Deptunit> unitlist = deptunitService.findByCondition(condition);

        String str = "";

        for(Deptunit deptunit : unitlist){
            str+= deptunit.getUnitid();
            str+=",";
        }
        str =  str.length()>0? str.substring(0,str.length()-1):str;

        JSONObject obj = new JSONObject();
        obj.put("unitlist",str.split(","));
        obj.put("obj",dept);

        return ResultGenerator.genSuccessResult(obj);
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
