package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class LoginView : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Login"

    override fun BODY.renderBody(ctx: Context) {
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
}
