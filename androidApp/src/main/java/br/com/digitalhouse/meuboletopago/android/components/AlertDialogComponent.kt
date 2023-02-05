import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme


@Composable
fun AlertDialogComponent (
    openDialog: MutableState<Boolean>,
    email: MutableState<TextFieldValue>
) {
    val openDialog = remember{
        mutableStateOf(false)
    }
    val email = remember { mutableStateOf(TextFieldValue()) }

    val context = LocalContext.current
    /*se o openDialog existir, chama o Alert */
    if (openDialog.value){

        AlertDialog( /*alt e mouse mostram os atributos */
            onDismissRequest = { openDialog.value = false},
            /*se apertar ok, vai deixar de exibir o componente */
            title = { Text(text="", color = Color.Black) },
            text = { Text("Seu e-mail foi enviado para  ${email.value.text}", color = Color.Black) },
            /*botao para confirmar a ação e sumir o Dialog */
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(context, "Confirmado!", Toast.LENGTH_LONG).show()
                }
                ) {
                    Text("valeu, Le", color = Color.Magenta)
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black
            /*atributos do próprio AlertDialog */

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {openDialog.value = true}, modifier = Modifier.fillMaxWidth()){
            Text(text = "entrar")
        }


    }
}



@Preview
@Composable
fun AlertPreview() {
    MyApplicationTheme {
        Surface(
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        ) {
//            AlertDialogComponent(openDialog = openDialog, email = email)
        }
    }
}