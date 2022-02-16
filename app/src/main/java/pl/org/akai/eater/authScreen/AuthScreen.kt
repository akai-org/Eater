package pl.org.akai.eater.authScreen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch
import pl.org.akai.eater.LoginFragment
import pl.org.akai.eater.contracts.AuthResultContract
import pl.org.akai.eater.viewmodel.AuthViewModel

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    onUserLoggedIn: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var text = remember { mutableStateOf<String?>(null) }
    val user = remember(viewModel) { viewModel.user }
    val signInRequestCode = 1

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text.value = "Google sign in failed"
                } else {
                    coroutineScope.launch {
                        viewModel.signIn(
                            email = account.email!!,
                            displayName = account.displayName!!,
                        )
                    }
                    onUserLoggedIn()
                }
            } catch (e: ApiException) {
                text.value = "Google sign in failed"
            }
        }
    LoginFragment(
        onClick = {
            text.value = null
            authResultLauncher.launch(signInRequestCode)
        }
    )
}
