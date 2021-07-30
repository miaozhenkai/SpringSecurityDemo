package com.mzk.springsecuritydemo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author miaozhenkai
 * @version 2021-07-14  09:59
 */
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {

        System.out.println((MyWebAuthenticationDetails)authentication.getDetails());

        System.out.println(((MyWebAuthenticationDetails) authentication.getDetails()).getExternalId());


        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String code = (String) req.getAttribute("code");
        String verify_code = (String) req.getSession().getAttribute("verify_code");

        System.out.println(verify_code);
        if (code == null || !code.equals(verify_code)) {
            throw new AuthenticationServiceException("验证码错误");
        }
            super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
