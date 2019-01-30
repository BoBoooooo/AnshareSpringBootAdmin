package com.anshare.project.controller.system;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.other.TreeModel;
import com.anshare.project.model.system.Dicttype;
import com.anshare.project.service.inter.system.DicttypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by Anshare on 2019/01/30.
*/
@RestController
@RequestMapping("/dicttype")
@Api(value = "Dicttype管理", description = "Dicttype管理")

public class DicttypeController {
    @Resource
    private DicttypeService dicttypeService;
    @ApiOperation(value = "addDicttype")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Dicttype dicttype) {
        dicttypeService.save(dicttype,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteDicttype")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        dicttypeService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateDicttype")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Dicttype dicttype) {
        dicttypeService.update(dicttype);
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @ApiOperation(value = "获取Dicttype对象所有字段")

    @PostMapping("/Getkey")
    public Result Getkey() {
Dicttype dicttype = new Dicttype();
        return ResultGenerator.genSuccessResult(dicttype);
    }



    @ApiOperation(value = "detailDicttype")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Dicttype dicttype = dicttypeService.findById(id);
        return ResultGenerator.genSuccessResult(dicttype);
    }
    @ApiOperation(value = "listDicttype")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Dicttype> list = dicttypeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @ApiOperation(value = "获取树状结构json")

    @PostMapping("/treelist")
    public Result treelist() {
        List<TreeModel> list = dicttypeService.GetTree();
        return ResultGenerator.genSuccessResult(list);
    }

}
