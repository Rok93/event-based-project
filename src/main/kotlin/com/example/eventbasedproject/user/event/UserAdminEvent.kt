package com.example.eventbasedproject.user.event

import org.springframework.context.ApplicationEvent

class UserAdminEvent(
    source: Any,
    val userName: String
) : ApplicationEvent(source)