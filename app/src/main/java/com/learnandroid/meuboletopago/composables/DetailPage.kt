package com.learnandroid.meuboletopago.composables

import android.content.Context
import android.os.Handler
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate

import com.learnandroid.meuboletopago.Object.PaymentSituation
import com.learnandroid.meuboletopago.ui.theme.primaryColor

@Composable
fun DetailPage(navController: NavController, ctx : Context){

    var selectedOption = remember { mutableStateOf("") }
    val handler = Handler()


    Scaffold(

        topBar = {
            primaryColor
            TopAppBar(
                backgroundColor = Color(0xFF7048B6),
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Detalhamento",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack)

                    }
                }
            )
        },
        bodyContent = {


            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            )


            {
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Card(
                            modifier = Modifier
                                .border(
                                    border = BorderStroke(2.dp, color = Color.LightGray),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                //.background(color = primaryColor)
                                .height(100.dp)
                                .width(350.dp),
                            shape = RoundedCornerShape(10.dp),
                            elevation = 10.dp
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                .background(color = primaryColor),
                                //verticalArrangement = Arrangement.Center,
                                //horizontalAlignment = Alignment.CenterHorizontally
                            ){

                                Text(text = "Descrição", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp,0.dp))
                                Spacer(modifier = Modifier.padding(10.dp))
                                Text(text = "Vencimento: dd/mm/aa", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp,0.dp))
                                Spacer(modifier = Modifier.padding(10.dp))
                                Text(text = "Valor: R$0.00", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(8.dp,0.dp))

                            }

                        }
                        Spacer(modifier = Modifier.padding(10.dp))

                        Row {
                            RadioButton(
                                selected = selectedOption.value == PaymentSituation.unpaid ,
                                onClick = { selectedOption.value = PaymentSituation.unpaid
                                    Toast.makeText(ctx,"Registrado como não pago",Toast.LENGTH_SHORT).show()
                                   handler.postDelayed({ navController.navigate("home_page")},2000)},
                                colors = RadioButtonDefaults.colors(Color.Red),


                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(PaymentSituation.unpaid)
                            Spacer(modifier = Modifier.size(16.dp))


                            RadioButton(
                                selected = selectedOption.value == PaymentSituation.payment,
                                onClick = { selectedOption.value = PaymentSituation.payment
                                    Toast.makeText(ctx,"Registrado como pago",Toast.LENGTH_SHORT).show()
                                    handler.postDelayed({ navController.navigate("home_page")},2000)},
                                colors = RadioButtonDefaults.colors(Color.Green)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(PaymentSituation.payment)
                            Spacer(modifier = Modifier.size(16.dp))
                        }


                        Spacer(modifier = Modifier.padding(10.dp))

                        Row() {

                            Button(
                                onClick = {
                                    navController.navigate("update_page")

                                },
                                modifier = Modifier
                                    .height(50.dp)
                                    .height(50.dp)
                            ) {
                                Text(text = "Editar", fontSize = TextUnit.Sp(20))

                            }

                            Spacer(modifier = Modifier.padding(20.dp))

                            Button(
                                onClick = {
                                    navController.navigate("delete_page")

                                },
                                modifier = Modifier
                                    .height(50.dp)
                                    .height(50.dp)
                            ) {
                                Text(text = "Excluir", fontSize = TextUnit.Sp(20))

                            }

                        }


                    }

                }
            }
        }
    )
}


