package com.learnandroid.meuboletopago.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.component.CardData

@Composable
fun HomePage(navController: NavController){

    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed))
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            backgroundColor = Color(0xFF7048B6),

            title = { Text(
                textAlign = TextAlign.Justify,
                text = "Controle de Despesas",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,)
            })},
        floatingActionButton = { FloatingActionButton(onClick = {navController.navigate("movement_page")}) {
            Icon(
                Icons.Default.Add, tint = Color.White,
            )
            
        }},
        floatingActionButtonPosition = FabPosition.End,
        
    ) {
        val listCard = CardData()
        val qtd = 15
        LazyColumn(

            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            listCard
            }

        }
        
    }
    


@Composable
@Preview
fun HomePagePreview(){

}