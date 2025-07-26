package com.idir.rickandmorty.services

import com.idir.rickandmorty.core.ports.ICharacterService
import com.idir.rickandmorty.services.api.NetworkClient
import com.idir.rickandmorty.services.characters.CharacterServiceImp


class ServiceGateway private constructor() : ServiceGatewayPort {

    private val networkClient = NetworkClient()
    private val characterService: ICharacterService = CharacterServiceImp(networkClient)

    override fun getCharactersService(): ICharacterService = characterService

    companion object {
        val instance: ServiceGatewayPort by lazy { ServiceGateway() }
    }
}

