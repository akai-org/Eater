package pl.org.akai.eater.authScreen

import pl.org.akai.eater.base.UiEffect
import pl.org.akai.eater.base.UiEvent
import pl.org.akai.eater.base.UiState
import pl.org.akai.eater.util.User

interface AuthScreenContract {
    sealed class Effect: UiEffect {
        object SignIn : Effect()

        data class FetchingError(val error: Throwable) : Effect()
    }

    sealed class Event : UiEvent {
        class OnSignInClick(val email: String?, val displayName: String?) : Event()
    }

    data class State(
        var user : User,
        var loading : Boolean
    ) : UiState {
        companion object {
            val empty = State(User("", ""), false)
        }
    }
}