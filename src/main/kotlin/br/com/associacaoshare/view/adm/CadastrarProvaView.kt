package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CadastrarProvaView : SisInsAdmView() {
    override val pageTitle: String = "Cadastro de Prova de nivelamento"

    override fun MAIN.renderMain(ctx: Context) {
        h3{
         +"Criação da Prova de nivelamento"}


        div(classes = "row") {
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta 1"
                }
            }
        }


    }
}