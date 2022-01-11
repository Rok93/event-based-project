package com.example.eventbasedproject.user.event

import org.springframework.context.ApplicationEvent

class UserSenderEvent(
    source: Any,
    val email: String,
    val phoneNumber: String
)