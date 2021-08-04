package com.mzk.springsecuritydemo.config;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author miaozhenkai
 * @version 2021-07-13  17:55
 */
@Component
public class VerifyCodeConfig {
    @Bean
    GifCaptcha gifCaptcha() {
        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 4);
        //定义图形验证码的长和宽
        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(100, 40);
        gifCaptcha.setGenerator(randomGenerator);

        return gifCaptcha;


    }
}
