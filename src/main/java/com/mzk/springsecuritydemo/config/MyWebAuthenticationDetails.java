package com.mzk.springsecuritydemo.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author miaozhenkai
 * @version 2021-07-14  11:05
 */
@Getter
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {


    private String externalId;

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        externalId = "123456";
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" [");
        sb.append("RemoteIpAddress=").append(super.getRemoteAddress()).append(", ");
        sb.append("SessionId=").append(super.getSessionId()).append(", ");
        sb.append("自定义。。=").append(this.externalId).append("]");
        return sb.toString();
    }


}