package com.example.eventbasedproject.user.domain

import com.example.eventbasedproject.user.event.UserAdminEvent
import com.example.eventbasedproject.user.event.UserCouponEvent
import com.example.eventbasedproject.user.event.UserSenderEvent
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.context.ApplicationEventPublisher
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User(
    @Column
    val name: String,

    @Column(unique = true)
    val email: String,

    @Column
    val phoneNumber: String,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
) {
    fun registerEventPublish(eventPublisher: ApplicationEventPublisher) {
        adminEventPublish(eventPublisher)
        couponEventPublish(eventPublisher)
        senderEventPublish(eventPublisher)
    }

    private fun adminEventPublish(eventPublisher: ApplicationEventPublisher) {
        eventPublisher.publishEvent(UserAdminEvent(this, this.name))
    }

    private fun couponEventPublish(eventPublisher: ApplicationEventPublisher) {
        eventPublisher.publishEvent(UserCouponEvent(this, this.email))
    }

    private fun senderEventPublish(eventPublisher: ApplicationEventPublisher) {
        eventPublisher.publishEvent(UserSenderEvent(this, this.email, this.phoneNumber))
    }
}