package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.CandidatoProvaView
import br.com.associacaoshare.view.adm.CandidatoView
import br.com.associacaoshare.view.adm.CursosView
import br.com.associacaoshare.view.adm.InscricoesView
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class AdminController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        get("CandidatoProvaView", CandidatoProvaView()::render)
        get("CandidatoView", CandidatoView()::render)
        get("CursosView", CursosView()::render)
        get("InscricoesView", InscricoesView()::render)
    }
}