package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class InscricoesView : SisInsAdmView() {
    override val pageTitle: String = "Cursos"

    override fun MAIN.renderMain(ctx: Context) {
        h3("Inscrições")
        h4("Violão")
        h5("Básico A - Quinta-feira, das 12:00 às 13:00")

        div("row") {
            div("col 14 m3 s12")
            div("col 14 m6 s12") {
                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Aprovado"
                        }
                        a("candidato.html", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Aprovado"
                        }
                        a("candidato_prova.html", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Aprovado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Lista de espera"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Lista de espera"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Desistiu"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Reprovado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Reprovado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Não avalidado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Não avalidado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }

                ul("collection") {
                    li("collection-item avatar") {
                        i("material-icons circle green") {
                            +"account_circle"
                        }
                        span("title") {
                            +"João Victor Montefusco"
                        }
                        p {
                            +"Não avalidado"
                        }
                        a("#!", classes = "secondary-content") {
                            i("material-icons") {
                                +"edit"
                            }
                        }
                    }
                }
            }
        }
    }
}