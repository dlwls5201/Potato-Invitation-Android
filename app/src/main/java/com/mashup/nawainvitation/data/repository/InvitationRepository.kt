package com.mashup.nawainvitation.data.repository

import com.mashup.nawainvitation.data.base.BaseResponse
import com.mashup.nawainvitation.presentation.main.model.ImageInfoItem
import com.mashup.nawainvitation.presentation.main.model.InvitationsItem
import com.mashup.nawainvitation.presentation.main.model.TypeItem
import com.mashup.nawainvitation.presentation.searchlocation.api.Documents
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable

interface InvitationRepository {

    fun getAllTypes(
        callback: BaseResponse<List<TypeItem>>
    ): Disposable

    fun insertTempInvitation()

    fun getInvitations(): Flowable<List<InvitationsItem>>

    fun getLatestInvitation(): Flowable<InvitationsItem>

    fun updateInvitationTemplateId(
        templateId: Int
    ): Disposable

    fun updateInvitationWords(
        invitationTitle: String,
        invitationContents: String
    ): Disposable

    fun updateInvitationTime(
        invitationTime: String
    ): Disposable

    fun updateInvitationAddress(
        documents: Documents
    ): Disposable

    fun updateInvitationImages(
        imageList: List<ImageInfoItem>
    ): Disposable

    fun updateInvitationHashcode(
        hashCode: String?
    ): Disposable

    fun pathInvitation(
        templatesId: Int,
        callback: BaseResponse<String>
    ): Disposable
}
