package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class ListaView : SisInsAlunoView() {
    override val pageTitle = "Lista de Inscrições"

    override fun BODY.renderBody(ctx: Context) {
        div("row") {
            div("col s12 m0 l3")
            div("col s12 m12 l3") {
                div("card") {
                    div("card-image") {
                        img("Logo da Share", "../img/share-logo.png", "logo")
                    }
                }
            }
            div("center col s12 m12 l3") {

                a("edicao 1.html", classes = "center atualizar waves-effect waves-light btn") {
                    +"Atualizar perfil"
                }
                h5 { +"Seus cursos:" }
                ul("collection with-header") {
                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("inscricoes2.html", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("prova.html", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }

                    li("collection-item") {
                        span("title") {
                            b { +"Violão" }
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") { +"add" }
                        }
                        p { +"Básico A - Quinta-feira, das 12:00 ás 13:00" }
                    }
                }
            }
        }
        div("col s12 m0 l3")
    }
}
