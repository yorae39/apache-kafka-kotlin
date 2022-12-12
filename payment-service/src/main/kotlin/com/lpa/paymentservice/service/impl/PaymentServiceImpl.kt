package com.lpa.paymentservice.service.impl

import com.lpa.paymentservice.log.logger
import com.lpa.paymentservice.model.Payment
import com.lpa.paymentservice.service.PaymentService
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl : PaymentService {
    override fun sendPayment(payment: Payment) {
        logger().info("PAYMENT_SERVICE_IMPL ::: Pagamento recebido: $payment")
    }
}