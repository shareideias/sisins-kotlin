package br.com.associacaoshare.view.base

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class IndexView(val dao: MainDao) : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/index.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {
            main { main() }
        }
    }

    private fun MAIN.main() {
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
                a("cadastro 1.html", classes = "center cadastro waves-effect waves-light btn"){
                    +"Fazer cadastro"
                }
                br {
                    a("login.html", classes = "center login waves-effect waves-light btn"){
                        +"Já tenho cadastro"
                    }
                }
            }
            div("col s12 m0 l3")
        }
    }

}
