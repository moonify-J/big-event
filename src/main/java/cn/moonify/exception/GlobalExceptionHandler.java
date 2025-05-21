package cn.moonify.exception;

import cn.moonify.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 全局异常处理
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) // 捕获该类型的异常
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作错误");
    }
}
