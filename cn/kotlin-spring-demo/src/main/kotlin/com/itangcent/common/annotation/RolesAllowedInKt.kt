package com.itangcent.common.annotation

/**
 * Kotlin版本的角色权限注解
 * 用于标记需要特定角色权限才能访问的API或类
 *
 * @property role 所需的角色名称
 * @property open 是否开放访问，为true时表示不进行权限验证
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS)
@MustBeDocumented
annotation class RolesAllowedInKt(
        val role: String,
        val open: Boolean
)