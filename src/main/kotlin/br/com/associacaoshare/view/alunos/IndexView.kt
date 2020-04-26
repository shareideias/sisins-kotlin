package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class IndexView : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Início"
    override fun BODY.renderBody(ctx: Context){
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_index.css")

        div("row"){
            div("col s12 m12 l3 offset-l3"){
                div("card"){
                    div("card-image"){
                        img("Logo da Share", "../img/share-logo.png", "logo1")
                    }
                }
            }
            div("center col s12 m12 l3"){
                a("cadastro 1.html", classes = "center cadastro waves-effect waves-light btn"){
                    +"Fazer cadastro"
                }
                br {
                    a("login.html", classes = "center login waves-effect waves-light btn"){
                        +"Já tenho cadastro"
                    }
                }
            }
        }
    }

}
