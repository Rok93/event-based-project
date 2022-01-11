package com.example.eventbasedproject.user.application

data class UserRequest(
        val name: String,
        val email: String,
        val phoneNumber: String
)

data class UserResponse(
        val name: String,
        val email: String,
        val phoneNumber: String
)