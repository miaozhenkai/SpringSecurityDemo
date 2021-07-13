//package com.mzk.springsecuritydemo.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Scope;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 自定義異常クラス
// * 全ソースにシステム異常とRedis異常が発生した場合、このクラスを実施する
// *
// * @author PSDCD
// * @version 1.0.0
// */
//@Slf4j
//@ControllerAdvice
//@Scope("prototype")
//public class CustomerExceptionHandler {
//
//    /**
//     * システム異常
//     *
//     * @param request HTTPサブレートリクエスト
//     * @param e       異常情報
//     * @return 自定義異常情報
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object handleException(HttpServletRequest request, Exception e) {
//        log.info("handleException捕获异常");
//        log.error(e.getMessage(), e);
//
//
//        return "errObj";
//    }
//
//
//}
