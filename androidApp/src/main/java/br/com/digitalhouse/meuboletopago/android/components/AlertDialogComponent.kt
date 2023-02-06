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

    showDialog: Boolean,
    message:  String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {

    if (showDialog){

        AlertDialog( /*alt e mouse mostram os atributos */
            modifier = modifier,
            title = { Text(text="OPS!") },
            text = { Text("$message", color = Color.Black) },
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(onClick = onDismissRequest) {
                    Text("valeu, Le", color = Color.Black)
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black
            /*atributos do próprio AlertDialog */

        )


    }
}



@Preview
@Composable
fun AlertDialogComponent_Preview() {

          AlertDialogComponent(true, "teste", {})
        }
