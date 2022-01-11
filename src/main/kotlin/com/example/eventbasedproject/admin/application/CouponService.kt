package com.example.eventbasedproject.admin.application

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CouponService {
    fun register(email: String) {
        logger.info("쿠폰 등록 완료 : $email")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CouponService::class.java)
    }
}