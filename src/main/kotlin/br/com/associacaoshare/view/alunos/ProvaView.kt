package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class ProvaView : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Prova"

    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_prova.css")
        img("Logo da Share", "../img/share-logo.png", "logo")
        h3 { +"Prova de nivelamento" }

        h6("justify flow-text") {
            +">A partir de agora você responderá um breve questionário que servirá para identificarmos "
            +"se você realmente possui o  conhecimento necessário para ingressar no nível intermediário ou avançado. "
            +"Fique tranquilo, pois mesmo que você não saiba responder a maioria das perguntas você ainda terá a vaga "
            +"garantida em um nível mais baixo, caso seja selecionado. Por ser uma prova apenas para avaliarmos seus conhecimentos "
            +"pedimos para que realmente deixe em branco as questões que você não souber."
        }
        h6 {
            +"1 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        h6 {
            +"2 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        h6 {
            +"3 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        h6 {
            +"4 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        h6 {
            +"5 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        h6 {
            +"6 - Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et "
            +"dolore magna aliqua."
        }
        form("#") {
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 1" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 2" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 3" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 4" }
                }
            }
            p {
                label {
                    input(InputType.radio, name = "group1", classes = "with-gap")
                    span { +"Alternativa 5" }
                }
            }
        }

        div(classes = "row") {
            a("inscricoes2.html", classes = "entrar waves-effect waves-light btn") {
                +"Enviar"
            }
        }
    }
}