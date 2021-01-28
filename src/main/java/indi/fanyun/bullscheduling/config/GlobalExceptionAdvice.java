package indi.fanyun.bullscheduling.config;

import indi.fanyun.bullscheduling.common.dto.BaseResponseDTO;
import indi.fanyun.bullscheduling.common.exceptions.MyBizException;
import indi.fanyun.bullscheduling.common.exceptions.MyPermissionDeniedException;
import indi.fanyun.bullscheduling.common.types.ErrorTypes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tshk
 * @date 2021-01-12 15:37
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 处理未知异常
     * @param req
     * @param ex
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponseDTO handleHttpException(HttpServletRequest req, Exception ex){
        BaseResponseDTO baseResponseDTO=new BaseResponseDTO();
        baseResponseDTO.fail(ErrorTypes.SYSTEM_ERROR);
        log.error(req.getRequestURI());
        ex.printStackTrace();
        return baseResponseDTO;
    }

    /**
     * 处理已知异常
     * @param req
     * @param ex
     */
    @ExceptionHandler(value = MyBizException.class)
    @ResponseBody
    public BaseResponseDTO handleHttpException(HttpServletRequest req, MyBizException ex){
        BaseResponseDTO baseResponseDTO=new BaseResponseDTO();
        baseResponseDTO.fail(ErrorTypes.BIZ_ERROR,ex.getMessage());
        ex.printStackTrace();
        return baseResponseDTO;
    }
    /**
     * 处理已知异常
     * @param req
     * @param ex
     */
    @ExceptionHandler(value = MyPermissionDeniedException.class)
    @ResponseBody
    public BaseResponseDTO handleMyPermissionDeniedHttpException(HttpServletRequest req, HttpServletResponse rep, MyPermissionDeniedException ex){
        BaseResponseDTO baseResponseDTO=new BaseResponseDTO();
        baseResponseDTO.fail(ErrorTypes.PERMISSION_DENIED,ex.getMessage());
        ex.printStackTrace();
        return baseResponseDTO;
    }
}
