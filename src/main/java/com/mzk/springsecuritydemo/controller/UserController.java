package com.mzk.springsecuritydemo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author miaozhenkai
 * @version 2021-07-05  13:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public Object userInfo() {
        JSONObject result = new JSONObject();


        JSONObject data = new JSONObject();
        data.put("roles", Collections.singletonList("admin"));

        data.put("introduction", "I am a super administrator");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "Super Admin");
        result.put("data", data);
        result.put("code", 200);
        return result;
    }

}
