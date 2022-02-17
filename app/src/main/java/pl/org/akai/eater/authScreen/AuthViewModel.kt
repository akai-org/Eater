package pl.org.akai.eater.authScreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.org.akai.eater.base.BaseViewModel
import pl.org.akai.eater.util.User

class AuthViewModel : BaseViewModel<AuthScreenContract.Event, AuthScreenContract.State, AuthScreenContract.Effect>() {

    private suspend fun signIn(email: String?, displayName: String?) {
        setState { copy(user, true) }
        delay(2000) // Simulating network call
        uiState.value.user = User(email, displayName)
        setState { copy(user, false) }
    }

    override fun createInitialState(): AuthScreenContract.State {
        return AuthScreenContract.State.empty
    }

    override fun handleEvent(event: AuthScreenContract.Event) {
        when(event) {
            is AuthScreenContract.Event.OnSignInClick -> {
                viewModelScope.launch {
                    signIn(event.email, event.displayName)
                    setEffect { AuthScreenContract.Effect.SignIn }
                }
            }
        }
    }
}