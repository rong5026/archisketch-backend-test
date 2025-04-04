package org.archisketchbackendtest.global.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            error = e.errorCode.javaClass.simpleName,
            status = e.errorCode.httpStatus.value(),
            message = e.errorCode.message
        )
        return ResponseEntity.status(e.errorCode.httpStatus).body(errorResponse)
    }
}