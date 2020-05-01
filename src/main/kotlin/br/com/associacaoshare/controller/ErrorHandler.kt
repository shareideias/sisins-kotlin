package br.com.associacaoshare.controller

import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.dao.JdbiDataAccessObject
import io.javalin.Javalin
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

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
                val message = messagemap?.get("ERROR")
                ctx.cookie("errorMsg", dao.unitoascii(message) ?: "Um erro desconhecido ocorreu")
                ctx.redirect(ctx.header("Referer") ?: "/")
        }

        exception(java.util.NoSuchElementException::class.java) {
            //Faltou um campo obrigatório
            e, ctx ->
                val message = (e.message)
                ctx.cookie("errorMsg",dao.unitoascii(message) ?: "Um erro desconhecido ocorreu.")
                ctx.redirect(ctx.header("Referer") ?: "/")
        }
    }
}