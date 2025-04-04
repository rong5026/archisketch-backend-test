package org.archisketchbackendtest.user.service

import jakarta.transaction.Transactional
import org.archisketchbackendtest.user.dto.request.CreateUserRequest
import org.archisketchbackendtest.user.entity.User
import org.archisketchbackendtest.user.respository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUser(request: CreateUserRequest): User {
        val user = User.create(request.name, request.password)
        return userRepository.save(user)
    }
}