package com.pogreb.bank_addresses.presentation.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pogreb.design.R
import com.pogreb.design.component.PrimaryButton
import com.pogreb.design.theme.AppTheme

@Composable
internal fun BankAddressesContent(
    modifier: Modifier,
    onBackToMainClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.sorry),
                contentDescription = stringResource(R.string.content_description_sorry),
                modifier = Modifier
                    .padding(bottom = 12.dp)
            )

            Text(
                text = stringResource(R.string.title_service_unavailable),
                modifier = Modifier
                    .padding(vertical = 16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }

        PrimaryButton(
            onClick = onBackToMainClick,
            text = stringResource(R.string.label_back_main),
            modifier = Modifier
                .padding(top = 16.dp),
        )
    }
}


@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PreviewBankAddressesContent() {
    AppTheme {
        BankAddressesContent(
            onBackToMainClick = {},
            modifier = Modifier
        )
    }
}