package com.lpa.paymentservice.service

import com.lpa.paymentservice.model.Payment

interface PaymentService {
    fun sendPayment(payment: Payment)
}