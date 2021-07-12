//package com.mzk.springsecuritydemo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * CorsConfig
// * クロスドメインをリクエストする
// *
// * @author PSDCD
// * @version 1.0.0
// */
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    private static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};
//
//    /**
//     * 現在のサイトで要求されているすべてのアドレスは、クロスドメインアクセスをサポートしています。
//     *
//     * @param registry CorsRegistry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }
//
//}
//
