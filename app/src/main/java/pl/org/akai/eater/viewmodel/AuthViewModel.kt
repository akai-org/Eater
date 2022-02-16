package pl.org.akai.eater.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pl.org.akai.eater.base.BaseViewModel
import pl.org.akai.eater.base.UiEffect
import pl.org.akai.eater.base.UiEvent
import pl.org.akai.eater.base.UiState
import pl.org.akai.eater.util.User

class AuthViewModel : ViewModel() {
    private val _user: MutableStateFlow<User?> = MutableStateFlow(null)
    val user: StateFlow<User?> = _user

    suspend fun signIn(email: String, displayName: String) {
        delay(2000) // Simulating network call
        _user.value = User(email, displayName)
        Log.i("EMAIL"," ${user.value!!.email}")
    }
}