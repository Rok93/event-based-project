package com.example.eventbasedproject.user.ui

import com.example.eventbasedproject.user.application.UserRequest
import com.example.eventbasedproject.user.application.UserResponse
import com.example.eventbasedproject.user.application.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
        private val userService: UserService
) {
    @PostMapping("/user")
    fun create(@RequestBody userRequest: UserRequest): ResponseEntity<Unit> {
        userService.create(userRequest)
        return ResponseEntity.ok(Unit)
    }

    @GetMapping("/user/{email}")
    fun get(@PathVariable("email") email: String): ResponseEntity<UserResponse> {
        val response = userService.get(email)
        return ResponseEntity.ok(response)
    }
}