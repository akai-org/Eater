package pl.org.akai.eater.authScreen

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.*
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.flow.collect
import pl.org.akai.eater.contracts.AuthResultContract
import pl.org.akai.eater.util.RequestCode

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    onUserLoggedIn: () -> Unit
) {
    val text = remember { mutableStateOf<String?>(null) }
    val state = viewModel.uiState.collectAsState().value
    val signInRequestCode = RequestCode.signin

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text.value = "Google sign in failed"
                } else {
                    viewModel.setEvent(AuthScreenContract.Event.OnSignInClick(account.email, account.displayName))
                }
            } catch (e: ApiException) {
                text.value = "Google sign in failed"
            }
        }

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when(effect) {
                is AuthScreenContract.Effect.SignIn -> onUserLoggedIn()
                is AuthScreenContract.Effect.FetchingError -> Log.e("SIGNIN", "FETCHING ERROR")
            }
        }
    }

    LoginFragment(
        onClick = {
            text.value = null
            authResultLauncher.launch(signInRequestCode)
        },
        isLoading = state.loading
    )
}
