package com.example.strconsumer.listners

import com.example.strconsumer.custom.StrConsumerCustomListener
import com.example.strconsumer.log.logger
import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.stereotype.Component

@Component
class StrConsumerListener {

    /*
        GRUPO DE CONSUMO:
        LISTENER QUE FICA ESCUTANDO AS MENSAGENS
        OBS: EU POSSO FAZER VÁRIOS GRUPOS PARA CONSUMIR AS MENSAGENS!
        TERIA QUE CRIAR MAIS MÉTODOS E DAR A ELES UM GROUP_ID E SE FOR
        O MESMO DEPENDERÁ DO NUMERO DE PARTIÇÕES. SE NÃO HOUVEREM PARTIÇÕES
        SUFICENTES FICARA UM LISTENER SEM CONSEGUIR SE INSCREVER NO TÓPICO.

        OBS: PARA UMA FALHA ESPECIFICA COMO A COMENTADA ABAIXO DEVERÁ USAR A
        ANOTAÇÃO [ @KafkaHandler ] NO MÉTODO ESPECÍFICO!
     */

    @StrConsumerCustomListener
    @KafkaHandler
    fun create(message: String) {
        logger().info("CREATE ::: Receive message: $message")
        throw IllegalArgumentException("Teste LPA")
    }

    @StrConsumerCustomListener
    fun log(message: String) {
        logger().info("LOG ::: Receive message: $message")
    }

    @StrConsumerCustomListener(groupId = "group-2")
    fun history(message: String) {
        logger().info("HISTORY ::: Receive message: $message")
    }
}
