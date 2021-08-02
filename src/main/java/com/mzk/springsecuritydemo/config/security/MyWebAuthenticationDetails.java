package com.mzk.springsecuritydemo.config.security;

import lombok.Getter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Authentication中用户的详细信息
 *
 *
 * @author miaozhenkai
 * @version 2021-07-14  11:05
 */
@Getter
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    //一个自定义属性
    private final String externalId;
    /**
     * 验证code是否通过
     */
    //private boolean verifyCodePassed;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        //verifyCodePassed = false;
        externalId = "123456";

//        String code = (String) request.getAttribute("code");
//        String verify_code = (String) request.getSession().getAttribute("verify_code");
//
//        //System.out.println(verify_code);
//        if (code != null && code.equals(verify_code)) {
//            verifyCodePassed = true;
//        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" [");
        sb.append("RemoteIpAddress=").append(super.getRemoteAddress()).append(", ");
        sb.append("SessionId=").append(super.getSessionId()).append(", ");
        //sb.append("verifyCodePassed=").append(this.isVerifyCodePassed()).append(", ");
        sb.append("自定义。。=").append(this.externalId).append("]");
        return sb.toString();
    }


}