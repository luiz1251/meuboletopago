package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
data class Transaction(
    val logo:String,
    val title:String,
    val transactionType: TransactionType,
    val value: Double,
    val status: Boolean,
    val date: String
)

enum class TransactionType(val description: String) {
    DESPESA("Despesa"),
    RECEITA("Receita")
}