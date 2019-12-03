package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Inscricoes1View : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/inscricoes.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {
            main { main() }
            scripts()
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
                a("edicao 1.html", classes = "center atualizar waves-effect waves-light btn"){
                    +"Atualizar perfil"
                }
                h5 { +"Seus cursos:" }
                ul("collection with-header"){
                    li("collection-item"){
                        div {
                            i { +"Curso não selecionado" }
                            a("lista.html", classes = "secondary-content") {
                                i("material-icons") { +"add" }
                            }
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

    //JavaScript para animação e validação de email e senha
    private fun BODY.scripts() {
        script("text/javascript", "../js/materialize.min.js")
    }

}
