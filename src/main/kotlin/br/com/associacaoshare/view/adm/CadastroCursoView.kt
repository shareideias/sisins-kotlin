package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CadastroCursoView : SisInsAdmView() {
    override val pageTitle: String = "Cadastro de curso"

    override fun MAIN.renderMain(ctx: Context) {
        h3 { +"Cadastrar curso" }

        div("row rowzeras") {
            form(classes = "col s12") {

                div(classes = "row") {
                    div(classes = "input-field col s12") {
                        input(classes = "validate") {
                            id = "first_name"
                        }
                        label {
                            htmlFor = "first_name"
                            +"Nome do curso"
                        }
                    }
                }

                div(classes = "row") {
                    div(classes = "input-field col s12") {
                        input(classes = "validate") {
                            id = "first_name"
                        }
                        label {
                            htmlFor = "first_name"
                            +"Horário"
                        }
                    }
                }


                h6{
                    +"Precisa de prova de nivelamento?"
                }
                form("#") {
                    p {
                        label {
                            input(InputType.radio, name = "group1", classes = "with-gap")
                            span { +"Sim" }
                        }
                    }
                    p {
                        label {
                            input(InputType.radio, name = "group1", classes = "with-gap")
                            span { +"Não" }
                        }
                    }
                }

                div(classes = "row") {
                    a("#", classes = "entrar waves-effect waves-light btn") {
                        +"Cadastrar"
                    }
                }

            }
        }


    }
}