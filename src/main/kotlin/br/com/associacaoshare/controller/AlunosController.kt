package br.com.associacaoshare.controller

import br.com.associacaoshare.model.Participante
import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.view.alunos.*
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.http.Context
import org.kodein.di.generic.instance

class AlunosController (override val kodein: Kodein) : EndpointGroup, KodeinAware {
    val dao: DataAccessObject by instance()

    override fun addEndpoints() {
        get(::index)

        get("cadastro", ::cadastro)
        post("CadastroProc", ::cadastroProc)

        get("login", ::login)

        get("EdicaoView", EdicaoView()::render)
        get("Inscricoes1View", Inscricoes1View()::render)
        get("Inscricoes2View", Inscricoes2View()::render)
        get("ListaView", ListaView()::render)
        get("ProvaView", ProvaView()::render)
    }

    private fun index (ctx: Context) {
        IndexView().render(ctx)
    }

    private fun cadastro (ctx: Context) {
        var errormsg = dao.asciitouni(ctx.cookie("errorMsg"))
        if(errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        CadastroView(errormsg).render(ctx)
    }

    private fun cadastroProc (ctx: Context) {
        val resp = ctx.formParamMap()
        val novoParticipante: Participante = dao.insertParticipante(resp)
        ctx.redirect("/alunos/LoginView")
    }

    private fun login (ctx: Context) {
        LoginView().render(ctx)
    }
}