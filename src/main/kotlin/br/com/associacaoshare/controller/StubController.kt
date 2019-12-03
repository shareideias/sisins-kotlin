package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.CandidatoProvaView
import br.com.associacaoshare.view.adm.CandidatoView
import br.com.associacaoshare.view.adm.CursosView
import br.com.associacaoshare.view.adm.InscricoesView
import br.com.associacaoshare.view.alunos.*
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.EndpointGroup

class StubController : EndpointGroup {
    override fun addEndpoints() {
        path("adm") {
            get("CandidatoProvaView", CandidatoProvaView()::render)
            get("CandidatoView", CandidatoView()::render)
            get("CursosView", CursosView()::render)
            get("InscricoesView", InscricoesView()::render)
        }
        path("alunos") {
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
}