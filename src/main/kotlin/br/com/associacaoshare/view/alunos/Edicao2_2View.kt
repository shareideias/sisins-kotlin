package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Edicao2_2View  : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Cadastro Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            script("text/javascript", "../js/materialize.min.js"){}
        }

        body {

            img("Logo da Share", "../img/share-logo.png", "logo")
            h3{ +"Edição" }
            div("row") {
                form(classes = "col s12") {
                    div("row"){
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Nome completo"
                                }
                            input(InputType.text, classes = "validate"){
                                id ="name"
                            }
                        }
                        div("col s12 m4 l3")
                    }


                    div("row"){
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Qual o seu vínculo com a UFSCAR?"
                                }
                            select {
                                option(){
                                    value="1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value = "2"
                                    +"Professor"
                                }
                                option() {
                                    value = "3"
                                    +"Técnico-Administrativo (TAs)"
                                }
                                option() {
                                    value = "4"
                                    +"Aluno da Graduação"
                                }
                                option() {
                                    value = "5"
                                    +"Aluno da Pós Graduação"
                                }
                                option() {
                                    value = "6"
                                    +"Outro"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }


                    div("row"){
                        div("col s12 m4 l3")
                        div("input-field col s12 m2 l3") {
                                label() {
                                    htmlFor ="text"
                                    +"Data de nascimento"
                                }
                            input(InputType.text, classes = "text") {
                                id = "text"
                            }
                        }
                        div("input-field col s12 m2 l3"){
                                label(){
                                    htmlFor = "icon_telephone"
                                    +"DDD + telefone"
                                }
                            input(InputType.tel, classes = "validate"){
                                id = "icon_telephone"
                            }
                        }
                        div("col s12 m4 l3")
                    }

                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label() {
                                    htmlFor = "email"
                                    +"Email"
                                }
                            input(InputType.email, classes = "validate") {
                                id = "email"
                            }
                        }
                        div("col s12 m4 l3")
                    }
                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label() {
                                    htmlFor = "password"
                                    +"Senha"
                                }
                            input(InputType.password, classes = "validate") {
                                id = "password"
                            }
                        }
                        div("col s12 m4 l3")
                    }
                }
            }
            div("row"){
                a("edicao 3.html", "entrar waves-effect waves-light btn"){
                    +"Próximo"
                }
            }
            scripts()
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
