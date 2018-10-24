package im.zhaojun.exception;

import im.zhaojun.util.ResultBean;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler
    public ResultBean unknownAccount(UnknownAccountException e) {
        logger.error("账号不存在");
        return ResultBean.error(ResultBean.FAIL, "账号不存在");
    }

    @ExceptionHandler
    public ResultBean incorrectCredentials(IncorrectCredentialsException e) {
        logger.error("密码错误");
        return ResultBean.error(ResultBean.FAIL, "密码错误");
    }

    @ExceptionHandler
    public ResultBean lockedAccount(LockedAccountException e) {
        logger.error("账号已锁定");
        return ResultBean.error(ResultBean.FAIL, "账号已锁定");
    }

}