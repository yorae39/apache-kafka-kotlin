package com.lpa.paymentservice.resource

import com.lpa.paymentservice.model.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PaymentResource {
    @PostMapping
    fun payment(@RequestBody payment: Payment): ResponseEntity<Payment>
}