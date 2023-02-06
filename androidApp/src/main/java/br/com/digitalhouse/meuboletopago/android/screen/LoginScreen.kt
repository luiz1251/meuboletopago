package br.com.digitalhouse.meuboletopago.android.screen

import AlertDialogComponent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.model.Login


class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                //tela total - surface. As barras de navegação ficam na surface também
                Surface(
                    //surface: tela
                    //delegate: herança
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
//    MyApplicationTheme {
//
//                Surface(modifier = Modifier.fillMaxSize()){
    Column(
//         criar uma separação vertical
//         modifier :  modificar o componente, estilos, espaçamentos etc
        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Color.White) //conferir linhas a
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        //VARIÁVEIS
        val login = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val passwordVisible = remember { mutableStateOf(false) }
        val showDialog = remember { mutableStateOf(false) }
        val mensagem = remember { mutableStateOf("") }
//        inicia a tela com o dialog hide

//        Um componente pode ser renderizado várias vezes. Para que nao precise colocar valor
//        direto na variável em caso de valores mutáveis, usa-se o remember para que ele guarde
//        o valor. A variável vai ser um valor de TextField e ela é mutável, seu estado pode mudar
//        dp: densidade por polegada (utilizado para aquilo que não for fonte)
//        sp: size polegada (usado para fontes)


        Text(text = "MeuBoletoPago", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Login", fontWeight = FontWeight.Normal, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(16.dp))


//        ver diferença textfield, outline and textfieldValue - VER MATERIAL DESIGN
//        USUÁRIO
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "Usuario") }

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
//            /por padrão, os componentes não preenchem a tela inteira, com o fillMaxWidth, ele preenche
//            Pode-se usar um valor de densidade que se deseja ocupar da tela/
            value = password.value,
//            /valor inicial /
            onValueChange = { password.value = it },
//            quando começar a digitar, o valor digitado - it - altera o valor inicial
            label = { Text(text = "password") },
//            CRIAR OS PONTINHOS
//            //val passwordVisible
            visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val iconPassword =
                    if (passwordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible.value.not()) "Invisível" else "Visível"
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = iconPassword, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val loginUser = Login(
                login = login.value.text,
                senha = password.value.text
            )
            mensagem.value = if (loginUser.validador()) {
                "Login executado com sucesso"
            } else {
                //showDialog.value = true
                //no final do bloco, sempre lê a ultima linha (no caso, tem que ser string)
                "Ops! Login ou senha inválida"
            }
            showDialog.value = true

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "entrar")
        }
        AlertDialogComponent(
            showDialog = showDialog.value,
            message = mensagem.value,
            onDismissRequest = { showDialog.value = false }

        )
        Spacer(modifier = Modifier.height(256.dp))
        Button(
            onClick = {/*openDialog.value = true*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFF7BC59D))
        ) {
            Text(
                text = "cadastrar",
                color = Color.White
            )
            //Text(text = "cadastrar")


        }
    }


}
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



