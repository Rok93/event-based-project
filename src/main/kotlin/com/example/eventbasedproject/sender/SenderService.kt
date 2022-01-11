package com.example.eventbasedproject.sender

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SenderService {
    fun sendEmail(email: String) {
        logger.info("환영 이메일 발송 성공 : $email")
    }

    fun sendSMS(email: String) {
        logger.info("환영 SMS 발송 성공: $email")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SenderService::class.java)
    }
}