package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CursosView : SisInsAdmView() {
    override val pageTitle: String = "Cursos"

    override fun MAIN.renderMain(ctx: Context) {
        h3("Cursos")

        div("container cards_recente") {
            div("row") {
                //Curso1
                article {
                    div("col m4 s12") {
                        div("card") {
                            div("card-content") {
                                span("card-title") {
                                    +"Violão"
                                    p("par_news") {
                                        +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                    }
                                }
                            }
                            div("card-action") {
                                a("inscricoes.html") {
                                    +"Inscrições"
                                }
                            }
                        }
                    }
                }
                //adicionar curso
                article {
                    div("col m4 s12") {
                        div("card") {
                            div("card-action mais") {
                                a("#") {
                                    +"+"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}