package com.itangcent.common.model

/**
 * Test Log Bean Class
 * Used to demonstrate @Transient annotation usage
 * Contains examples of handling sensitive information
 */
data class TestLogBean(
    /**
     * Username
     * Normal serialization and persistence
     */
    var userName: String? = null,

    /**
     * Password
     * Marked with @Transient, not included in serialization
     * Used to protect sensitive information
     */
    @Transient
    var password: String? = null
) 