package com.example.eventbasedproject.admin.application

import com.example.eventbasedproject.user.event.UserCouponEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class UserCouponEventListener : ApplicationListener<UserCouponEvent> {
    override fun onApplicationEvent(event: UserCouponEvent) {
        logger.info("쿠폰 등록 완료 : ${event.email}")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(UserCouponEventListener::class.java)
    }
}