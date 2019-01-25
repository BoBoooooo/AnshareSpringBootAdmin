package com.anshare.project.controller;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.model.Users;
import com.anshare.project.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* Created by Anshare on 2018/09/18.
*/
@RestController
@RequestMapping("/users")
@Api(value = "Users管理", description = "Users管理")

public class UsersController {
    @Resource
    private UsersService usersService;
    @ApiOperation(value = "addUsers")

    @PostMapping("/add")
    public Result add(@RequestBody Users users) {
        usersService.save(users,true);
        return ResultGenerator.genSuccessResult("保存成功");
    }
    @ApiOperation(value = "deleteUsers")

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        usersService.deleteById(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
    @ApiOperation(value = "updateUsers")

    @PostMapping("/update")
    public Result update(@RequestBody Users users) {
        usersService.update(users);
        return ResultGenerator.genSuccessResult("更新成功");
    }
    @ApiOperation(value = "detailUsers")

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Users users = usersService.findById(id);
        return ResultGenerator.genSuccessResult(users);
    }


    @ApiOperation(value = "Userslist")

    @PostMapping("/list")
    public Result listtest(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "0") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Map<String,Object>> list = usersService.list();
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                Object key = it.next();
                Object value = map.get(key);
                System.out.println(value);
            }
        }


        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
