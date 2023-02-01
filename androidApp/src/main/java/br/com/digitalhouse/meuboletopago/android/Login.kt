package br.com.digitalhouse.meuboletopago.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    //surface: tela
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                    //diferente formatação do professor
                ) {
                    LoginView()
                }
            }
        }
    }
}
@Composable
fun LoginView() {
    Column(
        //modifier para pegar toda a extensão da tela
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val login = remember { mutableStateOf(TextFieldValue()) }
        Text(text = "MeuBoletoPago", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))


//ver diferença textfield, outline and textfieldValue
        //user
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { },
            label = { Text(text = "Usuario") }

        )
        val password = remember { mutableStateOf(TextFieldValue()) }
//        Text(text = "", fontWeight = FontWeight.Bold, fontSize = 32.sp)
//        Spacer(modifier = Modifier.height(16.dp))


//password
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = { },
            label = { Text(text = "password") }

        )


        Spacer(modifier = Modifier.height(16.dp))

        //MODIFIER: modificar tamanhos
        Button(onClick = {/*Redirecionar para tela inicial*/}, modifier = Modifier.fillMaxWidth()){
            Text(text = "entrar")
        }


    }
}
//
//@Composable
//fun CenterTopBar (title: String, onProfileNavigation: ())
//        CenterAlignedTopAppBar(function: () -> Unit) {
//
//}


//preview é usado só para exibir, nao colocar componentes dentro
@Preview
@Composable
fun LoginPreview() {
    MyApplicationTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {

            LoginView()
        }
    }
}



