package br.com.associacaoshare.controller

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
        get("CadastroView", CadastroView()::render)
        post("CadastroProc", ::cadastroProc)

        get("EdicaoView", EdicaoView()::render)
        get("IndexView", IndexView()::render)
        get("Inscricoes1View", Inscricoes1View()::render)
        get("Inscricoes2View", Inscricoes2View()::render)
        get("ListaView", ListaView()::render)
        get("LoginView", LoginView()::render)
        get("ProvaView", ProvaView()::render)
    }

    private fun cadastroProc (ctx: Context) {
        val resp = ctx.formParamMap()
        println(resp)

        dao.insertParticipante(resp)
    }
}