package com.web.hzxy.DTO;

import lombok.Data;

@Data
public class ImgResultDto<T> {
    private int  errno;//错误代码

    private String[] data;//存放数据
}
