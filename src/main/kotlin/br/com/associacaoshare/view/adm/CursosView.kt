package br.com.associacaoshare.view.adm

import br.com.associacaoshare.model.Curso
import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CursosView(private val errormsg: String?, private val cursos: List<Curso>) : SisInsAdmView() {
    override val pageTitle: String = "Cursos"

    override fun MAIN.renderMain(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/alerts.css")
        if (!errormsg.isNullOrEmpty()) {
            div("materialert error") {
                div("material-icons") { +"error_outline" }
                +"$errormsg"
            }
        }

        h3{+"Cursos"}

        div("container cards_recente") {
            div("row") {
                cursos.forEach {
                    article("borda-curso") {
                        div("col m4 s12") {
                            div("card") {
                                div("card-content") {
                                    span("card-title") {
                                        +it.nome
                                        p("par_news") {
                                            +"${it.categoria} - ${it.horario}"
                                        }
                                    }
                                }
                                div("card-action") {
                                    a("/adm/inscricoes?id=${it.id}") {
                                        +"Inscrições"
                                    }
                                    br{}
                                    a("#?id=${it.id}") {
                                        +"Editar curso"
                                    }
                                    br{}
                                    a("#?id=${it.id}") {
                                        +"Excluir curso"
                                    }
                                }
                            }
                        }
                    }
                }
                //adicionar curso
                article("borda-curso") {
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