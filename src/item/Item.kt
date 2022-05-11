package src.item

import java.math.BigDecimal

//TODO: Talvez remover os parâmetros do construtor
class Item(val codigo: Int, private val nome: String, private val preco: BigDecimal) {

    protected val valorDesconto: String = "";

    override fun toString(): String {
        return "código: $codigo | nome: $nome | preço(R$) $preco";
    }
}