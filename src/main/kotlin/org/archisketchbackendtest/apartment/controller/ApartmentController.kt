package org.archisketchbackendtest.apartment.controller

import org.archisketchbackendtest.apartment.common.AddressType
import org.archisketchbackendtest.apartment.common.SortType
import org.archisketchbackendtest.apartment.entity.FloorPlan
import org.archisketchbackendtest.apartment.service.ApartmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ApartmentController(
    private val apartmentService: ApartmentService
) {

    @GetMapping("/floorplan")
    fun search(
        @RequestParam(required = false) apartmentName: String?,
        @RequestParam(required = false) address: String?,
        @RequestParam(required = false) addressType: AddressType?,
        @RequestParam(required = false) unitPrefix: String?,
        @RequestParam(required = false) isExpanded: Boolean?,
        @RequestParam(required = false) sortType: SortType?
    ): List<FloorPlan> {
        return apartmentService.search(
            apartmentName,
            address,
            addressType,
            unitPrefix,
            isExpanded,
            sortType
        )
    }
}