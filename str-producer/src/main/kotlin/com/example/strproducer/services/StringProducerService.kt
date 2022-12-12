package com.example.strproducer.services

import com.example.strproducer.log.logger
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@RequiredArgsConstructor
@Service
class StringProducerService(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    //@Autowired
    //private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    /*
        ENVIO DE MENSAGEM COM CALLBACK DE VALIDAÇÃO PARA LOGS
        result: Retorno do kafka para o método
        ex: Exception
     */
    fun sendMessage(message: String) {
        val future = kafkaTemplate.send("str-topic", message)
        future.whenComplete { result, ex ->
            if (ex == null) {
                logger().info("Send message with success : $message")
                logger().info("Partition is :${result.recordMetadata.partition()} and Offset is : ${result.recordMetadata.offset()}")
            } else {
                logger().error("Error send message: ${ex.cause}")
            }
        }
    }
}