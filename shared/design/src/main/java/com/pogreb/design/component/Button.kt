package com.pogreb.design.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.theme.AppTheme
import com.pogreb.design.theme.bgDisable
import com.pogreb.design.theme.bgTertiary
import com.pogreb.design.theme.fontDisable

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        shape = ShapeDefaults.Small,
        colors = getColorsPrimaryButton(pressed),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 16.dp),
        interactionSource = interactionSource,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}

@Composable
private fun getColorsPrimaryButton(pressed: Boolean) = ButtonDefaults.buttonColors(
    containerColor = getContainerColorPrimaryButton(pressed),
    disabledContainerColor = MaterialTheme.colorScheme.bgDisable,
    disabledContentColor = MaterialTheme.colorScheme.fontDisable,
)

@Composable
private fun getContainerColorPrimaryButton(pressed: Boolean) = when {
    pressed -> MaterialTheme.colorScheme.inversePrimary
    else -> MaterialTheme.colorScheme.primary
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        shape = ShapeDefaults.Small,
        colors = getColorsSecondaryButton(pressed),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 16.dp),
        interactionSource = interactionSource,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}

@Composable
private fun getColorsSecondaryButton(pressed: Boolean) = ButtonDefaults.buttonColors(
    containerColor = getContainerColorSecondaryButton(pressed),
    disabledContainerColor = MaterialTheme.colorScheme.bgDisable,
    disabledContentColor = MaterialTheme.colorScheme.fontDisable,
)

@Composable
private fun getContainerColorSecondaryButton(pressed: Boolean) = when {
    pressed -> MaterialTheme.colorScheme.bgTertiary
    else -> MaterialTheme.colorScheme.surfaceVariant
}

@Composable
fun TertiaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = ShapeDefaults.Small,
        colors = getColorsTertiaryButton(pressed),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 16.dp),
        interactionSource = interactionSource,
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}

@Composable
private fun getColorsTertiaryButton(pressed: Boolean) = ButtonDefaults.textButtonColors(
    contentColor = getContentColorTertiaryButton(pressed),
    disabledContentColor = MaterialTheme.colorScheme.fontDisable,
)

@Composable
private fun getContentColorTertiaryButton(pressed: Boolean) = when {
    pressed -> MaterialTheme.colorScheme.primary
    else -> MaterialTheme.colorScheme.onPrimary
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewButton() {
    AppTheme {
        Column {
            PrimaryButton(
                onClick = {},
                text = "Кнопка",
                modifier = Modifier,
                enabled = true
            )
            SecondaryButton(
                onClick = {},
                text = "Кнопка",
                modifier = Modifier,
                enabled = true
            )
            TertiaryButton(
                onClick = {},
                text = "Кнопка",
                modifier = Modifier,
                enabled = true,
            )
        }
    }
}