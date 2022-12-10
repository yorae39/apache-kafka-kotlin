package com.example.strconsumer.listners

import com.example.strconsumer.custom.StrConsumerCustomListener
import com.example.strconsumer.log.logger
import org.springframework.stereotype.Component

@Component
@StrConsumerCustomListener
class StrConsumerListener {

    /*
        GRUPO DE CONSUMO:
        LISTENER QUE FICA ESCUTANDO AS MENSAGENS
        OBS: EU POSSO FAZER VÁRIOS GRUPOS PARA CONSUMIR AS MENSAGENS!
        TERIA QUE CRIAR MAIS MÉTODOS E DAR A ELES UM GROUP_ID E SE FOR
        O MESMO DEPENDERÁ DO NUMERO DE PARTIÇÕES. SE NÃO HOUVEREM PARTIÇÕES
        SUFICENTES FICARA UM LISTENER SEM CONSEGUIR SE INSCREVER NO TÓPICO.
     */

    @StrConsumerCustomListener
    fun create(message: String) {
        logger().info("CREATE ::: Receive message: $message")
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
