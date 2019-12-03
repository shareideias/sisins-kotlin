package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class LoginView : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/login.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {
            main { main() }
            scripts()
        }
    }

    private fun MAIN.main() {
        div("row") {
            div("col s12 m0 l3")
            div("col s12 m12 l3") {
                div("card") {
                    div("card-image") {
                        img("Logo da Share", "../img/share-logo.png", "logo")
                    }
                }
            }
            div("center col s12 m12 l3") {
                div("caixa_login") {
                    div("lighten-4 row geral_login") {
                        form(classes = "col s12", method = FormMethod.post) {
                            div("row") {
                                div("input-field col s12") {
                                    input(InputType.email, classes = "validate", name = "email") {
                                        id = "email"
                                    }
                                    label() {
                                        htmlFor = "email"
                                        +"Email"
                                    }
                                }
                            }

                            div("row") {
                                div("input-field col s12") {
                                    input(InputType.password, classes = "validate", name = "password") {
                                        id = "password"
                                    }
                                    label() {
                                        htmlFor = "password"
                                        +"Senha"
                                    }
                                }
                            }

                            div("row") {
                                a("inscricoes.html", classes = "center entrar waves-effect waves-light btn") { +"Entrar" }
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
        script("text/javascript", "../js/materialize.min.js"){}
    }

}
