package com.web.hzxy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class uploadController {
    /**
     * 文件上传
     *
     *
     * @param editorFiles wangEditor
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile[] editorFiles, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        // wangEditor 上传
        if (editorFiles != null && editorFiles.length > 0) {
            List<String> fileNames = new ArrayList<>();

            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile, request));
            }

            result.put("errno", 0);
            result.put("data", fileNames);
            System.out.printf("");
        }

        return result;
    }

    /**
     * 将图片写入指定目录
     *
     * @param multipartFile
     * @param request
     * @return 返回文件完整路径
     */
    private String writeFile(MultipartFile multipartFile, HttpServletRequest request) {
        // 获取文件后缀
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String path= Class.class.getClass().getResource("/").getPath();


        path= path+"static";

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(file, UUID.randomUUID() + fileSuffix);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回文件完整路径
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+'/';
        System.out.println("serverpath="+serverPath);
        System.out.println("path="+path);
        return serverPath +"static/"+file.getName();
    }
}
