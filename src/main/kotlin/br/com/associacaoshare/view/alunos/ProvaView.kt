package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class ProvaView : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/prova.css")

            meta("viewport", "width=device-width, initial-scale=1.0")
        }

        body {
            img("Logo da Share", "../img/share-logo.png", "logo")
            h3 { +"Prova de nivelamento" }

            h6("justify") {
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
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
            form("#"){
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 1" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 2" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 3" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 4" }
                    }
                }
                p{
                    label {
                        input(InputType.radio, name = "group1", classes = "with-gap")
                        span { +"Alternativa 5" }
                    }
                }
            }

            div(classes = "row"){
                a("inscricoes2.html", classes = "entrar waves-effect waves-light btn"){
                    +"Enviar"
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
