package com.example.eventbasedproject.admin.application

import com.example.eventbasedproject.user.event.UserAdminEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class AdminEventListener : ApplicationListener<UserAdminEvent> {
    override fun onApplicationEvent(event: UserAdminEvent) {
        logger.info("어드민 서비스: ${event.userName} 님이 가입했습니다.")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AdminEventListener::class.java)
    }
}
