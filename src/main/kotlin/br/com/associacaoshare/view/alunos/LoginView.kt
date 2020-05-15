package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class LoginView(private val errormsg: String?) : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Login"

    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_login.css")

        link(type = "text/css", rel = "stylesheet", href = "/css/alerts.css")
        if (!errormsg.isNullOrEmpty()) {
            div("materialert error") {
                div("material-icons") { +"error_outline" }
                +"$errormsg"
            }
        }

        div("row") {

            div("col s12 m12 l3 offset-l3") {
                div("card") {
                    div("card-image") {
                        img("Logo da Share", "../img/share-logo.png", "logo")
                    }
                }
            }
            div("center col s12 m12 l3") {
                div("caixa_login") {
                    div("lighten-4 row geral_login") {
                        form("dologin", classes = "col s12", method = FormMethod.post) {
                            div("row") {
                                div("input-field col s12") {
                                    input(InputType.text, classes = "validate", name = "user") {
                                        id = "user"
                                    }
                                    label() {
                                        htmlFor = "user"
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

                            button(type = ButtonType.submit, classes = "entrar waves-effect waves-light btn") {
                                +"Entrar"
                            }
                        }
                    }
                }

            }

        }
    }
}
