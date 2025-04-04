package org.archisketchbackendtest.global.error

open class CustomException(
    val errorCode: ErrorCodeStatus
) : RuntimeException(errorCode.message) {

}