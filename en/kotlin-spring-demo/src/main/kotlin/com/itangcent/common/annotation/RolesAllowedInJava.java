package com.itangcent.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Role-based Permission Annotation for Java
 * Used to mark APIs or classes that require specific role permissions for access
 *
 * @see RolesAllowedInKt Corresponding annotation in Kotlin
 */
@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface RolesAllowedInJava {

    /**
     * Required role name
     * @return Role identifier
     */
    String value();

    /**
     * Whether to allow open access
     * @return true means no permission verification, false means permission verification required
     */
    boolean open();
}
