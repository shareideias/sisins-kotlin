package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Edicao4View : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {

            img("Logo da Share", "../img/share-logo.png", "logo")
            h3 { +"Edição" }
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
                            textArea(classes = "materialize-textarea"){
                                id = "textarea1"
                            }
                            label(){
                                htmlFor = "textarea1"
                            }
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
                                option(){
                                    value="1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value="2"
                                    +"Sim, li e estou ciente dos termos do processo seletivo."
                                }
                                option() {
                                    value="3"
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
                                option(){
                                    value="1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value="2"
                                    +"Mídias Sociais (Facebook, Whatsapp, etc)"
                                }
                                option() {
                                    value="3"
                                    +"Recomendação"
                                }
                                option() {
                                    value="4"
                                    +"Outras Mídias (Jornais, Revistas, Televisão)"
                                }
                                option() {
                                    value="5"
                                    +"Outro"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }
                }

            }
            div("row") {
                a("inscricoes.html", "entrar waves-effect waves-light btn") {
                    +"Salvar"
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
