package org.archisketchbackendtest.user.dto.response

import org.archisketchbackendtest.user.entity.User

data class CreateUserResponse(
    val user: User,
    val message: String
) {
    companion object {
        fun from(user: User): CreateUserResponse {
            return CreateUserResponse(user, "유저가 성공적으로 생성되었습니다.")
        }
    }
}