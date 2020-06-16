package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.model.Participante
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class Prova2View(private val errormsg: String?, private val participante: Participante) : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Prova"

    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_prova.css")

        link(type = "text/css", rel = "stylesheet", href = "/css/alerts.css")
        if (!errormsg.isNullOrEmpty()) {
            div("materialert error") {
                div("material-icons") { +"error_outline" }
                +"$errormsg"
            }
        }

        img("Logo da Share", "../img/share-logo.png", "logo")
        h3 { +"Prova de nivelamento" }


        h6("justify flow-text") {
            span(classes = "textinho") {
                +"A partir de agora você responderá um breve questionário que servirá para identificarmos "
                +"se você realmente possui o  conhecimento necessário para ingressar no nível intermediário ou avançado. "
                +"Fique tranquilo, pois mesmo que você não saiba responder a maioria das perguntas você ainda terá a vaga "
                +"garantida em um nível mais baixo, caso seja selecionado. Por ser uma prova apenas para avaliarmos seus conhecimentos "
                +"pedimos para que realmente deixe em branco as questões que você não souber."
            }
        }

        form("ProvaProc2", method = FormMethod.post) {
            h6 {
                +"1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta1_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta1_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta1_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta1_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta1_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }

            h6 {
                +"2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }

            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta2_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta2_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta2_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta2_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta2_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }


            h6 {
                +"3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }

            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta3_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta3_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta3_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta3_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta3_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }


            h6 {
                +"4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }

            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta4_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta4_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta4_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta4_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta4_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }


            h6 {
                +"5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }

            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta5_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta5_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta5_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta5_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta5_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }


            h6 {
                +"6 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
                +"dolore magna aliqua."
            }

            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt1"
                        name = "resposta6_c2"
                        value = "1"
                    }
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt2"
                        name = "resposta6_c2"
                        value = "2"
                    }
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt3"
                        name = "resposta6_c2"
                        value = "3"
                    }
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt4"
                        name = "resposta6_c2"
                        value = "4"
                    }
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, classes = "with-gap") {
                        id = "alt5"
                        name = "resposta6_c2"
                        value = "5"
                    }
                    span { +"Alternativa 5" }
                }
            }


            div(classes = "row") {
                button(type = ButtonType.submit, classes = "entrar waves-effect waves-light btn") {
                    +"Enviar"
                }
            }
        }
    }
}