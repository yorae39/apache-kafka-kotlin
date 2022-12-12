package com.lpa.paymentservice.resource.impl

import com.lpa.paymentservice.model.Payment
import com.lpa.paymentservice.resource.PaymentResource
import com.lpa.paymentservice.service.PaymentService
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
class PaymentResourceImpl(
    val paymentService: PaymentService
) : PaymentResource {
    override fun payment(payment: Payment): ResponseEntity<Payment> {
        paymentService.sendPayment(payment)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}