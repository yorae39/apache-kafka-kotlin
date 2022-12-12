package com.lpa.paymentservice.config

import lombok.RequiredArgsConstructor
import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@RequiredArgsConstructor
@Configuration
class KafkaAdminConfig(
    val kafkaProperties: KafkaProperties
) {

    @Bean
    fun kafkaAdmin() : KafkaAdmin {
        val configs = HashMap<String, Any>()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        return KafkaAdmin(configs)
    }

    @Bean
    fun topics() : KafkaAdmin.NewTopics {
        return KafkaAdmin.NewTopics(
            TopicBuilder.name("payment-topic").partitions(1).build()
        )
    }

}