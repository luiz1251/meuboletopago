package com.learnandroid.meuboletopago.composables


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext

import androidx.compose.ui.res.imageResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.Object.MovementType
import com.learnandroid.meuboletopago.ui.theme.whiteBackground



@Composable
fun MovementPageOp(navController: NavController ) {
    var selectedOption = remember { mutableStateOf("") }

    val image = imageResource(id = com.learnandroid.meuboletopago.R.drawable.movement_page)

    val context = AmbientContext.current
    val description = remember { mutableStateOf("") }
    val value = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                image,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(0.dp, 32.dp, 0.dp, 0.dp)
                    .preferredSize(112.dp, 112.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.70f)
                .clip(RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp))
                .background(whiteBackground)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ScrollableColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Movimentação", fontSize = TextUnit.Sp(30),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit.Sp(2)
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            RadioButton(
                                selected = selectedOption.value == MovementType.expense,
                                onClick = { selectedOption.value = MovementType.expense },
                                colors = RadioButtonDefaults.colors(Color.Red)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(MovementType.expense)
                            Spacer(modifier = Modifier.size(16.dp))


                            RadioButton(
                                selected = selectedOption.value == MovementType.revenue,
                                onClick = { selectedOption.value = MovementType.revenue },
                                colors = RadioButtonDefaults.colors(Color.Green)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(MovementType.revenue)
                            Spacer(modifier = Modifier.size(16.dp))
                        }

                        Spacer(modifier = Modifier.size(10.dp))


                        OutlinedTextField(
                            value = description.value,
                            onValueChange = { description.value = it },
                            label = { Text(text = "Descrição") },
                            placeholder = { Text(text = "Descrição") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        OutlinedTextField(
                            value = value.value,
                            onValueChange = { value.value = it },
                            label = { Text(text = "Valor") },
                            placeholder = { Text(text = "Valor") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )

                        OutlinedTextField(
                            value = date.value,
                            onValueChange = { date.value = it },
                            label = { Text(text = "Data") },
                            placeholder = { Text(text = "Data") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )


                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(
                            onClick = { navController.navigate("update_page")
                                Toast.makeText(context, "Registro Salvo", Toast.LENGTH_SHORT).show()},
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Salvar", fontSize = TextUnit.Sp(20))

                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                    }

                }
            }
        }

    }
}


