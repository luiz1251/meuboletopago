package br.com.digitalhouse.meuboletopago.android.component

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color.Companion.White as White1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(title: String, onProfileNavigation: () -> Unit, onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        navigationIcon = { IconButton(onClick = onBack) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back")
        }
        },
        title = { Text(title) }
    )
}

@Preview
@Composable
fun CenterTopBarPreview() {
    CenterTopBar(title = "Movimentação", onProfileNavigation = {}, onBack = {})
}