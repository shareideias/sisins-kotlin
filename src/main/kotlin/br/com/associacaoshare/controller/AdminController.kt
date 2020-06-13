package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.*
import br.com.associacaoshare.controller.SisinsAccessManager.Roles.*
import br.com.associacaoshare.model.dao.DataAccessObject
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.apibuilder.EndpointGroup
import io.javalin.core.security.SecurityUtil.roles
import io.javalin.http.Context
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.net.URLDecoder

class AdminController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    val dao: DataAccessObject by instance()

    override fun addEndpoints() {
        get("CadastrarCursoView", CadastroCursoView()::render, roles(AVALIADOR))
        get("CadastrarProvaView", CadastrarProvaView()::render, roles(AVALIADOR))
        get("CandidatoProvaView", CandidatoProvaView()::render, roles(AVALIADOR))
        get("CandidatoView", CandidatoView()::render, roles(AVALIADOR))

        get(::cursos, roles(AVALIADOR))
        get("inscricoes", ::inscricoes, roles(AVALIADOR))

        get("inscricoesgerais", ::inscricoesgerais, roles(AVALIADOR))

        get("perfildocandidato", ::perfildocandidato, roles(AVALIADOR))
        post("EdicaoSenha", ::EdicaoSenha, roles(AVALIADOR))

    }

    private fun cursos(ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        CursosView(errormsg, dao.allCurso()).render(ctx)
    }

    private fun inscricoes(ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}
        if (curso == null) {
            ctx.redirect("/adm")
            return
        }
        val inscritos = dao.getParticipantesbyCurso(curso.id)
        InscricoesView(errormsg, curso, inscritos).render(ctx)
    }

    private fun inscricoesgerais(ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        val inscritos = dao.allParticipante()
        InscricoesGeraisView(errormsg, inscritos).render(ctx)
    }

    private fun perfildocandidato(ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val participante = ctx.queryParam("id")?.toInt()?.let{dao.getParticipante(it)}
        if (participante == null) {
            ctx.redirect("/adm")
            return
        }
        PerfilCandidatoView(errormsg, participante).render(ctx)
    }

    private fun EdicaoSenha (ctx: Context) {
        val resp = ctx.formParamMap()
        val id = ctx.formParam("id") ?: ""
        val participante = ctx.sessionAttribute<Int?>("ID")?.let { dao.getParticipante(id.toInt()) }

        if (participante != null) {
            participante.atualizaSenha(resp)
            dao.updateParticipante(participante)
        }

        ctx.redirect("inscricoesgerais")
    }
}