package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class IndexView : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Início"
    override fun BODY.renderBody(ctx: Context) {
        div("row"){
            div("col s12 m0 l3")
            div("col s12 m12 l3"){
                div("card"){
                    div("card-image"){
                        img("Logo da Share", "../img/share-logo.png", "logo")
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
            div("col s12 m0 l3")
        }
    }

}
