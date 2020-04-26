package br.com.associacaoshare.controller

import br.com.associacaoshare.view.alunos.*

import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class StubController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    override fun addEndpoints() {
        path("adm") {
            AdminController(kodein).addEndpoints()
        }
        path("alunos") {
            AlunosController(kodein).addEndpoints()
        }
    }
}