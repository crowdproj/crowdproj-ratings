package com.crowdproj.rating.ktor.base

data class KtorAuthConfig(
    val secret: String,
    val issuer: String,
    val audience: String,
    val realm: String,
    val clientId: String,
    val certUrl: String? = null,
) {
    companion object {
        const val ID_CLAIM = "sub"
        const val GROUPS_CLAIM = "groups"
        const val F_NAME_CLAIM = "fname"
        const val M_NAME_CLAIM = "mname"
        const val L_NAME_CLAIM = "lname"

        val TEST = KtorAuthConfig(
            secret = "secret",
            issuer = "com-crowdproj-rating",
            audience = "rating-users",
            realm = "com-crowdproj-ratings",
            clientId = "com-crowdproj-rating-service",
        )

        val NONE = KtorAuthConfig(
            secret = "",
            issuer = "",
            audience = "",
            realm = "",
            clientId = "",
        )
    }
}