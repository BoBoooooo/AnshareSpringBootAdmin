package com.anshare.project.controller;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.JwtUtil;
import com.anshare.project.model.Person;
import com.anshare.project.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by Anshare on 2018/10/08.
*/
@RestController
@RequestMapping("/person")
@Api(value = "Person管理", description = "Person管理")

public class PersonController {
    @Resource
    private PersonService personService;
    @ApiOperation(value = "addPerson")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Person person) {
        String [] details = JwtUtil.GetDetails();

        person.setHandlestaff(details[4]);
        person.setHandledept(details[3]);
        personService.save(person,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deletePerson")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        personService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updatePerson")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Person person) {

        personService.update(person);
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @ApiOperation(value = "获取Person对象所有字段")

    @PostMapping("/Getkey")
    public Result Getkey() {
        List<Map<String,Object>> obj = personService.getObj();
        return ResultGenerator.genSuccessResult(obj);
    }



    @ApiOperation(value = "detailPerson")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Person person = personService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }
    @ApiOperation(value = "listPerson")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber,
                       @RequestParam(defaultValue = "0") Integer pageSize,
                       @RequestParam(required = false,defaultValue = "") String SearchKey ,
                       @RequestParam(required = false,defaultValue = "") String SearchValue)
    {
        PageHelper.startPage(pageNumber, pageSize);
        Condition condition = new Condition(Person.class);

        Example.Criteria criteria  = condition.createCriteria();
        String[] details = JwtUtil.GetDetails();


        criteria.andEqualTo("handledept", details[3]);



        if(!SearchKey.isEmpty()&&!SearchValue.isEmpty())
        {
            criteria.andEqualTo(SearchKey, SearchValue);
        }



        List<Person> list = personService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
