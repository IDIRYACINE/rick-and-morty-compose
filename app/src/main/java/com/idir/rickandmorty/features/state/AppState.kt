package com.idir.rickandmorty.features.state

import androidx.lifecycle.ViewModel
import com.idir.rickandmorty.features.filters.state.FiltersViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AppStateViewModel : ViewModel() {

    val filtersState = FiltersViewModel()

    val modalState = MutableStateFlow(ModalState())


    fun toggleModal(toggle:Boolean = true) {
        modalState.update { current ->
            current.copy(isOpen = toggle)
        }
    }


}
