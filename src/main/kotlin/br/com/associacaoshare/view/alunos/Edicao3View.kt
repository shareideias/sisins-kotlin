package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Edicao3View : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            script("text/javascript", "../js/materialize.min.js"){}
        }

        body {

            img("Logo da Share", "../img/share-logo.png", "logo")
            h3 { +"Inscrição" }
            div("row") {
                form(classes = "col s12") {
                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                            label {
                                +"Você já esteve na UFSCar antes?"
                            }
                            select {
                                option(){
                                    value="1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value = "2"
                                    +"Sim"
                                }
                                option() {
                                    value = "3"
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
                                +"Você está ciente de que as aulas da Share "
                                +"acontecem na UFSCar Sorocaba, próximo à Salto de Pirapora?"
                            }
                            select {
                                option(){
                                    value="1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value = "2"
                                    +"Sim"
                                }
                                option() {
                                    value = "3"
                                    +"Não"
                                }                            }
                        }
                        div("col s12 m4 l3")
                    }


                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m2 l3") {
                            label() {
                                htmlFor = "textarea1"
                                +"Como voce descreveria a sua disponibilidade de tempo atualmente?"
                            }
                            textArea(classes = "materialize-textarea") {
                                id = "textarea1"
                            }
                        }
                        div("col s12 m4 l3")
                    }

                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                            label {
                                +"Seu principal objetivo com o curso é:"
                            }
                            select {
                                option() {
                                    value = "1"
                                    disabled = true
                                    selected = true
                                }
                                option() {
                                    value = "2"
                                    +"Aprender algo novo"
                                }
                                option() {
                                    value = "3"
                                    +"Ter um hobby/me distrair"
                                }
                                option() {
                                    value = "4"
                                    +"Me atualizar para o mercado de trabalho"
                                }
                                option() {
                                    value = "5"
                                    +"Conhecer pessoas novas"
                                }
                                option() {
                                    value = "6"
                                    +"Conhecer mais sobre a área/ sanar minha curiosidade"
                                }
                                option() {
                                    value = "7"
                                    +"Me preparar para provas (vestibulares,  provas da faculdade)"
                                }
                                option() {
                                    value = "8"
                                    +"Me preparar para um intercâmbio"
                                }
                                option() {
                                    value = "9"
                                    +"Outro"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }
                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Voce já se inscreveu em algum curso da share?"
                                }
                            select {
                                option() {
                                    value = "1"
                                    disabled = true
                                    selected = true
                                }
                                option() {
                                    value = "2"
                                    +"Sim, e fui chamado"
                                }
                                option() {
                                    value = "3"
                                    +"Não"
                                }
                                option() {
                                    value = "4"
                                    +"Uma vez, e não fui chamado"
                                }
                                option() {
                                    value = "5"
                                    +"Mais de uma vez, e nunca fui chamado."
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }

                    div("row") {
                        div("col s12 m4 l3")
                        div("input-field col s12 m4 l6") {
                                label {
                                    +"Você está ciente de que desistir do curso, sem explicação "
                                    +"plausível, impossibilitará o candidato de se inscrever para "
                                    +"qualquer outro curso da Share, além de prejudicar sua turma?"

                                }
                            select {
                                option() {
                                    value = "1"
                                    disabled = true
                                    selected = true
                                }

                                option() {
                                    value = "2"
                                    +"Sim"
                                }
                                option() {
                                    value = "3"
                                    +"Não"
                                }
                            }
                        }
                        div("col s12 m4 l3")
                    }
                }
            }
            div("row") {
                a("edicao 4.html", "entrar waves-effect waves-light btn") {
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