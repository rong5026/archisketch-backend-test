package org.archisketchbackendtest.cylinder.dto.response

data class CylinderApiResponse(
    val product: Product
)

data class Product(
    val name: String,
    val editorAsset: EditorAsset
)

data class EditorAsset(
    val twoD: String?,
    val threeD: String?,
    val dxfUrl: String?,
    val decimate: String?
)