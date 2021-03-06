package com.anshare.project.controller.file;

import com.anshare.project.core.ResultCore.Result;
import com.anshare.project.core.ResultCore.ResultGenerator;
import com.anshare.project.core.Util.FileUtil;
import com.anshare.project.model.file.Affix;
import com.anshare.project.service.inter.file.AffixService;
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



    @ApiOperation(value = "上传文件")

    @PostMapping("/upload")

    public Result Upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        String savename = UUID.randomUUID().toString();
        String MasterID = request.getParameter("MasterID");
        String Type = request.getParameter("Type");

        String fileName = file.getOriginalFilename();
        String fileExtension = "." + FileUtil.getExtensionName(fileName);
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
        File dest = new File(uploadDir + savename + fileExtension);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
        }
        System.out.println(uploadDir);
        try {

            Affix temp = new Affix();
            temp.setFilename(fileName);
            temp.setFileextension(fileExtension);
            temp.setMasterid(MasterID);
            temp.setSavename(savename + fileExtension);
            temp.setType(Type);

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
                                URLEncoder.encode(temp.getFilename(), "UTF-8")

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
                       @RequestParam(defaultValue = "") String MasterID,
     @RequestParam(defaultValue = "") String Type) {
        PageHelper.startPage(pageNumber, pageSize);
        Condition condition = new Condition(Affix.class);

        Example.Criteria criteria = condition.createCriteria();

        criteria.andEqualTo("type", Type);

        criteria.andEqualTo("masterid", MasterID);
        criteria.andEqualTo("isdeleted", false);


        List<Affix> list = affixService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @GetMapping("/delete")
    public Result Delete(@RequestParam("AffixID") String AffixID, HttpServletResponse response) throws UnsupportedEncodingException {

            affixService.deleteById(AffixID);
            return ResultGenerator.genSuccessResult("删除成功");


    }





}