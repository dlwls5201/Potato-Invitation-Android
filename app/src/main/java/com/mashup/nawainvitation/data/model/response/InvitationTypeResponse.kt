package com.mashup.nawainvitation.data.model.response


import com.google.gson.annotations.SerializedName

data class InvitationTypeResponse(
    @SerializedName("invitationTypeItemList")
    val invitationTypeItemList: List<InvitationTypeItem>
) {
    data class InvitationTypeItem(
        @SerializedName("typeName")
        val typeName: String,
        @SerializedName("typeDescription")
        val typeDescription: String,
        @SerializedName("imageUrl")
        val imageUrl: String,
        @SerializedName("isExistInvitation")
        val isExistInvitation: Boolean,
        @SerializedName("invitationHashCode")
        val invitationHashCode: String?,
        @SerializedName("templateId")
        val templateId: Int
    )
}