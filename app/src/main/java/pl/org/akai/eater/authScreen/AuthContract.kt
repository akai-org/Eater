package pl.org.akai.eater.authScreen

import pl.org.akai.eater.base.UiEffect
import pl.org.akai.eater.base.UiEvent
import pl.org.akai.eater.base.UiState

class AuthContract {
    sealed class Effect : UiEffect {
        object NavigateBack : Effect()
        object NavigateToEdit : Effect()
        data class FetchingError(val error: Throwable) : Effect()
    }

    sealed class Event : UiEvent {
        object OnReturnClick : Event()
        object OnEditClick : Event()
    }

    data class State(
        val user: String
    ) : UiState {
        companion object {
            val empty = State("login")
        }
    }
}