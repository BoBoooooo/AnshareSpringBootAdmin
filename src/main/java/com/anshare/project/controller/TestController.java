package com.anshare.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* Created by Anshare on 2018/09/27.
*/
@RestController
@RequestMapping("/test")

public class TestController {

    @GetMapping(value = "/getWenHeader")
    public Result add(String client_id,String client_secret) {

        List<HashMap<String,String>> temp = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> a = new HashMap<>();
        a.put("wqt","123");
        a.put("wqtid","456");
        temp.add(a);
        HashMap<String,String> b = new HashMap<>();
        b.put("wqt","123");
        b.put("wqtid","456");
        temp.add(b);
        return ResultGenerator.genSuccessResult(temp,"文签头返回成功,success");
    }

    @PostMapping(value = "/sendForm",produces = "application/json;charset=UTF-8")

    public Result sendForm(@RequestParam String params) throws UnsupportedEncodingException {
        String jsonstring =  URLDecoder.decode(params,"UTF-8");
        JSONObject obj = JSONObject.parseObject(jsonstring);
        return ResultGenerator.genSuccessResult(obj,"发送成功,success");
    }


    @PostMapping("/sendFile")

    public Result Upload(@RequestParam("params") String jsonstring,
                         HttpServletRequest request) {

        JSONObject obj = JSONObject.parseObject(jsonstring);

        return ResultGenerator.genSuccessResult("上传成功:success");
        }
}
