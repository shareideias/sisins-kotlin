package br.com.associacaoshare.controller

import br.com.associacaoshare.controller.SisinsAccessManager.Roles.*
import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.exception.FalhaSessaoException
import br.com.associacaoshare.view.alunos.*
import io.javalin.apibuilder.EndpointGroup
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.core.security.SecurityUtil.roles
import io.javalin.http.Context
import org.kodein.di.generic.instance
import java.net.URLDecoder.decode
import kotlin.text.Charsets.UTF_8

class AlunosController (override val kodein: Kodein) : EndpointGroup, KodeinAware {
    val dao: DataAccessObject by instance()

    override fun addEndpoints() {
        get("editar", ::edicao, roles(PARTICIPANTE))
        post("EditaProc", ::edicaoProc, roles(PARTICIPANTE))

        get(::inscricoes, roles(PARTICIPANTE))

        get("ListaView", ::lista, roles(PARTICIPANTE))
        get("ProvaView", ::prova, roles(PARTICIPANTE))
    }

    private fun edicao (ctx: Context) {
        val participante = ctx.sessionAttribute<Int?>("ID")?.let { dao.getParticipante(it) }
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        if(participante != null) {
            EdicaoView(errormsg, participante).render(ctx)
        } else {
            throw FalhaSessaoException()
        }
    }

    private fun edicaoProc (ctx: Context) {
        val resp = ctx.formParamMap()
        val participante = ctx.sessionAttribute<Int?>("ID")?.let { dao.getParticipante(it) }
        if(participante != null) {
            participante.atualizaDados(resp)
            dao.updateParticipante(participante)
        }
        ctx.redirect("/alunos")
    }

    private fun inscricoes (ctx: Context) {
        val participante = ctx.sessionAttribute<Int?>("ID")?.let { dao.getParticipante(it) }
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        if(participante != null) {
            InscricoesAlunoView(errormsg).render(ctx)
        } else {
            throw FalhaSessaoException()
        }
    }

    private fun lista (ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        ListaView(errormsg)
    }

    private fun prova (ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        ProvaView(errormsg)
    }
}