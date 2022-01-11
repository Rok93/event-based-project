package com.example.eventbasedproject.sender.application

import com.example.eventbasedproject.user.event.UserSenderEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class UserSenderEventListener : ApplicationListener<UserSenderEvent> {
    override fun onApplicationEvent(event: UserSenderEvent) {
        logger.info("환영 이메일 발송 성공 : ${event.email}")
        logger.info("환영 SMS 발송 성공: ${event.phoneNumber}")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserSenderEventListener::class.java)
    }
}