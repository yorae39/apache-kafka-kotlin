package com.example.strconsumer.exceptions

import com.example.strconsumer.log.logger
import org.springframework.kafka.listener.KafkaListenerErrorHandler
import org.springframework.kafka.listener.ListenerExecutionFailedException
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class ErrorCustomHandler : KafkaListenerErrorHandler {
    /*
        OBS: CASO QUEIRA QUE A OPERAÇÃO PROSSIGA COM SUCESSO UMA VEZ QUE O LOG
        INFORMA O TRATAMENTO RETORNE O OBJETO [ return Any() (null em java) ]
        CASO QUEIRA QUE DÊ REALMENTE FALHA RETORNE A EXCEPTION
     */
    override fun handleError(message: Message<*>, exception: ListenerExecutionFailedException): Any {
        logger().info("*** Entrou no handler ***")
        logger().info("Payload: ${message.payload}")
        logger().info("Exception: ${exception.cause}")
        //throw exception
        return Any()
    }

}