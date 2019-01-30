package com.anshare.project.controller.system;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.system.Dict;
import com.anshare.project.service.inter.system.DictService;
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
@RequestMapping("/dict")
@Api(value = "Dict管理", description = "Dict管理")

public class DictController {
    @Resource
    private DictService dictService;
    @ApiOperation(value = "addDict")

    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public Result add(@RequestBody Dict dict) {
        dictService.save(dict,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteDict")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        dictService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");

    }
    @ApiOperation(value = "updateDict")

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result update(@RequestBody Dict dict) {
        dictService.update(dict);
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @ApiOperation(value = "获取Dict对象所有字段")

    @PostMapping("/Getkey")
    public Result Getkey() {
Dict dict = new Dict();
        return ResultGenerator.genSuccessResult(dict);
    }



    @ApiOperation(value = "detailDict")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Dict dict = dictService.findById(id);
        return ResultGenerator.genSuccessResult(dict);
    }
    @ApiOperation(value = "listDict")

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Dict> list = dictService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
