package com.belle.springsecurityjwt.aop;


import com.belle.springsecurityjwt.model.dto.ResultUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理异常
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);

    /*@ExceptionHandler(UserNotExistExcepetion.class)
    @ResponseBody
    public ResponseEntity handleControllerException(HttpServletRequest request, UserNotExistExcepetion ex) {

        logger.warn(ex.getMessage(), ex);

        return new ResponseEntity (new ResultUtil (ex.getErrorCode(), ex.getErrorMsg(), null), HttpStatus.OK);
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handleControllerRuntimeException(HttpServletRequest request, Throwable ex) {
        String errorMsg = ex.getMessage();
        logger.error(errorMsg, ex);

        return new ResponseEntity (new ResultUtil(500, ex.getMessage(), null), HttpStatus.OK);
    }

}
