package org.archisketchbackendtest.user.entity

import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class User private constructor(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val password: String
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?= null

    companion object {
        fun create(name: String, password: String): User {
            return User(name, password)
        }
    }
}