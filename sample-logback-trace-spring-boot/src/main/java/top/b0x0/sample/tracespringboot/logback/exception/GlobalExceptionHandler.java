package top.b0x0.sample.tracespringboot.logback.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.b0x0.sample.tracespringboot.logback.common.ResultVo;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author tanglinghan Created By 2022-06-30 9:46
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常统一处理
     *
     * @param ex /
     * @return /
     */
    @ExceptionHandler(Exception.class)
    public ResultVo exceptionHandle(Exception ex) {
        log.error("exceptionHandle:{}", ex.getMessage(), ex);
        return ResultVo.error(ex.getMessage());
    }

    /**
     * 缺少请求参数异常
     *
     * @param ex HttpMessageNotReadableException
     * @return /
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVo handleHttpMessageNotReadableHandle(MissingServletRequestParameterException ex) {
        log.error("handleHttpMessageNotReadableHandle:{}", ex.getMessage());
        return ResultVo.error(ex.getMessage());
    }

    //  Validated 请求参数校验异常处理

    /**
     * <1> 处理 form data方式调用接口校验失败抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public ResultVo bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResultVo.error(joinByCommas(collect));
    }

    /**
     * <2> 处理 json 请求体调用接口校验失败抛出的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResultVo.error(joinByCommas(collect));
    }

    /**
     * <3> 处理单个参数校验失败抛出的异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVo constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return ResultVo.error(joinByCommas(collect));
    }

    private static String joinByCommas(Collection<String> strList) {
        if (CollectionUtils.isEmpty(strList)) {
            return "";
        }
        return String.join(",", strList);
    }

    private HashMap<String, Object> getMap() {
        return new HashMap<>(4);
    }

    private void putFlag(Map<String, Object> map, String flag) {
        map.put("isFlag", flag);
    }

    private void putFlagN(Map<String, Object> map) {
        map.put("isFlag", "N");
    }

    private void putFlagY(Map<String, Object> map) {
        map.put("isFlag", "Y");
    }

    private void putMsg(Map<String, Object> map, Object msg) {
        map.put("msg", msg);
    }
}
