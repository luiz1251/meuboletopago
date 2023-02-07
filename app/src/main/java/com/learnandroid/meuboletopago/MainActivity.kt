package com.learnandroid.meuboletopago

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.learnandroid.meuboletopago.route.Application
import com.learnandroid.meuboletopago.ui.theme.LoginApplicationTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            LoginApplicationTheme {
                Application(ctx = this@MainActivity)
            }
        }
    }
}