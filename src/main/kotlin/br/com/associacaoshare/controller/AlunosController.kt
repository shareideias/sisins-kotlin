package br.com.associacaoshare.controller

import br.com.associacaoshare.view.alunos.*
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import io.javalin.apibuilder.ApiBuilder.get

class AlunosController (override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        get("CadastroView", CadastroView()::render)
        get("EdicaoView", EdicaoView()::render)
        get("IndexView", IndexView()::render)
        get("Inscricoes1View", Inscricoes1View()::render)
        get("Inscricoes2View", Inscricoes2View()::render)
        get("ListaView", ListaView()::render)
        get("LoginView", LoginView()::render)
        get("ProvaView", ProvaView()::render)
    }
}