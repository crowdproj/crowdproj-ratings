package models

import kotlin.jvm.JvmInline

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  13.03.2023 13:14
 */

@JvmInline
value class MkplScoreTypeId(private val id: String){
    fun asString() = id

    companion object {
        val NONE = MkplScoreTypeId("")
    }
}