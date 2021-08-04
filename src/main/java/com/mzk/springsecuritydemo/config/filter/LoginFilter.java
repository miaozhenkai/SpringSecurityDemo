package com.mzk.springsecuritydemo.config.filter;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mzk.springsecuritydemo.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author miaozhenkai
 * @version 2021-07-05  11:55
 */
@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println(request.getSession().getId());
        if (!HttpMethod.POST.toString().equals(request.getMethod()) || !request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());

        }
        Map<String, String> loginData = new HashMap<>();

        try {
            loginData = new ObjectMapper().readValue(request.getInputStream(), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        //验证码校验
        checkCode(request, loginData);

        //request.setAttribute("code", loginData.get("code"));
        String username = loginData.get(getUsernameParameter());
        String password = loginData.get(getPasswordParameter());
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 验证码校验
     *
     * @param request
     * @param loginData
     */
    private void checkCode(HttpServletRequest request, Map<String, String> loginData) {
        String sessionVerifyCode = (String) request.getSession().getAttribute(Const.SESSION_VERIFY_CODE);
        String code = loginData.get("code");
        if (!StringUtils.hasLength(code) || !StringUtils.hasLength(sessionVerifyCode)) {
            //验证码不正确
            throw new AuthenticationServiceException("验证码获取异常");
        }
        code = code.replace('o', '0').replace('O', '0');
        sessionVerifyCode = sessionVerifyCode.replace('o', '0').replace('O', '0');
        if (!sessionVerifyCode.equalsIgnoreCase(code)) {
            throw new AuthenticationServiceException("验证码不正确");
        }
    }


}
