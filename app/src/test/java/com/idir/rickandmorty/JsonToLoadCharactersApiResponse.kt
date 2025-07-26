package com.idir.rickandmorty

import com.idir.rickandmorty.services.characters.responses.LoadCharactersApiResponse
import com.idir.rickandmorty.services.mappers.GsonMapper
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import java.nio.charset.StandardCharsets
import kotlin.collections.isNotEmpty
import kotlin.collections.toString
import kotlin.io.readBytes
import kotlin.jvm.java

class JsonToLoadCharactersApiResponse {

    private fun loadJsonFromFile(): String {
        val filename = "expected_api_response.json"
        val classLoader = this::class.java.classLoader
        val inputStream = classLoader?.getResourceAsStream(filename)
            ?: throw kotlin.IllegalArgumentException("File $filename not found in test resources")
        return inputStream.readBytes().toString(StandardCharsets.UTF_8)
    }

    @Test
    fun `parses JSON from file correctly`() {
        val json = loadJsonFromFile()

        val response = GsonMapper.fromJson<LoadCharactersApiResponse>(json)

        assertNotNull(response)
        Assert.assertEquals(826, response?.info?.count)
        Assert.assertEquals(42, response?.info?.pages)
        assertEquals("https://rickandmortyapi.com/api/character/?page=2", response?.info?.next)
        assertNull(response?.info?.prev)
        assertTrue(response?.results?.isNotEmpty() == true)
    }

}