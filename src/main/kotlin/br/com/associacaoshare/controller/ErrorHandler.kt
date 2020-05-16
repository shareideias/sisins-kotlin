package br.com.associacaoshare.controller

import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.exception.CamposVaziosException
import br.com.associacaoshare.model.exception.FalhaSessaoException
import br.com.associacaoshare.model.exception.UsuarioNaoEncontrado
import io.javalin.Javalin
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.net.URLEncoder.encode
import kotlin.text.Charsets.UTF_8

class ErrorHandler (override val kodein: Kodein) : KodeinAware {
    val dao: DataAccessObject by instance()

    fun Javalin.addErrorHandlers() {
        exception(org.jdbi.v3.core.statement.UnableToExecuteStatementException::class.java) {
            //Deu erro na execução de alguma query no BD
            e, ctx ->
                val s = (e.cause?.message)
                val messagemap = s?.split("\n")
                        ?.associate { it.split(": ")
                                .let { (first, last) -> first to last} }
                val message = messagemap?.get("ERROR") ?: "Um erro desconhecido ocorreu."
                ctx.cookie("errorMsg", encode(message, UTF_8))
                ctx.redirect(ctx.header("Referer") ?: "/")
        }

        exception(java.util.NoSuchElementException::class.java) {
            //Faltou um campo obrigatório
            e, ctx ->
                val message = (e.message) ?: "Um erro desconhecido ocorreu."
                ctx.cookie("errorMsg",encode(message, UTF_8))
                ctx.redirect(ctx.header("Referer") ?: "/")
        }

        exception(java.time.format.DateTimeParseException::class.java) {
            //Erro no parsing, pode não ter sido preenchido
            e, ctx ->
            val message = (e.message) ?: "Um erro desconhecido ocorreu."
            ctx.cookie("errorMsg",encode(message, UTF_8))
            ctx.redirect(ctx.header("Referer") ?: "/")
        }

        exception(FalhaSessaoException::class.java) {
            //Exception lançada pelo sisins para o usuário refazer a sessão no login
            e, ctx ->
            val message = (e.message) ?: "Um erro desconhecido ocorreu."
            ctx.cookie("errorMsg",encode(message, UTF_8))
            ctx.redirect("/login")
        }

        exception(CamposVaziosException::class.java) {
            //Exception lançada pelo sisins quando um campo obrigatório não foi preenchido
            e, ctx ->
            val message = (e.message) ?: "Um erro desconhecido ocorreu."
            ctx.cookie("errorMsg",encode(message, UTF_8))
            ctx.redirect(ctx.header("Referer") ?: "/")
        }

        exception(UsuarioNaoEncontrado::class.java) {
            e, ctx ->
            val message = (e.message) ?: "Um erro desconhecido ocorreu."
            ctx.cookie("errorMsg",encode(message, UTF_8))
            ctx.redirect("/login")
        }

        exception(Exception::class.java) {
            //Exception desconhecida
            e, ctx ->
            val message = (e.message) ?: "Um erro desconhecido ocorreu."
            println(message)
            println(e.stackTrace.toString())
            ctx.cookie("errorMsg",encode(message, UTF_8))
            ctx.redirect("/")
        }
    }
}