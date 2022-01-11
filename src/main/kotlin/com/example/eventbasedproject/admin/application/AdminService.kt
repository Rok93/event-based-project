package com.example.eventbasedproject.admin.application

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AdminService {
    fun alarm(userName: String) {
        logger.info("어드민 서비스: $userName 님이 가입했습니다.")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AdminService::class.java)
    }
}