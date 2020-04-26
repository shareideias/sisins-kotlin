package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class CadastroView : SisInsAlunoView() {
    override val pageTitle = "Cadastro"

    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_cadastro.css")
        img("Logo da Share", "../img/share-logo.png", "logo")
        h3 { +"Cadastro" }

        div("row") {
            form(classes = "col s12", method = FormMethod.post) {

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputCategoria"
                            +"Responda em qual categoria se encaixa"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputCategoria"
                            name = "categoria"
                            value = "1"
                            label {
                                radioInput(name = "categoria")
                                span { +"Pessoas com vínculo com a UFSCar." }
                            }
                        }

                        input(InputType.radio, classes = "validate") {
                            id = "inputCategoria"
                            name = "categoria"
                            value = "2"
                            label {
                                radioInput(name = "categoria")
                                span("alternativas") { +"Alunos do terceiro ano do ensino médio (tendo no mínimo 16 anos)" }
                            }
                        }

                        input(InputType.radio, classes = "validate") {
                            id = "inputCategoria"
                            name = "categoria"
                            value = "3"
                            label {
                                radioInput(name = "categoria")
                                span { +"Pessoas que não possuem vínculo com a UFSCar" }
                            }
                        }
                    }
                }


                div("input-field col s12 mb-0") {
                    label("perguntas"){
                        htmlFor = "inputNome"
                        +"Nome completo"
                    }
                    input(InputType.text, classes = "validate") {
                        id = "inputNome"
                        name = "nome"
                    }
                }

                div("input-field col s12 mb-0 perguntas") {
                    +"Data de nascimento(idade mínima: 16 anos)"
                    label{
                        htmlFor = "inputData_nascimento"

                    }
                    input(InputType.date , classes = "validate") {
                        id = "inputData_nascimento"
                        name = "data_nascimento"
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas"){
                        htmlFor = "inputTelefone"
                        +"DDD + telefone"
                    }
                    input(InputType.tel, classes = "validate") {
                        id = "inputTelefone"
                        name = "telefone"
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas"){
                        htmlFor = "inputEmail"
                        +"Email"
                    }
                    input(InputType.email , classes = "validate") {
                        id = "inputEmail"
                        name = "email"
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas"){
                        htmlFor = "inputPassword"
                        +"Senha"
                    }
                    input(InputType.password, classes = "validate") {
                        id = "inputPassword"
                        name = "password"
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputTipo_sem_vinculo"
                            +"Você é estudante? E/ou trabalha?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputTipo_sem_vinculo"
                            name = "tipo_sem_vinculo"
                            value = "1"
                            label {
                                radioInput(name = "tipo_sem_vinculo")
                                span { +"Trabalho e não estudo" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputTipo_sem_vinculo"
                            name = "tipo_sem_vinculo"
                            value = "2"
                            label {
                                radioInput(name = "tipo_sem_vinculo")
                                span{ +"Não trabalho e estudo" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputTipo_sem_vinculo"
                            name = "tipo_sem_vinculo"
                            value = "3"
                            label {
                                radioInput(name = "tipo_sem_vinculo")
                                span { +"Não estudo e não trabalho" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputTipo_sem_vinculo"
                            name = "tipo_sem_vinculo"
                            value = "4"
                            label {
                                radioInput(name = "tipo_sem_vinculo")
                                span { +"Estudo e trabalho" }
                            }
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputVinculoUfscar"
                            +"Qual o seu vínculo com a UFSCAR?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "1"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Professor" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "2"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Técnico-Administrativo (TAs)" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "3"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Aluno da Graduação" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "4"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Aluno da Pós Graduação" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "5"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Outro" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputVinculoUfscar"
                            name = "vinculo_ufscar"
                            value = "6"
                            label {
                                radioInput(name = "vinculo_ufscar")
                                span { +"Nenhum" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0 perguntas") {
                    +"Escola em que estuda e cidade (Se for aluno do ensino médio) "
                    label{
                        htmlFor = "inputEscola"

                    }
                    input(InputType.text , classes = "validate") {
                        id = "inputEscola"
                        name = "escola"
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputEdital"
                            +"Você leu atentamento o edital?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputEdital"
                            name = "edital"
                            value = "1"
                            label {
                                radioInput(name = "edital")
                                span("alternativas") { +"Sim, li e estou ciente dos termos do processo seletivo." }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputEdital"
                            name = "Edital"
                            value = "2"
                            label {
                                radioInput(name = "edital")
                                span{ +"Não" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputOnde_conheceu"
                            +"Por onde conheceu a share?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputOnde_conheceu"
                            name = "onde_conheceu"
                            value = "1"
                            label {
                                radioInput(name = "onde_conheceu")
                                span { +"Mídias sociais (Facebook, Whatsapp, etc)" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputOnde_conheceu"
                            name = "onde_conheceu"
                            value = "2"
                            label {
                                radioInput(name = "onde_conheceu")
                                span { +"Recomendação" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputOnde_conheceu"
                            name = "onde_conheceu"
                            value = "3"
                            label {
                                radioInput(name = "onde_conheceu")
                                span { +"Outras mídias (jornais, revistas, televisão)" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputOnde_conheceu"
                            name = "onde_conheceu"
                            value = "4"
                            label {
                                radioInput(name = "onde_conheceu")
                                span { +"Outros" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputEsteve_ufscar"
                            +"Você já esteve na UFSCar antes?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputEsteve_ufscar"
                            name = "esteve_ufscar"
                            value = "1"
                            label {
                                radioInput(name = "esteve_ufscar")
                                span { +"Sim" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputEsteve_ufscar"
                            name = "esteve_ufscar"
                            value = "2"
                            label {
                                radioInput(name = "esteve_ufscar")
                                span { +"Não" }
                            }
                        }
                        br

                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputLocal_aulas"
                            +"Você está ciente de que as aulas da Share acontecem na UFSCar Sorocaba, próximo à Salto de Pirapora?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputLocal_aulas"
                            name = "local_aulas"
                            value = "1"
                            label {
                                radioInput(name = "local_aulas")
                                span { +"Sim" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputLocal_aulas"
                            name = "local_aulas"
                            value = "2"
                            label {
                                radioInput(name = "local_aulas")
                                span { +"Não" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0 perguntas") {
                    +"Como voce descreveria a sua disponibilidade de tempo atualmente?"
                    label{
                        htmlFor = "inputDisponibilidade"

                    }
                    input(InputType.text , classes = "validate") {
                        id = "inputDisponibilidade"
                        name = "disponibilidade"
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputObjetivo"
                            +"Seu principal objetivo com o curso é:"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "1"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Aprender algo novo" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "2"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Ter um hobby/me distrair" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "3"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Me atualizar para o mercado de trabalho" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "4"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Conhecer pessoas novas" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "5"
                            label {
                                radioInput(name = "objetivo")
                                span("alternativas") { +"Conhecer mais sobre a área/ sanar minha curiosidade" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "6"
                            label {
                                radioInput(name = "objetivo")
                                span("alternativas") { +"Me preparar para provas (vestibulares, provas da faculdade)" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "7"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Me preparar para um intercâmbio" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputObjetivo"
                            name = "objetivo"
                            value = "8"
                            label {
                                radioInput(name = "objetivo")
                                span { +"Outro" }
                            }
                        }
                        br


                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputCursou_share"
                            +"Voce já se inscreveu em algum curso da share?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputCursou_share"
                            name = "cursou_share"
                            value = "1"
                            label {
                                radioInput(name = "cursou_share")
                                span { +"Sim e fui chamado" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputCursou_share"
                            name = "cursou_share"
                            value = "2"
                            label {
                                radioInput(name = "cursou_share")
                                span { +"Não" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputCursou_share"
                            name = "cursou_share"
                            value = "3"
                            label {
                                radioInput(name = "cursou_share")
                                span { +"Uma vez, e não fui chamado" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputCursou_share"
                            name = "cursou_share"
                            value = "4"
                            label {
                                radioInput(name = "cursou_share")
                                span { +"Mais de uma vez, e nunca fui chamado" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0") {
                    p {
                        label("perguntas") {
                            htmlFor = "inputDesistencia"
                            +"Você está ciente de que desistir do curso, sem explicação plausível, impossibilitará o candidato de se inscrever para qualquer outro curso da Share, além de prejudicar sua turma?"
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputDesistencia"
                            name = "desistencia"
                            value = "1"
                            label {
                                radioInput(name = "desistencia")
                                span { +"Sim" }
                            }
                        }
                        br

                        input(InputType.radio, classes = "validate") {
                            id = "inputDesistencia"
                            name = "desistencia"
                            value = "2"
                            label {
                                radioInput(name = "desistencia")
                                span { +"Não" }
                            }
                        }
                        br
                    }
                }

                div("input-field col s12 mb-0 perguntas") {
                    +"Para finalizar, pedimos para que você escreva entre 5 e 10 linhas por que gostaria de fazer um curso na Share. Lembre-se, esse é um dos critérios mais importantes para ser selecionado (exceto: curso português)."
                    label{
                        htmlFor = "inputRedacao_entrada"

                    }
                    input(InputType.text , classes = "validate") {
                        id = "inputRedacao_entrada"
                        name = "redacao_entrada"
                    }
                }
                button(type = ButtonType.submit, classes = "entrar waves-effect waves-light btn") {
                    id = "btnParte4Cadastrar"
                    +"Cadastrar"
                }
            }
        }


        script {
            unsafe {
                +"""
                document.addEventListener('DOMContentLoaded', function() {
                    M.Datepicker.init(document.querySelectorAll('.datepicker'), { format: 'dd/mm/yyyy' });
                });
                """.trimIndent()
            }
        }
    }
}