package br.com.digitalhouse.meuboletopago.model

class Login ( val login:String, val senha: String ) {
        fun validador() = (login == "usuario@kmm.com" && senha == "12345")

}
