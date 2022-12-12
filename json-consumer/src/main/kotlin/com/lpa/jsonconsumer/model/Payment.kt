package com.lpa.jsonconsumer.model

import lombok.ToString
import java.io.Serializable

@ToString
data class Payment(
    val id: Long,
    val userId: Long,
    val productId: Long,
    val cardNumber: String
): Serializable