package indi.fanyun.bullscheduling.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author tshk
 * @date 2021-01-18 17:18
 */
@Target( ElementType.METHOD )
public @interface OperatorAuthentication {
    /**
     * 是否打印参数
     * @return
     */
    boolean logParam() default true;

    /**
     * 是否必须登录
     * @return
     */
    boolean login() default true;
}
