package com.example.eventbasedproject.user.repository

import com.example.eventbasedproject.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByEmail(email: String): User?
}