package br.com.associacaoshare.controller

import br.com.associacaoshare.view.adm.*
import br.com.associacaoshare.controller.SisinsAccessManager.Roles.*
import br.com.associacaoshare.model.Curso
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
        get("CandidatoProvaView", CandidatoProvaView()::render, roles(AVALIADOR))


        get(::cursos, roles(AVALIADOR))
        get("inscricoes", ::inscricoes, roles(AVALIADOR))

        get("inscricoesgerais", ::inscricoesgerais, roles(AVALIADOR))

        get("candidato", ::candidato, roles(AVALIADOR))
        post("CandidatoProc", ::candidatoProc, roles(AVALIADOR))

        get("perfildocandidato", ::perfildocandidato, roles(AVALIADOR))
        post("EdicaoSenha", ::EdicaoSenha, roles(AVALIADOR))

        get("addCurso", ::addCurso, roles(AVALIADOR))
        post("adicionaCurso", ::adicionaCurso, roles(AVALIADOR))
        get("addProva", ::addProva, roles(AVALIADOR))
        post("adicionaProva", ::adicionaProva, roles(AVALIADOR))

        get("excluircurso", ::excluircurso, roles(AVALIADOR))
        get("cursoexcluido", ::cursoexcluido, roles(AVALIADOR))

        get("editarcurso", ::editarcurso, roles(AVALIADOR))
        post("cursoeditado", ::cursoeditado, roles(AVALIADOR))
        get("editarprova", ::editarprova, roles(AVALIADOR))
        post("provaeditada", ::provaeditada, roles(AVALIADOR))
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

    private fun candidato(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val candidato = ctx.queryParam("id")?.toInt()?.let{dao.getParticipante(it)}

        val curso = ctx.queryParam("idC")?.toInt()?.let{dao.getCurso(it)}
        /*if (curso == null) {
            ctx.redirect("/adm")
            return
        }*/
        CandidatoView(errormsg, candidato, curso).render(ctx)
    }

    private fun candidatoProc(ctx: Context){
        val r1 = ctx.formParam("resultado_c1")
        val r2 = ctx.formParam("resultado_c2")
        val participante = ctx.sessionAttribute<Int?>("ID")?.let { dao.getParticipante(it) }
        if(participante != null) {
            dao.updateAvaliacaoParticipante(participante, r1?.toInt(), r2?.toInt())
        }
        ctx.redirect("/adm")
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

    private fun addCurso(ctx: Context) {
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        CadastroCursoView(errormsg).render(ctx)
    }

    private fun adicionaCurso(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        val resp = ctx.formParamMap()
        val novoCurso: Curso = dao.insertCurso(resp)

        if(novoCurso.categoria == "1")
            ctx.redirect("addProva?id=${novoCurso.id}")
        else
            ctx.redirect("/adm")
    }

    private fun addProva(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}

        CadastrarProvaView(errormsg, curso).render(ctx)
    }

    private fun adicionaProva(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}
        val resp = ctx.formParamMap()

        if (curso != null) {
            curso.atualizaProva(resp)
            dao.updateCurso(curso)
        }

        ctx.redirect("/adm")

    }

    private fun excluircurso(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}
        if (curso != null) {
            ExcluirCursoView(errormsg, curso).render(ctx)
        }
    }

    private fun cursoexcluido(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}

        if (curso != null) {
            dao.removeCurso(curso.id)
        }

        ctx.redirect("/adm")
    }

    private fun editarcurso(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}
        if (curso != null) {
            EdicaoCursoView(errormsg, curso).render(ctx)
        }
    }

    private fun cursoeditado(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        val resp = ctx.formParamMap()
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}

        if (curso != null) {
            curso.atualizaDados(resp)
            dao.updateCurso(curso)
        }

        if (curso != null) {
            if(curso.categoria == "1"){
                ctx.redirect("editarprova?id=${curso?.id}")
            } else if(curso.categoria == "2"){
                ctx.redirect("/adm")
            }
        }
    }

    private fun editarprova(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}
        if (curso != null) {
            EdicaoProvaView(errormsg, curso).render(ctx)
        }
    }

    private fun provaeditada(ctx: Context){
        val errormsg = ctx.cookie("errorMsg")?.let{ URLDecoder.decode(it, Charsets.UTF_8) }
        if (errormsg != null)
            ctx.cookie("errorMsg", "", 0)

        val resp = ctx.formParamMap()
        val curso = ctx.queryParam("id")?.toInt()?.let{dao.getCurso(it)}

        if (curso != null) {
            curso.atualizaProva(resp)
            dao.updateCurso(curso)
        }

        ctx.redirect("/adm")
    }
}