package com.crowdproj.rating.common.model

import com.crowdproj.rating.common.NONE
import kotlinx.datetime.Instant

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  13.03.2023 13:04
 */

// все должно быть изменяемым
data class CwpRating(
    var id: CwpRatingId = CwpRatingId.NONE,
    var scoreTypeId: CwpRatingScoreTypeId = CwpRatingScoreTypeId.NONE,
    var objectId: CwpRatingObjectId = CwpRatingObjectId.NONE,
    var objectTypeId: CwpRatingObjectTypeId = CwpRatingObjectTypeId.NONE,
    var score: Double = 0.0,
    var voteCount: Int = 0,
    var createdAt: Instant = Instant.NONE,
    var updatedAt: Instant = Instant.NONE,
    var ownerId: CwpRatingUserId = CwpRatingUserId.NONE,
    var permissions: MutableList<CwpRatingPermission> = mutableListOf(),
)