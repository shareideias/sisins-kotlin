package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.*
import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class AdminController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        ApiBuilder.get("CadastrarCursoView", CadastrarCursoView()::render)
        ApiBuilder.get("CadastrarProvaView", CadastrarProvaView()::render)
        ApiBuilder.get("CandidatoProvaView", CandidatoProvaView()::render)
        ApiBuilder.get("CandidatoView", CandidatoView()::render)
        ApiBuilder.get("CursosView", CursosView()::render)
        ApiBuilder.get("InscricoesView", InscricoesView()::render)
    }
}