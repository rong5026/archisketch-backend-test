package org.archisketchbackendtest.apartment.service

import org.archisketchbackendtest.apartment.common.AddressType
import org.archisketchbackendtest.apartment.common.SortType
import org.archisketchbackendtest.apartment.entity.FloorPlan
import org.archisketchbackendtest.apartment.repository.ApartmentRepository
import org.hibernate.query.SortDirection
import org.springframework.stereotype.Service

@Service
class ApartmentService(
    private val apartmentRepository: ApartmentRepository
) {

    fun search(
        apartmentName: String?,
        address: String?,
        addressType: AddressType?,
        unitPrefix: String?,
        isExpanded: Boolean?,
        sortType: SortType?
    ): List<FloorPlan> {

        return when {
            // 단지명 기반 전체 도면 조회
            apartmentName != null -> apartmentRepository.findByApartmentName(apartmentName)

            // 도로명 or 지번 조회
            address != null && addressType != null -> apartmentRepository.findByAddress(address, addressType)

            // 평형대 필터 (112 → 112B, 112C)
            unitPrefix != null -> apartmentRepository.findByUnitPrefix(unitPrefix)

            // 기본형 or 확장형
            isExpanded != null -> apartmentRepository.findByIsExpanded(isExpanded)

            // 전용 면적 오름 차순, 내림 차순 정렬
            sortType == SortType.ASC -> apartmentRepository.findAllByOrderByUnitInfo_ExclusiveAreaAsc()
            sortType == SortType.DESC -> apartmentRepository.findAllByOrderByUnitInfo_ExclusiveAreaDesc()

            // 나머지는 전체 조ㅛ회
            else -> apartmentRepository.findAll()
        }
    }
}