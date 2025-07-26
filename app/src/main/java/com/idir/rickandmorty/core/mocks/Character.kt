package com.idir.rickandmorty.core.mocks

import com.idir.rickandmorty.core.entity.LocationInfo
import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader

val mockCharacterHeader = RickAndMortyCharacterHeader(
    id = 1,
    name = "Rick Sanchez",
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    url = "https://rickandmortyapi.com/api/character/1",
    created = "2017-11-04T18:48:46.250Z",
    species = "Human"
)

val mockCharacter = RickAndMortyCharacter(
    id = 1,
    name = "Rick Sanchez",
    status = "Alive",
    species = "Human",
    type = "",
    gender = "Male",
    origin = mockLocation,
    location = mockLocation,
    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
    episode = listOf(
        "https://rickandmortyapi.com/api/episode/1",
        "https://rickandmortyapi.com/api/episode/2",
        "https://rickandmortyapi.com/api/episode/3"
    ),
    url = "https://rickandmortyapi.com/api/character/1",
    created = "2017-11-04T18:48:46.250Z"
)

val mockCharacterHeaderList = List(10) { index ->
    RickAndMortyCharacterHeader(
        id = index,
        name = "Character $index",
        image = "https://rickandmortyapi.com/api/character/avatar/${(index % 20) + 1}.jpeg",
        url = "https://api.example.com/character/$index",
        species = "Human",
        created = "2023-01-${(index % 28 + 1).toString().padStart(2, '0')}T12:00:00.000Z"
    )
}

val mockCharacterList = List(10) { index ->
    RickAndMortyCharacter(
        id = index,
        name = "Character $index",
        status = if (index % 3 == 0) "Alive" else if (index % 3 == 1) "Dead" else "unknown",
        species = "Human",
        type = if (index % 2 == 0) "" else "Scientist",
        gender = if (index % 2 == 0) "Male" else "Female",
        origin = LocationInfo(
            name = "Origin Planet $index",
            url = "https://api.example.com/location/origin/$index"
        ),
        location = LocationInfo(
            name = "Current Location $index",
            url = "https://api.example.com/location/current/$index"
        ),
        image = "https://rickandmortyapi.com/api/character/avatar/${(index % 20) + 1}.jpeg",
        episode = List(3) { epIndex -> "https://api.example.com/episode/${epIndex + 1}" },
        url = "https://api.example.com/character/$index",
        created = "2023-01-${(index % 28 + 1).toString().padStart(2, '0')}T12:00:00.000Z"
    )
}
