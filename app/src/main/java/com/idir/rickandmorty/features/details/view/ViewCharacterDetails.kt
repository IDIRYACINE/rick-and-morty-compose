package com.idir.rickandmorty.features.details.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.idir.rickandmorty.features.details.hooks.CharacterDetailsLoader
import com.idir.rickandmorty.features.details.state.CharacterDetailViewModel
import com.idir.rickandmorty.features.details.widgets.CharacterDetailsAppbar

data class ViewCharacterDetailsParams(val characterId:Int = -1 )

@Composable
fun ViewCharacterDetails(params:ViewCharacterDetailsParams,viewModel:CharacterDetailViewModel = CharacterDetailViewModel()){
    CharacterDetailsLoader(viewModel,params.characterId)

    val character = viewModel.character

    Scaffold(
        topBar = {
            CharacterDetailsAppbar()
        }
    ) { padding ->
        Box(
            modifier = Modifier.padding(padding)
        ){

        }
        if(character.value !=null) CharacterDetailsContents(character.value!!)
        else EmptyCharacterDetails()

    }

}