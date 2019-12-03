package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Cadastro4View : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Cadastro Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {

            img("Logo da Share", "../img/share-logo.png", "logo")
            h3 { +"Cadastro" }
            div("row") {
                form(classes = "col s12") {
                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                            h6 {
                                +"Para finalizar, pedimos para que você escreva entre 5 e 10 "
                                +"linhas por que gostaria de fazer um curso na Share. Lembre-se, esse é um "
                                +"dos critérios mais importantes para ser selecionado (exceto: curso português)."
                            }
                            textArea(classes = "materialize-textarea", id = "textarea1")
                            label(for= "textarea1")
                        }
                        div("col s12 m4 l3")
                    }

                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Você leu atentamente o edital?"
                                }
                            select {
                                option(value = "", disabled selected)
                                option(value = "Sim, e fui chamado") {
                                    +"Sim, li e estou ciente dos termos do processo seletivo."
                                }
                                option(value = "Não") {
                                    +"Não"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }

                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Por onde conheceu a Share?"
                                }
                            select {
                                option(value = "", disabled selected)
                                option(value = "Mídias Sociais (Facebook, Whatsapp, etc)") {
                                    +"Mídias Sociais (Facebook, Whatsapp, etc)"
                                }
                                option(value = "Recomendação") {
                                    +"Recomendação"
                                }
                                option(value = "Outras Mídias (Jornais, Revistas, Televisão)") {
                                    +"Outras Mídias (Jornais, Revistas, Televisão)"
                                }
                                option(value = "Outro") {
                                    +"Outro"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }
                }

            }
            div("row") {
                a("login.html", "entrar waves-effect waves-light btn") {
                    +"Cadastrar"
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
