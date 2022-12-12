package com.lpa.jsonconsumer.listener

import com.lpa.jsonconsumer.log.logger
import com.lpa.jsonconsumer.model.Payment
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.lang.Thread.sleep

@Component
class JsonListener {

    @KafkaListener(topics = ["payment-topic"], groupId = "create-group", containerFactory = "jsonContainerFactory")
    fun antiFraud(@Payload payment: Payment) {
        logger().info("Pagamento recebido : $payment")
        sleep(1000)
        logger().info("Validando fraude...")
        sleep(2000)
        logger().info("Compra aprovada")
        sleep(3000)
    }

    @KafkaListener(topics = ["payment-topic"], groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    fun pdfGenerator(@Payload payment: Payment) {
        sleep(6000)
        logger().info("Gerando PDF do produto id : ${payment.productId}")

    }

    @KafkaListener(topics = ["payment-topic"], groupId = "email-group", containerFactory = "jsonContainerFactory")
    fun sendEmail(@Payload payment: Payment) {
        sleep(7000)
        logger().info("Enviando email de confirmação para o usuário id: ${payment.userId}")
    }
}