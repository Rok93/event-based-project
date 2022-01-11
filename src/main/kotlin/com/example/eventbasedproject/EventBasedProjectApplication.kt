package com.example.eventbasedproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class EventBasedProjectApplication

fun main(args: Array<String>) {
    runApplication<EventBasedProjectApplication>(*args)
}
