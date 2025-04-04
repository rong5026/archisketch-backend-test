package org.archisketchbackendtest.global.error

data class ErrorResponse(
    val error: String,
    val status: Int,
    val message: String
)