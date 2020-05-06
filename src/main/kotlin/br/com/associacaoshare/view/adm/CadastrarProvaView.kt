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
                    id = "inputPergunta1"
                }
                label {
                    htmlFor = "inputPergunta1"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa11"
                }
                label {
                    htmlFor = "inputAlternativa11"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa12"
                }
                label {
                    htmlFor = "inputAlternativa12"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa13"
                }
                label {
                    htmlFor = "inputAlternativa13"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa14"
                }
                label {
                    htmlFor = "inputAlternativa14"
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
                    id = "inputPergunta2"
                }
                label {
                    htmlFor = "inputPergunta2"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa21"
                }
                label {
                    htmlFor = "inputAlternativa21"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa22"
                }
                label {
                    htmlFor = "inputAlternativa22"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa23"
                }
                label {
                    htmlFor = "inputAlternativa23"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa24"
                }
                label {
                    htmlFor = "inputAlternativa24"
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
                    id = "inputPergunta3"
                }
                label {
                    htmlFor = "inputPergunta3"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa31"
                }
                label {
                    htmlFor = "inputAlternativa31"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa32"
                }
                label {
                    htmlFor = "inputAlternativa32"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa33"
                }
                label {
                    htmlFor = "inputAlternativa33"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa34"
                }
                label {
                    htmlFor = "inputAlternativa34"
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
                    id = "inputPergunta4"
                }
                label {
                    htmlFor = "inputPergunta4"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa41"
                }
                label {
                    htmlFor = "inputAlternativa41"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa42"
                }
                label {
                    htmlFor = "inputAlternativa42"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa43"
                }
                label {
                    htmlFor = "inputAlternativa43"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa44"
                }
                label {
                    htmlFor = "inputAlternativa44"
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
                    id = "inputPergunta5"
                }
                label {
                    htmlFor = "inputPergunta5"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa51"
                }
                label {
                    htmlFor = "inputAlternativa51"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa52"
                }
                label {
                    htmlFor = "inputAlternativa52"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa53"
                }
                label {
                    htmlFor = "inputAlternativa53"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa54"
                }
                label {
                    htmlFor = "inputAlternativa54"
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
                    id = "inputPergunta6"
                }
                label {
                    htmlFor = "inputPergunta6"
                    +"Pergunta"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa61"
                }
                label {
                    htmlFor = "inputAlternativa61"
                    +"Alternativa 1"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa62"
                }
                label {
                    htmlFor = "inputAlternativa62"
                    +"Alternativa 2"
                }
            }

            div(classes = "input-field col s12") {
                input(classes = "validate") {
                    id = "inputAlternativa63"
                }
                label {
                    htmlFor = "inputAlternativa63"
                    +"Alternativa 3"
                }
            }

            div(classes = "input-field col s12 ultima_alt") {
                input(classes = "validate") {
                    id = "inputAlternativa64"
                }
                label {
                    htmlFor = "inputAlternativa64"
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