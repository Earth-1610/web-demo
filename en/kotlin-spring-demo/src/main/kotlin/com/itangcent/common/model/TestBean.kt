package com.itangcent.common.model

import com.fasterxml.jackson.annotation.JsonView

/**
 * Test Bean Class
 * Used to demonstrate Jackson's @JsonView annotation functionality
 * Can display different fields based on different views
 */
data class TestBean(
    /**
     * Field visible in View A
     * Only serialized in ViewA view
     */
    @JsonView(ViewA::class)
    var aaAaa: String? = null,

    /**
     * Field visible in View B
     * Only serialized in ViewB view
     */
    @JsonView(ViewB::class)
    var aaBbb: String? = null
) {
    /**
     * View A Marker Interface
     * Used with @JsonView annotation to mark fields visible in ViewA
     */
    interface ViewA

    /**
     * View B Marker Interface
     * Used with @JsonView annotation to mark fields visible in ViewB
     */
    interface ViewB
}