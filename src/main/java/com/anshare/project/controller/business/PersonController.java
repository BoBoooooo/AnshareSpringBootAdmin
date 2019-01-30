package com.anshare.project.controller.business;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.JwtUtil;
import com.anshare.project.model.business.Person;
import com.anshare.project.model.other.ListQuery;
import com.anshare.project.service.inter.business.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
        personService.save(person,false);
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
    @ApiOperation(value = "获取Person对象所有字段以及对应的类型，注释")

    @PostMapping("/Getkey")
    public Result Getkey() {
        List<Map<String,Object>> obj = personService.getObj();
        return ResultGenerator.genSuccessResult(obj);
    }

    @PostMapping("/getObj")
    public Result getObj() {
        return ResultGenerator.genSuccessResult(new Person());
    }



    @ApiOperation(value = "detailPerson")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Person person = personService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }
    @ApiOperation(value = "listPerson")

    @PostMapping("/list")
    public Result list(@RequestBody ListQuery params)
    {
        PageHelper.startPage(params.getPageIndex(), params.getPageSize());

        List<Person> list = personService.findByConditionSuperQuery(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
