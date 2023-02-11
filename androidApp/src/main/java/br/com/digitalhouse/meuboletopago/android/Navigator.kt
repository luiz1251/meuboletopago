package br.com.digitalhouse.meuboletopago.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.home.HomeScreen
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen
import br.com.digitalhouse.meuboletopago.android.movement.MovementScreen

@Composable
fun Navigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login", content = { LoginScreen(navController = navController) })
        composable("home", content = { HomeScreen(navController = navController)})
        composable("movement", content = { MovementScreen(navController = navController) })
//        composable("register_page", content = { RegisterPage(navController = navController) })
//        composable("password_page", content = { PasswordPage(navController = navController) })
//        composable("update_page", content = { UpdatePage(navController = navController) })
//        composable("delete_page", content = { DeletePage(navController = navController,ctx = ctx) })
//        composable("splash_screen", content = { SplashScreen(navController = navController) })
//        composable("detail_page", content = { DetailPage(navController = navController, ctx = ctx) })
//        composable("hint_page", content = { HintPage(navController = navController) })

    })
}