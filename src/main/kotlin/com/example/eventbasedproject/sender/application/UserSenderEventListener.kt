package com.example.eventbasedproject.sender.application

import com.example.eventbasedproject.user.event.UserSenderEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class UserSenderEventListener {
    @EventListener
    @Async
    fun onApplicationEvent(event: UserSenderEvent) {
        logger.info("환영 이메일 발송 성공 : ${event.email}")
    }

    @EventListener
    @Async
    fun handleSMS(event: UserSenderEvent) {
        logger.info("환영 SMS 발송 성공: ${event.phoneNumber}")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserSenderEventListener::class.java)
    }
}