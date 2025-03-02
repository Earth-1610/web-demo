package com.itangcent.common.annotation

/**
 * Role-based Permission Annotation for Kotlin
 * Used to mark APIs or classes that require specific role permissions for access
 *
 * @property role Required role name
 * @property open Whether to allow open access, true means no permission verification
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS)
@MustBeDocumented
annotation class RolesAllowedInKt(
        val role: String,
        val open: Boolean
)