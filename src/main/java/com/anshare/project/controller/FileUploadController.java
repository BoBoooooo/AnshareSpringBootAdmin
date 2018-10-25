package com.anshare.project.controller;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.FileUtil;
import com.anshare.project.model.Affix;
import com.anshare.project.model.Person;
import com.anshare.project.service.AffixService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

/**
 * Created by Anshare on 2018/09/27.
 */
@RestController
@RequestMapping("/file")
@Api(value = "上传文件", description = "上传文件")

public class FileUploadController {

    @Resource
    private AffixService affixService;


    @Resource

    @ApiOperation(value = "上传文件")

    @PostMapping("/Upload")

    public Result Upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        String savename = UUID.randomUUID().toString();
  String MasterID  =  request.getParameter("MasterID");
        String fileName = file.getOriginalFilename();
        String fileExtension = "." + FileUtil.getExtensionName(fileName);
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = "/Users/BoBo/AnshareSpringBootAdmin/src/main/UploadFiles/";
        File dest = new File(filePath + savename + fileExtension);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }
        System.out.println(filePath);
        try {

            Affix temp = new Affix();
            temp.setFilename(fileName);
            temp.setFileextension(fileExtension);
            temp.setMasterid(MasterID);
            temp.setSavename(savename + fileExtension);

            affixService.save(temp, true);
            return ResultGenerator.genSuccessResult("上传成功");

        } catch (Exception e) {
            // TODO: handle exception
            return ResultGenerator.genFailResult("上传失败");

        }
        //返回json
    }
    @ApiOperation(value = "下载文件")

    @GetMapping("/download")
    public Result Download(@RequestParam("AffixID") String AffixID, HttpServletResponse response) throws UnsupportedEncodingException {

        if (AffixID != "") {
            //设置文件路径
            String filePath = "/Users/BoBo/AnshareSpringBootAdmin/src/main/UploadFiles/";

            Affix temp = affixService.findById(AffixID);

            File file = new File(filePath + temp.getSavename());
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/octet-stream");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment; filename=" +
                                URLEncoder.encode(temp.getFilename(),"UTF-8")


                );
                response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.addHeader("Pragma", "no-cache");
                response.addHeader("Expires", "0");
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return ResultGenerator.genSuccessResult("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            return ResultGenerator.genSuccessResult("下载失败");
        } else
            return ResultGenerator.genSuccessResult("下载失败");


    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer pageNumber,
                       @RequestParam(defaultValue = "0") Integer pageSize,
                       @RequestParam(defaultValue = "0") String MasterID)
    {
        PageHelper.startPage(pageNumber, pageSize);
        Condition condition = new Condition(Person.class);

        Example.Criteria criteria  = condition.createCriteria();


        criteria.andEqualTo("MasterID", MasterID);




        List<Affix> list = affixService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}