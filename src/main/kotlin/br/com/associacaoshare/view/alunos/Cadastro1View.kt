package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Cadastro1View(val parte: Parte) : HtmlBuilderView() {
    enum class Parte {
        PARTE_1, PARTE_2_1, PARTE_2_2, PARTE_2_3, PARTE_3, PARTE_4
    }

    override fun HTML.render(ctx: Context) {
        head {
            title("Cadastro Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            script("text/javascript", "../js/materialize.min.js") {}
        }

        body {
            img("Logo da Share", "../img/share-logo.png", "logo")
            h3 { +"Cadastro" }
            div("container") {
                div("input-field") {
                    label {
                        htmlFor = "selectCategoria"
                        +"Responda em qual categoria se encaixa"
                    }
                    select {
                        id = "selectCategoria"
                        name = "categoria"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Pessoas com vínculo com a UFSCar."
                        }
                        option {
                            value = "2"
                            +"Alunos do terceiro ano do ensino médio (tendo no mínimo 16 anos)"
                        }
                        option {
                            value = "3"
                            +"Pessoas que não possuem vínculo com a UFSCar"
                        }
                    }
                }
                a("cadastro 2.1.html", "entrar waves-effect waves-light btn") {
                    +"Próximo"
                }
            }
            script {
                unsafe {
                    +"""
                document.addEventListener('DOMContentLoaded', function() {
                    var elems = document.querySelectorAll('.datepicker');
                    var instances = M.Datepicker.init(elems, options);
                  });
                """.trimIndent()
                }
            }
        }
    }
}
