package com.anshare.project.controller;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.Person;
import com.anshare.project.service.PersonService;
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
@RequestMapping("/person")
@Api(value = "Person管理", description = "Person管理")

public class PersonController {
    @Resource
    private PersonService personService;
    @ApiOperation(value = "addPerson")

    @PostMapping("/add")
    public Result add(Person person) {
        personService.save(person,true);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "deletePerson")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        personService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "updatePerson")

    @PostMapping("/update")
    public Result update(Person person) {
        personService.update(person);
        return ResultGenerator.genSuccessResult();
    }
    @ApiOperation(value = "detailPerson")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Person person = personService.findById(id);
        return ResultGenerator.genSuccessResult(person);
    }
    @ApiOperation(value = "listPerson")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Person> list = personService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
