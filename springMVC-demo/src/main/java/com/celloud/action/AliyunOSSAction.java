package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aliyun")
public class AliyunOSSAction {
    @RequestMapping("sdk")
    public String sdk() {
        return "aliyun/oss-sdk";
    }

    @RequestMapping("plupload")
    public String plupload() {
        return "aliyun/oss-plupload";
    }
}
