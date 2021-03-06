package com.mzk.springsecuritydemo.config.security;

/**
 * @author miaozhenkai
 * @version 2021-07-05  13:32
 */

import com.alibaba.fastjson.JSONObject;
import com.mzk.springsecuritydemo.config.filter.LoginFilter;
import com.mzk.springsecuritydemo.service.impl.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.PrintWriter;
import java.time.Duration;
import java.util.Collections;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userService;

    @Autowired
    MyWebAuthenticationDetailsSource myWebAuthenticationDetailsSource;

    //    @Autowired
//    DataSource dataSource;
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/code").permitAll()

                .anyRequest().authenticated()
                .and()
                //??????
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .csrf().disable()
                .sessionManagement()
                .maximumSessions(1);//????????????????????????
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    MyAuthenticationProvider myAuthenticationProvider() {
        MyAuthenticationProvider myAuthenticationProvider = new MyAuthenticationProvider();
        myAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        myAuthenticationProvider.setUserDetailsService(userDetailsService());
        return myAuthenticationProvider;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        ProviderManager manager = new ProviderManager(Collections.singletonList(myAuthenticationProvider()));
        return manager;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("admin")
////                .password("123").roles("admin")
////                .and()
////                .withUser("user").password("123").roles("user");
//
//        auth.userDetailsService(userService);
//    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//        manager.setDataSource(dataSource);
//        if (!manager.userExists("admin")) {
//            manager.createUser(User.withUsername("admin").password("123").roles("admin").build());
//        }
//        if (!manager.userExists("user")) {
//            manager.createUser(User.withUsername("user").password("123").roles("user").build());
//        }
//        return manager;
        return userService;
    }

    /**
     * ????????????
     *
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setMaxAge(Duration.ofHours(1));
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("code", 200);
            jsonObject.put("msg", "success");
            jsonObject.put("data", Collections.singletonMap("token", "admin-token"));
            out.write(jsonObject.toJSONString());
                    out.flush();
                    out.close();
                }
        );
        loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();

                    String errorMessage;
                    if (exception instanceof LockedException) {
                        errorMessage = "????????????????????????????????????!" + exception.getMessage();
                    } else if (exception instanceof CredentialsExpiredException) {
                        errorMessage = "?????????????????????????????????!" + exception.getMessage();
                    } else if (exception instanceof AccountExpiredException) {
                        errorMessage = "?????????????????????????????????!" + exception.getMessage();
                    } else if (exception instanceof DisabledException) {
                        errorMessage = "????????????????????????????????????!" + exception.getMessage();
                    } else if (exception instanceof BadCredentialsException) {
                        errorMessage = "???????????????????????????????????????????????????!" + exception.getMessage();
                    } else if (exception instanceof AuthenticationServiceException) {
                        errorMessage = exception.getMessage();
                    } else {
                        errorMessage = "????????????" + exception.getMessage();
                    }
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("code", 500);
                    jsonObject.put("msg", errorMessage);
                    out.write(jsonObject.toJSONString());
                    out.flush();
                    out.close();
                    log.error(exception.getMessage(), exception);
                }
        );
        loginFilter.setAuthenticationManager(authenticationManager());
        loginFilter.setFilterProcessesUrl("/user/login");
        loginFilter.setAuthenticationDetailsSource(myWebAuthenticationDetailsSource);
        return loginFilter;
    }


    /**
     * ????????????
     *
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }
}
