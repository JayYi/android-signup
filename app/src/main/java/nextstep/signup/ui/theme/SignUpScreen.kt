package nextstep.signup.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier
                .fillMaxSize()
                .padding(32.dp),
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_title),
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
        )

        TextField(
            value = userName,
            onValueChange = { value ->
                userName = value
            },
            label = { Text(text = stringResource(id = R.string.sign_up_label_username)) },
            colors =
                TextFieldDefaults.colors(
                    focusedContainerColor = BlueGrey20,
                    unfocusedContainerColor = BlueGrey20,
                    focusedLabelColor = Blue50,
                    focusedIndicatorColor = Blue50,
                ),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                    .padding(top = 32.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignupTheme {
        SignUpScreen()
    }
}