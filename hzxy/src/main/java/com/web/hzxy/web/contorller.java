package com.web.hzxy.web;

import com.web.hzxy.DTO.ImgResultDto;
import com.web.hzxy.entity.Content;
import com.web.hzxy.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class contorller {
    @Autowired
    private ContentService contentService;

    @GetMapping("/index1")

    private String index(){
        return "indexg";
    }

    @RequestMapping("save")
    @ResponseBody
    private int  save(Content content){
        int insert = contentService.insert(content);
        return insert;
    }


    @GetMapping("/record")
    public String record(){
        return "record";
    }





}
