package com.eastcom.sc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eastcom.gt.common.core.constant.GlobalBusinessCodeEnum;
import com.eastcom.gt.common.core.exception.BusinessException;
import com.eastcom.gt.common.core.wrapper.JsonResponse;
import com.eastcom.gt.common.core.wrapper.JsonResponseBuilder;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Resource
    private TaskExecutor taskExecutor;

    /**
     * 参数非法异常.
     *
     * @param e
     * @return JsonResponse
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JsonResponse illegalArgumentException(IllegalArgumentException e) {
        logger.error("参数非法异常={}", e.getMessage(), e);
        return JsonResponseBuilder.build(GlobalBusinessCodeEnum.ILLEGAL_ARGUMENT.code(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JsonResponse illegalArgumentException(MethodArgumentNotValidException e) {
        logger.error("参数非法异常={}", e.getMessage(), e);
        StringBuffer msg = new StringBuffer();
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for (FieldError fieldError : list) {
                msg.append(fieldError.getDefaultMessage() + ";");
            }
        }
        return JsonResponseBuilder.build(GlobalBusinessCodeEnum.ILLEGAL_ARGUMENT.code(), msg.toString());
    }


    /**
     * 业务异常.
     *
     * @param e
     * @return JsonResponse
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JsonResponse businessException(BusinessException e) {
        logger.error("业务异常={}", e.getMessage(), e);
        return JsonResponseBuilder.build(!"0".equals(e.getCode()) ? GlobalBusinessCodeEnum.SERVICE_EXCEPTION.code() : e.getCode(),
                e.getMessage());
    }


    /**
     * 全局异常.
     *
     * @param e
     * @return JsonResponse
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JsonResponse exception(Exception e) {
        logger.info("全局异常信息 ex={}", e.getMessage(), e);
        taskExecutor.execute(() -> {

        });
        return JsonResponseBuilder.error();
    }
}
