package com.example.strconsumer.custom

import org.springframework.core.annotation.AliasFor
import org.springframework.kafka.annotation.KafkaListener

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@KafkaListener
annotation class StrConsumerCustomListener(
    @get:AliasFor(annotation = KafkaListener::class, attribute = "topics")
    val topics: Array<String> = ["str-topic"],
    @get:AliasFor(annotation = KafkaListener::class, attribute = "containerFactory")
    val containerFactory: String = "strContainerFactory",
    @get:AliasFor(annotation = KafkaListener::class, attribute = "groupId")
    val groupId: String = "group-1",
    @get:AliasFor(annotation = KafkaListener::class, attribute = "errorHandler")
    val errorHandler: String = "errorCustomHandler"
)
