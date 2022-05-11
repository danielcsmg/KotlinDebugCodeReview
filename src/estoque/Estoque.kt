package src.estoque

import src.item.Item
import java.math.BigDecimal

class Estoque {
    private val listaItem: ArrayList<Item> = ArrayList()

    fun registrarItem() {
        val codigo: Int
        val preco: BigDecimal
        val nomeItem: String
        try {
            println("Digite o código do produto: ")
            codigo = readln().toInt()
            println("Digite o nome do produto: ")
            nomeItem = readln()
            println("Digite o preco do produto: ")
            preco = readln().toBigDecimal()
        }catch (e: Exception){
            println("Erro ao tentar cadastrar o produto!")
            println("Verifique os formatos do código e do preço:")
            return
        }
        val item: Item = Item(verificarItemRepetido(codigo), nomeItem, preco)
        listaItem.add(item)
        println("Item registrado com sucesso\n")

    }

    private fun verificarItemRepetido(codigo: Int): Int {
        var codigoComparador = codigo
        listaItem.forEach{
            while(it.codigo == codigoComparador){
                println("Códigos já usado! ")
                println("Digite o código do produto: ")
                codigoComparador = readln().toInt()
            }
        }
        return codigoComparador
    }

    fun listarItens() {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento")
        } else {
            println("Atualmente temos os seguintes itens:")
            listaItem.toString()
        }
    }

    fun darBaixaItem() {
        print("Qual o código do item a dar baixa? ")
        val codigoItemADarBaixa = readln().toInt()
        for (item in listaItem) {
            if (codigoItemADarBaixa == item.codigo) {
                listaItem.remove(item)
                println("Item removido com sucesso")
                break
            }
        }
    }
}