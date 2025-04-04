package org.archisketchbackendtest.sigungu.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AccessLevel
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
@Table(name = "Sigungu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Sigungu(
    @Id
    @Column(name = "pid_loc_code")
    val pidLocCode: Long,

    @Column(name = "level", nullable = false)
    val level: Int,

    @Column(name = "depth1", nullable = false)
    val depth1: String,

    @Column(name = "depth2")
    val depth2: String = "none",

    @Column(name = "depth3")
    val depth3: String = "none",

    @Column(name = "lt_lng", nullable = false)
    val ltLng: Double,

    @Column(name = "lt_lat", nullable = false)
    val ltLat: Double,

    @Column(name = "rb_lng", nullable = false)
    val rbLng: Double,

    @Column(name = "rb_lat", nullable = false)
    val rbLat: Double,

    @Column(name = "date_creation", nullable = false)
    val dateCreation: LocalDateTime
)