package com.idir.rickandmorty.features.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AppStateViewModel : ViewModel() {


    val modalState = MutableStateFlow(ModalState())


    fun toggleModal(toggle:Boolean = true) {
        modalState.update { current ->
            current.copy(isOpen = toggle)
        }
    }


}
