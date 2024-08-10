package nextstep.signup.ui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.ui.component.EmailValidation.EmailValidationResult

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    validationResult: EmailValidationResult = EmailValidationResult.Empty,
) {
    val supportText: @Composable (() -> Unit)? =
        if (validationResult is EmailValidationResult.FailureEmailFormat) {
            { Text(text = stringResource(id = R.string.error_email_format)) }
        } else {
            null
        }

    SignUpTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.sign_up_label_email)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        isError = validationResult.isFailure,
        supportText = supportText,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun EmailTextFieldPreview(
    @PreviewParameter(EmailTextFieldPreviewParameterProvider::class) param: EmailTextFieldPreviewParameter,
) {
    EmailTextField(
        value = param.value,
        onValueChange = {},
        validationResult = param.validationResult,
    )
}

class EmailTextFieldPreviewParameterProvider : PreviewParameterProvider<EmailTextFieldPreviewParameter> {
    override val values: Sequence<EmailTextFieldPreviewParameter>
        get() =
            sequenceOf(
                EmailTextFieldPreviewParameter("", EmailValidationResult.Empty),
                EmailTextFieldPreviewParameter("email@yopmail.com", EmailValidationResult.Success),
                EmailTextFieldPreviewParameter(
                    "email@yopmail",
                    EmailValidationResult.FailureEmailFormat,
                ),
            )
}

data class EmailTextFieldPreviewParameter(
    val value: String,
    val validationResult: EmailValidationResult,
)
