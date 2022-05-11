package src.menu

import src.estoque.Estoque
import kotlin.system.exitProcess

class Menu {
    fun menuPrincipal(estoque: Estoque) {

        println("O que deseja fazer?")
        println("1 - Cadastrar novo item")
        println("2 - Ver lista de itens disponíveis para compra")
        println("3 - Dar baixa em um item")
        println("4 - Sair do programa")

        try {
            val opcao = readln().toInt()

            when (opcao) {
                1 -> {
                    estoque.registrarItem()
                    this.menuPrincipal(estoque)
                }
                2 -> {
                    estoque.listarItens()
                    this.menuPrincipal(estoque)
                }
                3 -> {
                    estoque.darBaixaItem()
                    this.menuPrincipal(estoque)
                }

                4 -> exitProcess(0)
                else -> {
                    println("Opção inválida, tente novamente")
                    menuPrincipal(estoque);
                }
            }
        }catch (e: Exception){
            println("Opção inválida, digite novamente")
            menuPrincipal(estoque)
        }
    }
}