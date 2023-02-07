package com.learnandroid.meuboletopago.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.R
import com.learnandroid.meuboletopago.ui.theme.primaryColor

import com.learnandroid.meuboletopago.ui.theme.whiteBackground

@Composable
fun HintPage(navController: NavController){

    val image = imageResource(id = R.drawable.icone_prosperidade)


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {
            Image(
                image,

                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(0.dp, 64.dp, 0.dp, 0.dp)
                    .preferredSize(256.dp, 256.dp)
            )


        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp))
                .background(whiteBackground)
                .padding(10.dp)
        ) {

            ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Dicas e informações úteis",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit.Sp(2)
                    ),
                    fontSize = TextUnit.Sp(22)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.Start) {

                    Text(text = stringResource(R.string.dica1), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica2), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica3), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica4), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica5), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica6), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.padding(4.dp))
                    Text(text = stringResource(R.string.dica7), fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.padding(10.dp))


                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    /*Button(
                        onClick = { navController.navigate("home_page") },
                        modifier = Modifier
                            .height(50.dp)
                            .height(50.dp)

                    ) {
                        Text(text = "OK", fontSize = TextUnit.Sp(20))
                    }*/

                    OutlinedButton(
                        onClick = { navController.navigate("home_page")},

                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Black
                        )

                    ){
                        Icon(
                            Icons.Default.CheckCircle,
                            tint = Color.Black
                        )
                        Text(text = "OK", color = Color.Black)
                    }
                }


                }


            }
        }

    }
