package com.example.eventbasedproject.admin.application

import com.example.eventbasedproject.user.event.UserAdminEvent
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class AdminEventListener{
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun onApplicationEvent(event: UserAdminEvent) {
        logger.info("어드민 서비스: ${event.userName} 님이 가입했습니다.")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AdminEventListener::class.java)
    }
}
