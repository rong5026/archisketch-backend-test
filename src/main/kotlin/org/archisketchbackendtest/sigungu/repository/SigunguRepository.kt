package org.archisketchbackendtest.sigungu.repository

import org.archisketchbackendtest.sigungu.entity.Sigungu
import org.springframework.data.jpa.repository.JpaRepository

interface SigunguRepository : JpaRepository<Sigungu, Long> {
    fun findByPidLocCode(pidLocCode: Long): List<Sigungu>
}