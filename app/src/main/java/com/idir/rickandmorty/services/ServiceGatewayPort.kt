package com.idir.rickandmorty.services

import com.idir.rickandmorty.core.ports.ICharacterService

interface ServiceGatewayPort {
    fun getCharactersService(): ICharacterService
}