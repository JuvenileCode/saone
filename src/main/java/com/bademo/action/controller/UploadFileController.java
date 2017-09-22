package com.bademo.action.controller;

import com.bademo.action.bean.UserTest;
import com.bademo.action.service.UploadFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Created by
 * :upload test
 * @author Bin.l
 * @date 2017/9/22 21:51
 */

@Controller
@RequestMapping("/upload")
public class UploadFileController {

    @Resource
    UploadFileService service;

    @ResponseBody
    @PostMapping("/file")
    @ApiOperation(value = "File 上传接口", httpMethod = "POST", response = Boolean.class)
    @ApiImplicitParam(name = "files", value = "files", required = true, dataType = "formData")
    public Object addFile(UserTest user, @RequestParam("files") MultipartFile[] files) {
        System.out.println(user.toString());
        service.addFile(files);
        return true;
    }

}
