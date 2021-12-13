package pl.org.akai.eater.authScreen

import io.uniflow.core.flow.data.UIEvent
import pl.org.akai.eater.base.BaseViewModel
import pl.org.akai.eater.base.UiEffect
import io.uniflow.core.flow.data.UIState as UIState1

class AuthViewModel: BaseViewModel<AuthContract.Event, AuthContract.State, AuthContract.Effect>() {
    override fun createInitialState(): AuthContract.State {
        TODO("Not yet implemented")
    }

    override fun handleEvent(event: AuthContract.Event) {
        TODO("Not yet implemented")
    }

    fun signIn(email: String?, displayName: String?) {

    }

}
