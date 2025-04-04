package org.archisketchbackendtest.apartment.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.archisketchbackendtest.apartment.common.AddressType

@Entity
data class ApartmentAddress(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_complex_id", nullable = false)
    @JsonIgnore
    val apartmentComplex: ApartmentComplex,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: AddressType,

    @Column(name = "address_name", nullable = false)
    val addressName: String
)