package org.archisketchbackendtest.health

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HealthController {

    @GetMapping("/health")
    fun healthCheck(): String {
        return "1"
    }
}