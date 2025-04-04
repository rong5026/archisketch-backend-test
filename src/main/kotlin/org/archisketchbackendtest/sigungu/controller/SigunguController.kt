package org.archisketchbackendtest.sigungu.controller

import org.archisketchbackendtest.sigungu.entity.Sigungu
import org.archisketchbackendtest.sigungu.service.SigunguService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SigunguController(
    private val sigunguService: SigunguService
) {

    @GetMapping("/sigungu")
    fun getSigungu(@RequestParam pid_loc_code: Long): ResponseEntity<List<Sigungu>> {
        return ResponseEntity.ok(sigunguService.getSigunguByPidLocCode(pid_loc_code))
    }
}
