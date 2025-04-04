package org.archisketchbackendtest.cylinder.client

import org.archisketchbackendtest.common.constants.ApiUrl
import org.archisketchbackendtest.cylinder.common.error.CylinderErrorCode
import org.archisketchbackendtest.cylinder.common.error.CylinderException
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
                throw CylinderException(CylinderErrorCode.EMPTY_RESPONSE)
            }
            return response
        } catch (e: Exception) {
            throw Exception("Cylinder Open API 조회 실패 : ${e.message}", e)
        }
    }
}