package indi.fanyun.bullscheduling.aop;

import cn.hutool.core.util.StrUtil;
import indi.fanyun.bullscheduling.common.dto.BaseRequestDTO;
import indi.fanyun.bullscheduling.common.exceptions.MyBizException;
import indi.fanyun.bullscheduling.common.exceptions.MyPermissionDeniedException;
import indi.fanyun.bullscheduling.facade.info.EmployeeInfo;
import indi.fanyun.bullscheduling.session.EmployeeLocalSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tshk
 * @date 2021-01-18 17:21
 */
@Aspect
@Component
public class OperateLoginAspect {

    @Resource
    private EmployeeLocalSession employeeLocalSession;
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(indi.fanyun.bullscheduling.common.annotation.OperatorAuthentication)")
    public void OperateLogin(){}


    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("OperateLogin()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String token = request.getHeader("X-TOKEN");
        if(StrUtil.isBlank(token)){
            throw new MyPermissionDeniedException("token不得为空");
        }
        EmployeeInfo employeeInfo = employeeLocalSession.get(token);
        if(employeeInfo==null){
            throw new MyPermissionDeniedException("token已过期");
        }
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if(arg instanceof BaseRequestDTO){
                BaseRequestDTO baseRequestDTO= (BaseRequestDTO) arg;
                baseRequestDTO.setOperateId(employeeInfo.getAccount());
                baseRequestDTO.setOperateName(employeeInfo.getName());
            }
        }
        res =  joinPoint.proceed();
        time = System.currentTimeMillis() - time;
        return res;
    }




//    @Before("OperateLogin()")
//    public void doBeforeAdvice(JoinPoint joinPoint){
//
//    }
//
//    /**
//     * 处理完请求，返回内容
//     * @param ret
//     */
//    @AfterReturning(returning = "ret", pointcut = "OperateLogin()")
//    public void doAfterReturning(Object ret) {
////        System.out.println("方法的返回值 : " + ret);
//    }
//
//    /**
//     * 后置异常通知
//     */
//    @AfterThrowing("OperateLogin()")
//    public void throwss(JoinPoint jp){
////        System.out.println("方法异常时执行.....");
//    }
//
//
//    /**
//     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//     */
//    @After("OperateLogin()")
//    public void after(JoinPoint jp){
////        System.out.println("方法最后执行.....");
//    }

}