package com.anshare.project.controller.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anshare.project.core.ResultCore.ResultGenerator_temp;
import com.anshare.project.core.ResultCore.Result_temp;
import com.anshare.project.core.Util.FileUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public Result_temp add(String client_id,String client_secret) {

        List<HashMap<String,String>> temp = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> a = new HashMap<>();
        a.put("wqt","省纪委办公厅函询（苏纪办函询）");
        a.put("wqtid","1c8b81f35f804856015f8089d9930013142038");
        temp.add(a);
        HashMap<String,String> b = new HashMap<>();
        b.put("wqt","函-省纪委办公厅（苏纪办函）");
        b.put("wqtid","1c8b81f35e3b07e6015e3bfda028005e135030");
        temp.add(b);
        return ResultGenerator_temp.genSuccessResult(temp,"文签头返回成功,success");
    }

    @PostMapping(value = "/sendForm",produces = "application/json;charset=UTF-8")

    public Result_temp sendForm(@RequestParam String params) throws UnsupportedEncodingException {
        String jsonstring =  URLDecoder.decode(params,"UTF-8");

        System.out.println(jsonstring);
        JSONObject obj = JSONObject.parseObject(jsonstring);


        return ResultGenerator_temp.genSuccessResult(obj,"发送成功,success"+jsonstring);
    }


    @PostMapping("/sendFile")

    public Result_temp Upload(@RequestParam("file") MultipartFile file,@RequestParam("params") String params,
                         HttpServletRequest request) {
        JSONObject obj = JSON.parseObject(params);
        String fileName = file.getOriginalFilename();
        String fileExtension = "." + FileUtil.getExtensionName(fileName);
        String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
        File dest = new File(uploadDir + fileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }
        return ResultGenerator_temp.genSuccessResult("上传成功");


        //返回json
    }

}
