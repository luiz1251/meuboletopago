package br.com.digitalhouse.meuboletopago.android.movement

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.component.CenterTopBar
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Movement(onBack: () -> Unit)  {
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(true) }
    var state3 by remember { mutableStateOf(true) }
    MyApplicationTheme() {
        Scaffold (
            topBar = { CenterTopBar(title = "Movimentação", onProfileNavigation = {}, onBack = {})}
        ) {
            LazyColumn(
                modifier = Modifier.padding(it)) {
                item {
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state,
                            onClick = { state = true },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Receita")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state,
                            onClick = { state = false },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(text = "Despesa",
                            textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column{
                        val descricao = remember { mutableStateOf("") }
                        val valor = remember { mutableStateOf(Double) }
                        val data = remember { mutableStateOf(LocalDate.now())}
                        Text(text = "Descrição")
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { },
                            label = { Text(text = "Descrição") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Valor")
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { },
                            label = { Text(text = "Valor") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Data")
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { },
                            label = { Text(text = "Data") }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state2,
                            onClick = { state2 = true },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Não Repetir")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state2,
                            onClick = { state2 = false },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(text = "Repetir",
                            textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state3,
                            onClick = { state3 = true },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Fixo")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state3,
                            onClick = { state3 = false },
                            modifier = Modifier.semantics { contentDescription = "Localized Description" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(text = "Parcelado",
                            textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun Movement_Preview(){}