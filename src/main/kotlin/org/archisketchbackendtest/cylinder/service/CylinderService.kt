package org.archisketchbackendtest.cylinder.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.archisketchbackendtest.cylinder.client.CylinderClient
import org.archisketchbackendtest.cylinder.common.error.CylinderErrorCode
import org.archisketchbackendtest.cylinder.common.error.CylinderException
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
            throw CylinderException(CylinderErrorCode.JSON_PARSE_ERROR)
        }
    }

    private fun validateCylinderResponse(name: String?, editorAsset: EditorAsset?) {
        if (name.isNullOrBlank() || editorAsset == null) {
            throw CylinderException(CylinderErrorCode.MISSING_VALUE)
        }
    }
}