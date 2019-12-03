package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class Edicao1View : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            meta(charset = "utf-8")
            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/cadastro.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            script("text/javascript", "../js/materialize.min.js")
        }

        body {

            img("Logo da Share", "../img/share-logo.png", "logo")
            h3{ +"Edição" }
            div("row"){
                div("col s12 m4 l3")
                div("input-field col s12 m4 l6"){
                    container{
                        label{
                            +"Responda em qual categoria se encaixa"
                        }
                    }
                    select {
                        option(value="", disabled selected)
                        option(value="Pessoas com vínculo com a UFSCar."){
                            +"Pessoas com vínculo com a UFSCar."
                        }
                        option(value = "Alunos do terceiro ano do ensino médio (tendo no mínimo 16 anos)"){
                            +"Alunos do terceiro ano do ensino médio (tendo no mínimo 16 anos)"
                        }
                        option(value = "Pessoas que não possuem vínculo com a UFSCar"){
                            +"Pessoas que não possuem vínculo com a UFSCar"
                        }
                    }
                }
                div("col s12 m4 l3")
            }
            div("row"){
                a("edicao 2.1.html", "entrar waves-effect waves-light btn"){
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
