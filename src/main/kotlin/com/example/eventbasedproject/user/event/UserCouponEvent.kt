package com.example.eventbasedproject.user.event

import org.springframework.context.ApplicationEvent

class UserCouponEvent(
    source: Any,
    val email: String
)