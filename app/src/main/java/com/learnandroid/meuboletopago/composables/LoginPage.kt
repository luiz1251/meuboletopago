package com.learnandroid.meuboletopago.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.R


import com.learnandroid.meuboletopago.ui.theme.primaryColor
import com.learnandroid.meuboletopago.ui.theme.whiteBackground


@Composable
fun LoginPage(navController: NavController) {

    val image = imageResource(id = R.drawable.login_image)

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {

            Image(
                image,
                //Modifier.preferredSize(237.dp, 101.dp)
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(0.dp, 64.dp, 0.dp, 0.dp)
                    .preferredSize(237.dp, 101.dp)
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
                    text = "Login",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = TextUnit.Companion.Sp(2)
                    ),
                    fontSize = TextUnit.Companion.Sp(30)
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email") },
                        trailingIcon = {
                                       IconButton(onClick = { /*TODO*/ }) {
                                           Icon(
                                              Icons.Filled.AccountCircle,
                                              tint = Color.Gray
                                           )
                                       }
                        },
                        placeholder = { Text(text = "Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        onImeActionPerformed = { _, _ ->
                            focusRequester.requestFocus()
                        }
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        onValueChange = { passwordValue.value = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = vectorResource(id = R.drawable.password_eye),
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        label = { Text("Senha") },
                        placeholder = { Text(text = "Senha") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                        onImeActionPerformed = { _, controller ->
                            controller?.hideSoftwareKeyboard()
                        }

                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                       //textAlign = TextAlign.Right,
                        text = "Esqueci minha senha",
                        modifier = Modifier
                            .clickable(onClick = {
                                navController.navigate("password_page") {
                                    popUpTo = navController.graph.startDestination
                                    launchSingleTop = true
                                }
                            })
                            .align(Alignment.End)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { navController.navigate("home_page")},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Login", fontSize = TextUnit.Companion.Sp(20))
                    }

                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Cadastre-se",
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate("register_page"){
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }


            }
        }

    }
}




















