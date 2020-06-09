package com.changgou.controller;

import com.changgou.File.FastDFSFile;
import com.changgou.Util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import org.csource.common.MyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FileUploadController {

    @PostMapping
    public Result upload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, MyException {
        FastDFSFile fastDFSFile = new FastDFSFile(
                multipartFile.getOriginalFilename(),
                multipartFile.getBytes(),
                StringUtils.getFilenameExtension(multipartFile.getOriginalFilename())
        );
        String[] uploads = FastDFSUtil.upload(fastDFSFile);
        String url = "http://192.168.0.108:8080/"+uploads[0]+"/"+uploads[1];
        return new Result(true, StatusCode.OK,"upload file successfully",url);

    }


}
