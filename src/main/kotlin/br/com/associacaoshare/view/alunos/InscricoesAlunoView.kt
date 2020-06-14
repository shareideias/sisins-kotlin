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

        header{
            nav("nav-wrapper transparent") {
                div("container") {
                    /*a("brand-logo") {
                        img("Logo da Share", "/img/navbar-brand.png", "share-brand")
                    }*/
                    a("#", classes = "sidenav-trigger") {
                        attributes["data-target"] = "mobile-menu"
                        i("material-icons") { +"menu" }
                    }

                    ul("right hide-on-med-and-down") {
                        li {
                            a("/logout", classes = "link_menu") { +"Logout" }
                        }
                    }
                    ul("sidenav lighten-2") {
                        id = "mobile-menu"
                        li {
                            a("/logout", classes = "link_menu") { +"Logout" }
                        }
                    }
                }
            }
        }


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
                a("/alunos/editar", classes = "center atualizar waves-effect waves-light btn"){
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
                            a("/alunos/ListaView/", classes = "secondary-content") {
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
