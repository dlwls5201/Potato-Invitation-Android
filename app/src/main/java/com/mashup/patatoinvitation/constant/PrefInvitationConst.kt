package com.mashup.patatoinvitation.constant

/**
 * @param type
 *
 * 0 - 만수르형
 * 1 - 마이웨이형
 * 2 - 제발형
 * 3 - 협박형
 * 4 - 애교형
 */
class PrefInvitationConst(
    private var type: Int
) {

    val title get() = "pref_${type}_invitation_title"

    val content = "pref_${type}_invitation_content"

    val date = "pref_${type}_invitation_date"

    val time = "pref_${type}_invitation_time"

    val location get() = "pref_${type}_invitation_title"

    val photos get() = "pref_${type}_invitation_photos"
}
