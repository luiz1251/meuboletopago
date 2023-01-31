package br.com.digitalhouse.meuboletopago

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform