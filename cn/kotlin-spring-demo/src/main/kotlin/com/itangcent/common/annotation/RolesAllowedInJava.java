package com.itangcent.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Java版本的角色权限注解
 * 用于标记需要特定角色权限才能访问的API或类
 *
 * @see RolesAllowedInKt Kotlin版本的对应注解
 */
@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface RolesAllowedInJava {

    /**
     * 所需的角色名称
     * @return 角色标识符
     */
    String value();

    /**
     * 是否开放访问
     * @return true表示不进行权限验证，false表示需要验证权限
     */
    boolean open();
}
