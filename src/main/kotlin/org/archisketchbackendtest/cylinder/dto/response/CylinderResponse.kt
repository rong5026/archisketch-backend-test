package org.archisketchbackendtest.cylinder.dto.response

data class CylinderResponse(
    val name: String,
    val editorAsset: EditorAsset
) {
    companion object {
        fun of(name: String, editorAsset: EditorAsset) : CylinderResponse {
            return CylinderResponse(
                name = name,
                editorAsset =editorAsset
            )
        }
    }
}