package org.archisketchbackendtest.user.dto.request

data class CreateUserRequest(
    val name: String,
    val password: String
)