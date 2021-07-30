package com.mzk.springsecuritydemo.controller;

import cn.hutool.captcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author miaozhenkai
 * @version 2021-07-13  17:53
 */
@Slf4j
@RestController
public class VerifyCodeController {
    @Autowired
    GifCaptcha gifCaptcha;

    @GetMapping("/code")
    public void getVerifyCode(HttpServletResponse response, HttpSession session) {
        response.setContentType(MediaType.IMAGE_GIF_VALUE);
        //生成验证码
        gifCaptcha.createCode();
        String verifyCode = gifCaptcha.getCode();
        session.setAttribute("verify_code", verifyCode);
        //输出code
        log.info("verifyCode:{}", verifyCode);
        try (ServletOutputStream out = response.getOutputStream()) {
            //图形验证码写出，可以写出到文件，也可以写出到流
            gifCaptcha.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}