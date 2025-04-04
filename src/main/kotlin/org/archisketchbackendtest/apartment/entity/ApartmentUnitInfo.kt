package org.archisketchbackendtest.apartment.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class ApartmentUnitInfo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_complex_id", nullable = false)
    @JsonIgnore
    val apartmentComplex: ApartmentComplex,

    @Column(name = "exclusive_area", nullable = false)
    val exclusiveArea: Double,

    @Column(name = "supply_area", nullable = false)
    val supplyArea: Double,

    @Column(name = "unit_name", nullable = false)
    val unitName: String,

    @Column(name = "unit_type", nullable = false)
    val unitType: String,

    @OneToMany(mappedBy = "unitInfo", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val floorPlans: List<FloorPlan> = emptyList()
)