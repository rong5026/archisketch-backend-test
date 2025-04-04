package org.archisketchbackendtest.cylinder.client

import org.archisketchbackendtest.common.constants.ApiUrl
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class CylinderClient (
    private val webClientBuilder: WebClient.Builder
){
    fun requestCylinderInfo(): String {
        val webClient = webClientBuilder.build()

        try {
            val response = webClient.get()
                .uri(ApiUrl.CYLINDER_URL)
                .retrieve()
                .bodyToMono(String::class.java)
                .block()

            if (response.isNullOrBlank()) {
                throw IllegalStateException("Cylinder 요청값이 비어있습니다")
            }
            return response
        } catch (e: Exception) {
            throw Exception("Cylinder Open API 조회 실패 -  ${e.message}", e)
        }
    }
}