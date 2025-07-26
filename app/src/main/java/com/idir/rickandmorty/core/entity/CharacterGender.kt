package com.idir.rickandmorty.core.entity

enum class CharacterGender(val value: String) {
    FEMALE("female"),
    MALE("male"),
    GENDERLESS("genderless"),
    UNKNOWN("unknown");

    override fun toString(): String = value

    companion object {
        fun fromValue(value: String): CharacterGender? =
            entries.find { it.value.equals(value, ignoreCase = true) }
    }
}
