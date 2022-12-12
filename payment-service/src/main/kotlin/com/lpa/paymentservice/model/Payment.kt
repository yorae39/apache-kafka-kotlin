package com.lpa.paymentservice.model

import java.io.Serializable

data class Payment(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val cardNumber: String
): Serializable