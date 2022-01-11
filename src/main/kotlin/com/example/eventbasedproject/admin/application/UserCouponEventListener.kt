package com.example.eventbasedproject.admin.application

import com.example.eventbasedproject.user.event.UserCouponEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UserCouponEventListener {
    @EventListener
    fun onApplicationEvent(event: UserCouponEvent) {
        logger.info("쿠폰 등록 완료 : ${event.email}")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserCouponEventListener::class.java)
    }
}