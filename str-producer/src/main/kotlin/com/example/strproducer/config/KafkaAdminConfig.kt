package com.example.strproducer.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaAdminConfig {

    @Autowired
    lateinit var kafkaProperties: KafkaProperties

    /*
        CRIAÇÃO DAS CONFIGURAÇÕES DO KAFKA
     */
    @Bean
    fun kafkaAdmin() : KafkaAdmin{
        val configs = HashMap<String, Any>()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        return KafkaAdmin(configs)
    }

    /*
        CRIAÇÃO DE UM NOVO TOPICO COM DUAS PARTIÇÕES VIA CÓDIGO
     */
    @Bean
    fun topics () : KafkaAdmin.NewTopics {
        return KafkaAdmin.NewTopics(
            TopicBuilder.name("str-topic").partitions(2).replicas(1).build()
        )
    }
}