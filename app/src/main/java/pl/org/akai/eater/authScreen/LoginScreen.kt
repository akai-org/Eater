package pl.org.akai.eater

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.org.akai.eater.ui.EaterShapes
import pl.org.akai.eater.ui.EaterTheme
import pl.org.akai.eater.ui.EaterTypography

@Composable
fun LoginFragment(
    onClick: () -> Unit,
) {
    var isLoading = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.LoginWelcome),
            style = EaterTypography.h1
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .padding(vertical = 24.dp),
            text = stringResource(R.string.LoginWelcomeSubtitile),
            style = EaterTypography.h3,
            textAlign = TextAlign.Center
        )
        SignInButton(
            text = stringResource(R.string.signInWithGoogle),
            loadingText = stringResource(R.string.SigningIn),
            icon = painterResource(id = R.drawable.ic_google_icon),
            onClick = onClick
        )
    }
}

@Composable
fun SignInButton(
    text: String,
    isLoading: Boolean = false,
    loadingText: String,
    icon: Painter,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit
    ) {
    Surface(
        modifier = Modifier.clickable(
            enabled = !isLoading,
            onClick = onClick
        ),
        shape = EaterShapes.large,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {

        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .clickable(
                    enabled = !isLoading,
                    onClick = onClick
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = icon,
                contentDescription = "SignInButton",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (isLoading) loadingText else text)
            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}

@Preview(name = "Login")
@Composable
fun LoginPreview() {
    EaterTheme {
        Scaffold { innerPadding ->
            LoginFragment( onClick = {} )
        }
    }
}