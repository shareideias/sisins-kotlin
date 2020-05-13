package br.com.associacaoshare.controller

import br.com.associacaoshare.model.Participante
import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.exception.FalhaSessaoException
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

        get("editar", ::edicao)
        post("EditaProc", ::edicaoProc)

        get("inscricoes", ::inscricoes)

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
        ctx.redirect("/alunos/login")
    }

    private fun login (ctx: Context) {
        LoginView().render(ctx)
    }

    private fun edicao (ctx: Context) {
        /* TODO: Alterar o redirect baseado no determinado.
        *        Alterar a obtenção do id do usuario pela implementação do login.
         */
        val participante = ctx.sessionAttribute<Int?>("id_usuario")?.let { dao.getParticipante(it) }
        val errormsg = dao.asciitouni(ctx.cookie("errorMsg"))
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        if(participante != null) {
            EdicaoView(errormsg, participante).render(ctx)
        } else {
            throw FalhaSessaoException()
            ctx.redirect("/alunos/login")
        }
    }

    private fun edicaoProc (ctx: Context) {
        /* TODO: Alterar o redirect baseado no determinado.
        *        Alterar a obtenção do id do usuario pela implementação do login.
         */
        val resp = ctx.formParamMap()
        val participante = ctx.sessionAttribute<Int?>("id_usuario")?.let { dao.getParticipante(it) }
        if(participante != null) {
            participante.atualizaDados(resp)
            dao.updateParticipante(participante)
        }
        //Onde redirecionar após edição?
        ctx.redirect("/alunos")
    }

    private fun inscricoes (ctx: Context) {
        /* TODO: Alterar o redirect baseado no determinado.
        *        Alterar a obtenção do id do usuario pela implementação do login.
         */
        val participante = ctx.sessionAttribute<Int?>("id_usuario")?.let { dao.getParticipante(it) }
        val errormsg = dao.asciitouni(ctx.cookie("errorMsg"))
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        if(participante != null) {
            InscricoesAlunoView(errormsg).render(ctx)
        } else {
            throw FalhaSessaoException()
        }
    }
}