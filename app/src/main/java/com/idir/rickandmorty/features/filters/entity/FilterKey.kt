package com.idir.rickandmorty.features.filters.entity

import com.idir.rickandmorty.core.entity.CharacterGender
import com.idir.rickandmorty.core.entity.CharacterStatus


data class FilterKey(
    val reverse: Boolean,
    val page: Int,
    val name: String?,
    val status: CharacterStatus?,
    val species: String?,
    val type: String?,
    val gender: CharacterGender?,
    val filterApplied:Boolean = false
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FilterKey) return false

        return reverse == other.reverse &&
                page == other.page &&
                name == other.name &&
                status == other.status &&
                species == other.species &&
                type == other.type &&
                gender == other.gender &&
                filterApplied == other.filterApplied
    }

    override fun hashCode(): Int {
        var result = reverse.hashCode()
        result = 31 * result + page
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (species?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (gender?.hashCode() ?: 0)
        return result
    }
}