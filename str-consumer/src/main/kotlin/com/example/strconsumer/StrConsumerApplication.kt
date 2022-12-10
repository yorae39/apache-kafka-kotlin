package com.example.strconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class StrConsumerApplication

fun main(args: Array<String>) {
    runApplication<StrConsumerApplication>(*args)
}
