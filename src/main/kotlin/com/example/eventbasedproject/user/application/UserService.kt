package com.example.eventbasedproject.user.application

import com.example.eventbasedproject.admin.application.CouponService
import com.example.eventbasedproject.sender.application.SenderService
import com.example.eventbasedproject.user.domain.User
import com.example.eventbasedproject.user.repository.UserRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class UserService(
    private val userRepository: UserRepository,
    private val eventPublisher: ApplicationEventPublisher
) {
    fun create(userRequest: UserRequest) {
        val user = User(userRequest.name, userRequest.email, userRequest.phoneNumber)
        userRepository.save(user)

        user.registerEventPublish(eventPublisher)
    }

    fun get(email: String): UserResponse {
        val user = userRepository.findByEmail(email) ?: throw IllegalArgumentException("존재하지 않는 회원입니다. email=${email}")

        return UserResponse(user.name, user.email, user.phoneNumber)
    }
}
