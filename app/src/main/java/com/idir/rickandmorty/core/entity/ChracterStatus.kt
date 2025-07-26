@file:Suppress("UNUSED", "UnusedImport", "UNUSED_PARAMETER")

package com.idir.rickandmorty.core.entity

enum class CharacterStatus(private val value: String) {
    ALIVE("alive"),
    DEAD("dead"),
    UNKNOWN("unknown");

    override fun toString(): String = value

    companion object {
        fun fromValue(value: String): CharacterStatus? =
            CharacterStatus.entries.find { it.value.equals(value, ignoreCase = true) }
    }
}


