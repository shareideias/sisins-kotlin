package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CadastrarProvaView : SisInsAdmView() {
    override val pageTitle: String = "Cadastro de Prova de nivelamento"

    override fun MAIN.renderMain(ctx: Context) {
        h3{
         +"Criação da Prova de nivelamento"}


        div(classes = "row rowzeras") {
            //Pergunta 1
            h4{
                +"Pergunta 1"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 1

            //Pergunta 2
            h4{
                +"Pergunta 2"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 2

            //Pergunta 3
            h4{
                +"Pergunta 3"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 3

            //Pergunta 4
            h4{
                +"Pergunta 4"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 4

            //Pergunta 5
            h4{
                +"Pergunta 5"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 5

            //Pergunta 6
            h4{
                +"Pergunta 6"
            }
            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "first_name"
                }
                label {
                    htmlFor = "first_name"
                    +"Alternativa 4"
                }
            }
            //fim Pergunta 6


            //botao
            div(classes = "row") {
                a("#", classes = "entrar waves-effect waves-light btn") {
                    +"Cadastrar"
                }
            }
            //fim botao
        }


    }
}