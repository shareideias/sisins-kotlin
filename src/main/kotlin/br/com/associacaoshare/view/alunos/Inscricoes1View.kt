package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class Inscricoes1View : SisInsAlunoView() {
    override val pageTitle: String
        get() = "Inscrição Share"

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
                a("edicao 1.html", classes = "center atualizar waves-effect waves-light btn"){
                    +"Atualizar perfil"
                }
                h5 { +"Seus cursos:" }
                ul("collection with-header"){
                    li("collection-item"){
                        div {
                            i { +"Curso não selecionado" }
                            a("lista.html", classes = "secondary-content") {
                                i("material-icons") { +"add" }
                            }
                        }
                    }
                    li("collection-item"){
                        div {
                            i { +"Curso não selecionado" }
                            a("#!", classes = "secondary-content") {
                                i("material-icons") { +"add" }
                            }
                        }
                    }
                }
            }
            div("col s12 m0 l3")
        }
    }
}
