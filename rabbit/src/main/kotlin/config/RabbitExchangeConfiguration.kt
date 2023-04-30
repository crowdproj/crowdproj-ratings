package com.crowdproj.rating.rabbit.config

// настройки взаимодействия с RMQ
data class RabbitExchangeConfiguration(
    val keyIn: String,
    val keyOut: String,
    val exchange: String,
    val queue: String,
    val consumerTag: String,
    val exchangeType: String = "direct" // Объявляем обменник типа "type" (сообщения передаются в те очереди, где ключ совпадает)
)
