package com.learnandroid.meuboletopago.composables

import android.content.Context
import android.os.Handler
import androidx.compose.foundation.BorderStroke
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.ui.theme.primaryColor

@Composable
fun DeletePage(navController: NavController, ctx: Context) {

    var dialogShow = remember { mutableStateOf(false) }




    Scaffold(

        topBar = {
            primaryColor
            TopAppBar(
                backgroundColor = Color(0xFF7048B6),
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Excluir",
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

                        OutlinedButton(
                            onClick = {
                                Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                                navController.navigate("home_page")
                                Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                            },
                            border = BorderStroke(
                                width = 2.dp,
                                color = primaryColor
                            )
                        ){
                            Icon(
                                Icons.Default.Delete,
                            )
                            Text(text = "Excluir esse registro")
                        }
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                    OutlinedButton(
                        onClick = {
                            Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                            navController.navigate("home_page")
                            Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                        },
                        border = BorderStroke(
                            width = 2.dp,
                            color = primaryColor
                        )
                        ){
                            Icon(
                                Icons.Default.Delete,
                            )
                            Text(text = "Excluir todos registros")
                        }

                    }

                }
            }
    )
        }


/*
@Composable
fun showDialog(navController: NavController, ctx: Context) : Boolean {
    var openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Atenção!") },
            text = { Text(text = "Confirma a exclusão?") },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                    navController.navigate("login_page")
                    Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Confirmar", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(ctx, "Solicitação Cancelada", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Cancelar", color = Color.White)
                }
            },
            backgroundColor = primaryColor,
            contentColor = Color.White
        )

    }
    return openDialog.value

}





@Composable
fun Alert(navController: NavController, ctx: Context){
    var openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Atenção!") },
            text = { Text(text = "Confirma a exclusão? Não será possível desfazer essa operação!") },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                    navController.navigate("home_page")
                   Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Confirmar", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(ctx, "Solicitação Cancelada", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Cancelar", color = Color.White)
                }
            },
            backgroundColor = primaryColor,
            contentColor = Color.White
        )

    }

}*/



