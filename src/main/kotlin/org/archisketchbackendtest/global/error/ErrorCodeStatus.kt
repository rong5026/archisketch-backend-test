package org.archisketchbackendtest.global.error

import org.springframework.http.HttpStatus

interface ErrorCodeStatus {
    val httpStatus: HttpStatus
    val message: String
}