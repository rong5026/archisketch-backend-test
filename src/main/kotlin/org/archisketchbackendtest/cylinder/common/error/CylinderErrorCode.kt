package org.archisketchbackendtest.cylinder.common.error

import org.archisketchbackendtest.global.error.ErrorCodeStatus
import org.springframework.http.HttpStatus

enum class CylinderErrorCode(
    override val httpStatus: HttpStatus,
    override val message: String
): ErrorCodeStatus {

    JSON_PARSE_ERROR(HttpStatus.BAD_REQUEST, "응답값 파싱 실패"),
    MISSING_VALUE(HttpStatus.BAD_REQUEST, "필수 필드가 없습니다."),
    EMPTY_RESPONSE(HttpStatus.NO_CONTENT, "Cylinder 응답값이 비어있습니다.")
}