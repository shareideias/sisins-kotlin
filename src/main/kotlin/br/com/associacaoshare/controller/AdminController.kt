package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.CandidatoProvaView
import br.com.associacaoshare.view.adm.CandidatoView
import br.com.associacaoshare.view.adm.CursosView
import br.com.associacaoshare.view.adm.InscricoesView
import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class AdminController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        ApiBuilder.get("CandidatoProvaView", CandidatoProvaView()::render)
        ApiBuilder.get("CandidatoView", CandidatoView()::render)
        ApiBuilder.get("CursosView", CursosView()::render)
        ApiBuilder.get("InscricoesView", InscricoesView()::render)
    }
}