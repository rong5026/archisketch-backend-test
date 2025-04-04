package org.archisketchbackendtest.cylinder.controller

import org.archisketchbackendtest.cylinder.dto.response.CylinderResponse
import org.archisketchbackendtest.cylinder.service.CylinderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CylinderController (
    private val cylinderService: CylinderService
){

    @GetMapping("/cylinder")
    fun requestCylinderInfo(): ResponseEntity<CylinderResponse> {
        val response = cylinderService.getCylinderInfo()
        return ResponseEntity.ok(response)
    }
}