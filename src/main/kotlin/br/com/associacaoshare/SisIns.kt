package br.com.associacaoshare

import br.com.associacaoshare.controller.ErrorHandler
import br.com.associacaoshare.controller.SisinsAccessManager
import br.com.associacaoshare.controller.StubController
import br.com.associacaoshare.model.dao.DataAccessObject
import br.com.associacaoshare.model.dao.JdbiDataAccessObject
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import org.kodein.di.Kodein
import org.kodein.di.generic.*

fun main() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8080

    val kodein = Kodein {
        bind<ObjectMapper>() with singleton { jacksonObjectMapper() }
        bind<DataAccessObject>() with eagerSingleton { JdbiDataAccessObject("jdbc:postgresql:shareideias") }
        bind<Algorithm>() with provider {
            Algorithm.HMAC256(System.getenv("secret") ?: "shareinstituto_is_very_secret")
        }
        bind<JWTVerifier>() with provider {
            JWT.require(instance())
                .withIssuer("associacaoshare")
                .build()
        }
    }

    val app = Javalin.create { cfg ->
        cfg.addStaticFiles("public")
        cfg.accessManager(SisinsAccessManager())
    }

    ErrorHandler(kodein).run { app.addErrorHandlers() }
    app.routes(StubController(kodein)).start(port)
}