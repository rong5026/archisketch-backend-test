package org.archisketchbackendtest.user.controller

import org.archisketchbackendtest.user.dto.request.CreateUserRequest
import org.archisketchbackendtest.user.dto.response.CreateUserResponse
import org.archisketchbackendtest.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<CreateUserResponse> {
        val newUser = userService.createUser(request)
        return ResponseEntity.ok(CreateUserResponse.from(newUser))
    }
}