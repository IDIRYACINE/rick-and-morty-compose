package com.idir.rickandmorty.services.characters.actions

import com.idir.rickandmorty.core.ports.LoadCharactersParams
import okhttp3.HttpUrl

fun rangeToString(x: Int, m: Int): String {
    return (x..(x + m)).joinToString(",")
}


fun loadPaginatedCharacters(params: LoadCharactersParams, urlBuilder: HttpUrl.Builder){
    val start = params.page
    val end = if (params.reverse) start - params.pageSize else start + params.pageSize

    val loaderString = rangeToString(
        minOf(start, end),
        kotlin.math.abs(end - start)
    )

    urlBuilder.addPathSegment(loaderString)

}