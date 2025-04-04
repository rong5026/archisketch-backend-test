package org.archisketchbackendtest.cylinder.common.error

import org.archisketchbackendtest.global.error.CustomException

class CylinderException(
    errorCode: CylinderErrorCode
):CustomException(errorCode) {

}