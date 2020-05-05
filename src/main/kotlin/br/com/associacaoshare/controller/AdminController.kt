package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.*
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class AdminController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        get("CadastrarCursoView", CadastroCursoView()::render)
        get("CadastrarProvaView", CadastrarProvaView()::render)
        get("CandidatoProvaView", CandidatoProvaView()::render)
        get("CandidatoView", CandidatoView()::render)
        get("CursosView", CursosView()::render)
        get("InscricoesView", InscricoesView()::render)
    }
}