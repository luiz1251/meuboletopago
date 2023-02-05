package br.com.digitalhouse.meuboletopago.android

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
    Column(
//         criar uma separação vertical
//         modifier :  modificar o componente, estilos, espaçamentos etc
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White) //conferir linhas a
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //VARIÁVEIS
        val login = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val passwordVisible = remember { mutableStateOf(false) }
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

//        Text(text = "dffdf", fontWeight = FontWeight.Bold, fontSize = 32.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//        Componente para caixa de texto de inserção
//        PASSWORD
//  val passwordVisible = remember { mutableStateOf(TextFieldValue()) }
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

        Button(onClick = {/*openDialog.value = true*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "entrar")
        }
        Spacer(modifier = Modifier.height(96.dp))
        Button(onClick = {/*openDialog.value = true*/}, modifier = Modifier.fillMaxWidth()){
        Text(text = "cadastra-se")
    }

    }
}
//    Spacer(modifier = Modifier.height(100.dp))
//
//    Button(onClick = {/*openDialog.value = true*/}, modifier = Modifier.fillMaxWidth()){
////        Text(text = "cadastra-se")
//    }
//}
//         leadingicon: ma frente do texto
//        contenteDescription: acessibilidade
//
//        KeyboardType password -> nao tem autocomplete
//            if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            trailingIcon = {
//                val image =
//                    if (passwordVisible.value.not()) IPasswordVisualTransformation() else VisualTransformation.None
//
//                val description =
//                    if (passwordVisible.value) "Hide password" else "Show password"
//
//                IconButton(onClick = {passwordVisible.value = !passwordVisible.value}){
//                    Icon(imageVector = image, description)
//                }
//
//            }
//        )
//ACESSIBILIDADE
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = {/*openDialog.value = true*/}, modifier = Modifier.fillMaxWidth()){
//            Text(text = "entrar")
//        }
//
//
//
//    }
//}
//
//
//
//
//preview é usado só para exibir
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

// 1) Ver se valores alteram
// 2) ver se a senha esconde os caracteres
// 3) fazer "mostrar a senha"
// 4) alert : cadastro realizado com sucesso, email v
// 5) botão cadastre-se