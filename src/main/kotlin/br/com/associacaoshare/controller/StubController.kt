package br.com.associacaoshare.controller

import br.com.associacaoshare.model.Avaliador
import br.com.associacaoshare.model.Participante
import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.exception.CamposVaziosException
import br.com.associacaoshare.view.alunos.*

import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.apibuilder.EndpointGroup
import io.javalin.http.Context
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.net.URLDecoder.decode
import kotlin.text.Charsets.UTF_8

class StubController(override val kodein: Kodein) : EndpointGroup, KodeinAware {
    val dao: DataAccessObject by instance()

    override fun addEndpoints() {
        get(::index)

        get("cadastro", ::cadastro)
        post("CadastroProc", ::cadastroProc)

        get("login", ::login)
        post("dologin", ::doLogin)

        path("adm") {
            AdminController(kodein).addEndpoints()
        }
        path("alunos") {
            AlunosController(kodein).addEndpoints()
        }
    }

    private fun index (ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if(errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        IndexView(errormsg).render(ctx)
    }

    private fun cadastro (ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if(errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        CadastroView(errormsg).render(ctx)
    }

    private fun cadastroProc (ctx: Context) {
        val resp = ctx.formParamMap()
        val novoParticipante: Participante = dao.insertParticipante(resp)
        ctx.redirect("/login")
    }

    private fun login (ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{decode(it , UTF_8)}
        if(errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        LoginView(errormsg).render(ctx)
    }

    private fun doLogin (ctx: Context) {
        val user = ctx.formParam("user") ?: ""
        val pass = ctx.formParam("password") ?: ""

        //Provavelmente não vai ocorrer, por causa da validação do front
        if(user.isEmpty()) {
            throw CamposVaziosException("usuário")
        }
        if(pass.isEmpty()) {
            throw CamposVaziosException("senha")
        }

        dao.getParticipantebyEmail(user)?.let { p ->
            if (p.hash == DataAccessObject.hashPassword(pass)) {
                loginRoutine(ctx, p)
                return
            }
        }

        /*
        dao.getParticipantebyEmail(user)?.let { p ->
            if (p.hash == DataAccessObject.hashPassword(pass)) {
                loginRoutine(ctx, p)
                return
            }
        }*/

        ctx.redirect("/login")
    }

    private fun loginRoutine(ctx: Context, obj: Avaliador) {
        ctx.sessionAttribute("ROLE", "AVALIADOR")
        ctx.sessionAttribute("ID", obj.id)
        ctx.redirect("/admin")
    }

    private fun loginRoutine(ctx: Context, obj: Participante) {
        ctx.sessionAttribute("ROLE", "PARTICIPANTE")
        ctx.sessionAttribute("ID", obj.id)
        ctx.redirect("/alunos")
    }
}