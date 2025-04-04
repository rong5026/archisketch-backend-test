package org.archisketchbackendtest.apartment.entity

import jakarta.persistence.*

@Entity
data class ApartmentComplex(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "apartmentComplex", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val addresses: List<ApartmentAddress> = emptyList(),

    @OneToMany(mappedBy = "apartmentComplex", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val unitInfos: List<ApartmentUnitInfo> = emptyList()
)
