package com.example.strconsumer.config

import com.example.strconsumer.log.logger
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.RecordInterceptor
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import java.lang.Exception


@EnableKafka
@Configuration
class StringConsumerConfig {

    @Autowired
    lateinit var kafkaProperties: KafkaProperties

    @Bean
    fun consumerFactory() : ConsumerFactory<String, String> {
        val configs = HashMap<String, Any>()
        configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        //configs[ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS] = StringDeserializer::class.java
        //configs[ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(configs)
    }

    @Bean
    fun strContainerFactory(consumer: ConsumerFactory<String, String>) : ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumer
        factory.setRecordInterceptor(recordInterceptor())
        return factory
    }

    private fun recordInterceptor(): RecordInterceptor<String?, String?> {
        return object : RecordInterceptor<String?, String?> {

            override fun intercept(
                record: ConsumerRecord<String?, String?>,
                consumer: Consumer<String?, String?>,
            ): ConsumerRecord<String?, String?> {
                if (record.value()?.contains("Teste") == true) {
                    logger().info("A palavra existe na mensagem!")

                } else  {
                    logger().info("A palavra não existe na mensagem!")
                }
                return record
            }

            override fun success(record: ConsumerRecord<String?, String?>, consumer: Consumer<String?, String?>) {
                logger().info("Sucesso!")
            }

            override fun failure(
                record: ConsumerRecord<String?, String?>,
                exception: Exception,
                consumer: Consumer<String?, String?>
            ) {
                logger().info("Falha!")
                logger().info("Exception: ${exception.message}")
            }
        }
    }

}