package nextstep.signup.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGrey20

@Composable
fun SignUpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    shape: Shape = SignUpTextFieldDefaults.shape,
    colors: TextFieldColors = SignUpTextFieldDefaults.colors(),
    singleLine: Boolean = true,
    isError: Boolean = false,
    supportText: @Composable (() -> Unit)? = null,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        shape = shape,
        colors = colors,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        enabled = enabled,
        isError = isError,
        singleLine = singleLine,
        supportingText = supportText,
        modifier = modifier,
    )
}

@Immutable
object SignUpTextFieldDefaults {
    val shape: Shape
        @Composable get() = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)

    @Composable
    fun colors(
        focusedContainerColor: Color = BlueGrey20,
        unfocusedContainerColor: Color = BlueGrey20,
        focusedLabelColor: Color = Blue50,
        focusedIndicatorColor: Color = Blue50,
    ): TextFieldColors =
        TextFieldDefaults.colors(
            focusedContainerColor = focusedContainerColor,
            unfocusedContainerColor = unfocusedContainerColor,
            focusedLabelColor = focusedLabelColor,
            focusedIndicatorColor = focusedIndicatorColor,
        )
}

@Preview(showBackground = true)
@Composable
fun SignUpTextFieldPreview(
    @PreviewParameter(SignUpTextFieldPreviewParameterProvider::class) value: Pair<String, String>,
) {
    SignUpTextField(
        value = value.first,
        onValueChange = {},
        label = { Text(text = value.second) },
    )
}

class SignUpTextFieldPreviewParameterProvider : PreviewParameterProvider<Pair<String, String>> {
    override val values: Sequence<Pair<String, String>>
        get() =
            sequenceOf(
                "" to "Welcome",
                "user" to "Welcome",
            )
}
