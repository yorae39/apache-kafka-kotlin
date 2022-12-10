package com.example.strconsumer.listners

import com.example.strconsumer.log.logger
import org.springframework.kafka.annotation.KafkaListener
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
     */

    @KafkaListener(groupId = "group-1", topics = ["str-topic"], containerFactory = "strContainerFactory")
    fun listener(message: String) {
        logger().info("Receive message: $message")
    }
}