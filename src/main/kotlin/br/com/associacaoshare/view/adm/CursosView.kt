package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class CursosView  : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cursos.css")

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
        h3("Cursos")

        content{
            div("container cards_recente"){
                div("row"){
                    //Curso1
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("inscricoes.html"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso2
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso3
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso4
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso5
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso6
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso7
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso8
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso9
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso10
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso11
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso12
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso13
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso14
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso15
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso16
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso17
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso18
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso19
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso20
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso21
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso22
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso23
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso24
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso25
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso26
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso27
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //Curso28
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-content"){
                                    span("card-title"){
                                        +"Violão"
                                        p("par_news"){
                                            +"Básico A - Quinta-feira, das 12:00 às 13:00"
                                        }
                                    }
                                }
                                div("card-action"){
                                    a("#"){
                                        +"Inscrições"
                                    }
                                }
                            }
                        }
                    }

                    //adicionar curso
                    article {
                        div("col 14 m4 s12"){
                            div("card"){
                                div("card-action mais"){
                                    a("#"){
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