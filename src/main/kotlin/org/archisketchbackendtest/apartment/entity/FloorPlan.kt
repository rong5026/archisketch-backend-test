package org.archisketchbackendtest.apartment.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class FloorPlan(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_info_id", nullable = false)
    @JsonIgnore
    val unitInfo: ApartmentUnitInfo,

    @Column(name = "image_url", nullable = false)
    val imageUrl: String,

    @Column(name = "is_expanded", nullable = false)
    val isExpanded: Boolean
)