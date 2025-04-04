package org.archisketchbackendtest.sigungu.service

import org.archisketchbackendtest.sigungu.entity.Sigungu
import org.archisketchbackendtest.sigungu.repository.SigunguRepository
import org.springframework.stereotype.Service

@Service
class SigunguService(
    private val sigunguRepository: SigunguRepository
) {
    fun getSigunguByPidLocCode(pidLocCode: Long): List<Sigungu> {
        return sigunguRepository.findByPidLocCode(pidLocCode)
    }
}