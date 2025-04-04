package org.archisketchbackendtest.apartment.repository

import org.archisketchbackendtest.apartment.common.AddressType
import org.archisketchbackendtest.apartment.entity.FloorPlan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface ApartmentRepository : JpaRepository<FloorPlan, Long> {

    // 단지명 기반 전체 도면 조회
    @Query("""
        SELECT f FROM FloorPlan f 
        JOIN f.unitInfo u 
        JOIN u.apartmentComplex ac 
        WHERE ac.name = :apartmentName
    """)
    fun findByApartmentName(@Param("apartmentName") apartmentName: String): List<FloorPlan>

    // 도로명 or 지번 조회
    @Query("""
        SELECT f FROM FloorPlan f
        JOIN f.unitInfo u
        JOIN u.apartmentComplex ac
        JOIN ac.addresses addr
        WHERE addr.addressName = :address AND addr.type = :type
    """)
    fun findByAddress(
        @Param("address") address: String,
        @Param("type") type: AddressType
    ): List<FloorPlan>

    // 전용 면적 오름 차순, 내림 차순 정렬
    fun findAllByOrderByUnitInfo_ExclusiveAreaAsc(): List<FloorPlan>
    fun findAllByOrderByUnitInfo_ExclusiveAreaDesc(): List<FloorPlan>

    // 기본형 or 확장형
    fun findByIsExpanded(isExpanded: Boolean): List<FloorPlan>

    // 평형대 필터 (112 → 112B, 112C)
    @Query("""
        SELECT f FROM FloorPlan f
        JOIN f.unitInfo u
        WHERE u.unitName LIKE CONCAT(:unitPrefix, '%')
    """)
    fun findByUnitPrefix(@Param("unitPrefix") unitPrefix: String): List<FloorPlan>
}