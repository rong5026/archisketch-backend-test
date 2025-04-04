package org.archisketchbackendtest.cylinder.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.archisketchbackendtest.cylinder.client.CylinderClient
import org.archisketchbackendtest.cylinder.dto.response.CylinderApiResponse
import org.archisketchbackendtest.cylinder.dto.response.CylinderResponse
import org.archisketchbackendtest.cylinder.dto.response.EditorAsset
import org.springframework.stereotype.Service

@Service
class CylinderService (
    private val cylinderClient: CylinderClient,
    private val objectMapper: ObjectMapper
){
    fun getCylinderInfo(): CylinderResponse {
        val cylinderResponse = cylinderClient.requestCylinderInfo()
        val parseCylinder = parseCylinderResponse(cylinderResponse)

        val name = parseCylinder.product.name
        val editorAsset = parseCylinder.product.editorAsset

        validateCylinderResponse(name, editorAsset)

        return CylinderResponse.of(name, editorAsset)
    }

    private fun parseCylinderResponse(response: String) : CylinderApiResponse {
        try {
            return objectMapper.readValue(response, CylinderApiResponse::class.java)
        } catch (e: Exception) {
            throw RuntimeException("응답 파싱 실패 - ${e.message}", e)
        }
    }

    private fun validateCylinderResponse(name: String?, editorAsset: EditorAsset?) {

        if (name.isNullOrBlank() || editorAsset == null) {
            throw IllegalArgumentException("필수 필드(name, editorAsset)가 비어있습니다")
        }
    }
}