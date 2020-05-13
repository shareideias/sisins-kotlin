package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class InscricoesAlunoView(private val errormsg: String?)  : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Inscrição Share"
    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_inscricoes.css")

        link(type = "text/css", rel = "stylesheet", href = "/css/alerts.css")
        if (!errormsg.isNullOrEmpty()) {
            div("materialert error") {
                div("material-icons") { +"error_outline" }
                +"$errormsg"
            }
        }

        div("row"){
            div("col s12 m0 l3")
            div("col s12 m12 l3"){
                div("card"){
                    div("card-image"){
                        img("Logo da Share", "../img/share-logo.png", "logo")
                    }
                }
            }
            div("center col s12 m12 l3"){
                a("edicao", classes = "center atualizar waves-effect waves-light btn"){
                    +"Atualizar perfil"
                }
                h5 { +"Seus cursos:" }
                ul("collection with-header"){
                    li("collection-item"){
                        span("title") {
                            b { +"Violão" }
                            a("inscricoes.html", classes = "secondary-content") {
                                i("material-icons") { +"delete" }
                            }
                            p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                        }
                    }
                    li("collection-item"){
                        div {
                            i { +"Curso não selecionado" }
                            a("#!", classes = "secondary-content") {
                                i("material-icons") { +"add" }
                            }
                        }
                    }
                }
            }
            div("col s12 m0 l3")
        }
    }
}
