package com.lpa.paymentservice.service.impl

import com.lpa.paymentservice.log.logger
import com.lpa.paymentservice.model.Payment
import com.lpa.paymentservice.service.PaymentService
import lombok.RequiredArgsConstructor
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.io.Serializable

@RequiredArgsConstructor
@Service
class PaymentServiceImpl(
    val kafkaTemplate: KafkaTemplate<String, Serializable>
) : PaymentService {
    override fun sendPayment(payment: Payment) {
        logger().info("Pagamento recebido: $payment")
        Thread.sleep(1000)
        logger().info("Enviando pagamento id = ${payment.id}")
        kafkaTemplate.send("payment-topic", payment)
    }
}