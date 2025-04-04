package org.archisketchbackendtest.user.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@Getter
abstract class BaseTimeEntity {
    @CreatedDate
    @Column(updatable = false, nullable = false)
    lateinit var createdAt: LocalDateTime
}