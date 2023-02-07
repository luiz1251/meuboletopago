package com.learnandroid.meuboletopago.route

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learnandroid.meuboletopago.SplashScreen
import com.learnandroid.meuboletopago.component.CardInfo


import com.learnandroid.meuboletopago.composables.*

@Composable
fun Application(ctx : Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen", builder = {
        composable("login_page", content = { LoginPage(navController = navController) })
        composable("register_page", content = { RegisterPage(navController = navController) })
        composable("password_page", content = { PasswordPage(navController = navController) })
        composable("movement_page", content = { MovementPage(navController = navController) })
        composable("update_page", content = { UpdatePage(navController = navController) })
        composable("delete_page", content = { DeletePage(navController = navController,ctx = ctx) })
        composable("splash_screen", content = { SplashScreen(navController = navController) })
        composable("home_page", content = { HomePage(navController = navController, cardInfo = cardInfo,ctx = ctx)})
        composable("detail_page", content = { DetailPage(navController = navController, ctx = ctx) })
        composable("hint_page", content = { HintPage(navController = navController) })

    })
}