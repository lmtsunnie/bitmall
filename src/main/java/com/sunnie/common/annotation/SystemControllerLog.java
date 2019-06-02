package com.sunnie.common.annotation;

import java.lang.annotation.*;

/**
 * 系统级别Controller层自定义注解，拦截Controller
 * @author Sunnie
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Documented
public @interface SystemControllerLog {
        String description() default "";
}
