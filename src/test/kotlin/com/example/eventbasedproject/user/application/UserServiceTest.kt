package com.example.eventbasedproject.user.application

import com.example.eventbasedproject.user.domain.User
import com.example.eventbasedproject.user.event.UserAdminEvent
import com.example.eventbasedproject.user.event.UserCouponEvent
import com.example.eventbasedproject.user.event.UserSenderEvent
import com.example.eventbasedproject.user.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.BDDMockito.*
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationEventPublisher

@ExtendWith(MockitoExtension::class)
class UserServiceTest {
    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var eventPublisher: ApplicationEventPublisher

    @Captor
    private lateinit var eventPublishCaptor: ArgumentCaptor<ApplicationEvent>

    private lateinit var userService: UserService

    @BeforeEach
    internal fun setUp() {
        userService = UserService(userRepository, eventPublisher)
    }

    @Test
    internal fun `userService 이벤트를 테스트한다`() {
        //given
        val name = "youthcon"
        val email = "youthcon@gmail.com"
        val phoneNumber = "010-1111-1111"
        given(userRepository.save(any(User::class.java)))
            .willReturn(
                User(
                    name,
                    email,
                    phoneNumber
                )
            )

        val request = UserRequest(name, email, phoneNumber)

        //when
        userService.create(request)

        //then
        // 이벤트가 총 3회였기 때문에
        verify(eventPublisher, times(3)).publishEvent(eventPublishCaptor.capture())

        val events: List<ApplicationEvent> = eventPublishCaptor.allValues
        assertThat(events[0]).isInstanceOf(UserAdminEvent::class.java)
        assertThat(events[1]).isInstanceOf(UserCouponEvent::class.java)
        assertThat(events[2]).isInstanceOf(UserSenderEvent::class.java)
    }
}
