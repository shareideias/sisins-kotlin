package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Inscricoes3View  : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/inscricoes.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            link(href = "https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
        }

        body {
            header { header() }
            main { main() }
            scripts()
        }
    }

    private fun HEADER.header() {
        nav(classes = "nav-wrapper transparent") {
            div(classes = "container") {
                a(href = "cursos.html", classes = "brand-logo") {
                    img(classes = "imagem_logo", alt = "Logo da Share", src = "/img/globo.png")
                }
                a(href = "", classes = "sidenav-trigger") {
                    attributes["data-target"] = "mobile-menu"
                    i(classes = "material-icons") { +"menu" }
                }
                val links = dao.allLinks()

                ul(classes = "right hide-on-med-and-down") {
                    for (link in links) {
                        li { a(classes = "link_menu", href = link.href) { +link.nome } }
                    }
                }
                ul(classes = "sidenav lighten-2") {
                    id = "mobile-menu"

                    for (link in links) {
                        li { a(href = link.href) { +link.nome } }
                    }
                }
            }
        }
    }

    private fun MAIN.main() {
        h3("Inscrições")
        h4("Violão")
        h5("Básico A - Quinta-feira, das 12:00 às 13:00")

        content{
            div("row"){
                div("col 14 m3 s12")
                div("col 14 m6 s12"){
                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Aprovado"
                            }
                            a("candidato.html", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Aprovado"
                            }
                            a("candidato_prova.html", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Aprovado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Lista de espera"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Lista de espera"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Desistiu"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Reprovado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Reprovado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Não avalidado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Não avalidado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }

                    ul("collection"){
                        li("collection-item avatar"){
                            i("material-icons circle green"){
                                +"account_circle"
                            }
                            span("title"){
                                +"João Victor Montefusco"
                            }
                            p{
                                +"Não avalidado"
                            }
                            a("#!", classes = "secondary-content"){
                                i("material-icons"){
                                    +"edit"
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun BODY.scripts() {
        script(src = "/js/materialize.min.js") {}
        script {
            unsafe {
                +"""
                document.addEventListener('DOMContentLoaded', function() {
                    var elems = document.querySelectorAll('.sidenav');
                    var instances = M.Sidenav.init(elems, options);
                });
            """.trimIndent()
            }
        }
    }
}
