package br.com.associacaoshare.view.base

import io.javalin.http.Context
import kotlinx.html.*

abstract class SisInsAlunoView : HtmlBuilderView() {
    abstract val pageTitle: String

    override fun HTML.render(ctx: Context) {
        head {
            meta(charset = "utf-8")
            meta("viewport", "width=device-width, initial-scale=1.0")

            title("Sistema de Inscrições · $pageTitle")

            link(rel = "icon", href = "/img/globo.png")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "/css/sisins_aluno.css")

            script("text/javascript", "/js/materialize.min.js") {}
        }

        body {
            renderBody(ctx)
        }
    }

    abstract fun BODY.renderBody(ctx: Context)
}