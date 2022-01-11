package com.example.eventbasedproject.user.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User(
        @Column
        val name: String,

        @Column(unique = true)
        val email: String,

        @Column
        val phoneNumber: String,

        @CreationTimestamp
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        val updatedAt: LocalDateTime = LocalDateTime.now(),
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0L
)