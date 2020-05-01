package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class CadastroView (private val errormsg: String?) : SisInsAlunoView() {
    override val pageTitle = "Cadastro"

    override fun BODY.renderBody(ctx: Context) {
        link(type = "text/css", rel = "stylesheet", href = "/css/sisins_cadastro.css")
        link(type = "text/css", rel = "stylesheet", href = "/css/alerts.css")
        if (errormsg != null) {
            /*
            <div class="materialert error">
                <div class="material-icons">error_outline</div>
                Oh! What a beautiful alert :)
            </div>
             */
            div("materialert error") {
                div("material-icons") { +"error_outline" }
                +"$errormsg"
            }
        }
        img("Logo da Share", "../img/share-logo.png", "logo")
        h3 { +"Cadastro" }

        div("row") {
            form("CadastroProc", classes = "col s12", method = FormMethod.post) {

                div("input-field col s12 mb-0") {
                    label {
                        htmlFor = "selectCategoria"
                        +"Responda em qual categoria se encaixa"
                    }
                    select {
                        id = "selectCategoria"
                        name = "categoria"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Pessoas com vínculo com a UFSCar."
                        }
                        option {
                            value = "2"
                            +"Alunos do terceiro ano do ensino médio (tendo no mínimo 16 anos)"
                        }
                        option {
                            value = "3"
                            +"Pessoas que não possuem vínculo com a UFSCar"
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
                    +"Data de nascimento (idade mínima: 16 anos)"
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
                    label {
                        htmlFor = "selectTipoSemVinculo"
                        +"Você é estudante? E/ou trabalha?"
                    }
                    select {
                        id = "selectTipoSemVinculo"
                        name = "tipo_sem_vinculo"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Trabalho e não estudo"
                        }
                        option {
                            value = "2"
                            +"Não trabalho e estudo"
                        }
                        option {
                            value = "3"
                            +"Não estudo e não trabalho"
                        }
                        option {
                            value = "4"
                            +"Estudo e trabalho"
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label {
                        htmlFor = "selectVinculoUfscar"
                        +"Qual o seu vínculo com a UFSCAR?"
                    }
                    select {
                        id = "selectVinculoUfscar"
                        name = "vinculo_ufscar"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Professor"
                        }
                        option {
                            value = "2"
                            +"Técnico-Administrativo (TAs)"
                        }
                        option {
                            value = "3"
                            +"Aluno da Graduação"
                        }
                        option {
                            value = "4"
                            +"Aluno da Pós Graduação"
                        }
                        option {
                            value = "5"
                            +"Outro"
                        }
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
                    label("perguntas") {
                        htmlFor = "inputEdital"
                        +"Você leu atentamento o edital?"
                    }

                    select {
                        id = "selectEdital"
                        name = "edital"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Sim, li e estou ciente dos termos do processo seletivo."
                        }
                        option {
                            value = "2"
                            +"Não"
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas") {
                        htmlFor = "inputOnde_conheceu"
                        +"Por onde conheceu a share?"
                    }
                    select {
                        id = "selectOndeConheceu"
                        name = "onde_conheceu"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Mídias Sociais (Facebook, Whatsapp, etc)"
                        }
                        option {
                            value = "2"
                            +"Recomendação"
                        }
                        option {
                            value = "3"
                            +"Outras Mídias (Jornais, Revistas, Televisão)"
                        }
                        option {
                            value = "4"
                            +"Outro"
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas") {
                        htmlFor = "inputEsteve_ufscar"
                        +"Você já esteve na UFSCar antes?"
                    }
                    select {
                        id = "selectEsteveUfscar"
                        name = "esteve_ufscar"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Sim"
                        }
                        option {
                            value = "2"
                            +"Não"
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas") {
                        htmlFor = "inputLocal_aulas"
                        +"Você está ciente de que as aulas da Share acontecem na UFSCar Sorocaba, próximo à Salto de Pirapora?"
                    }

                    select {
                        id = "selectLocal_aulas"
                        name = "local_aulas"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Sim"
                        }
                        option {
                            value = "2"
                            +"Não"
                        }
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
                    label("perguntas") {
                        htmlFor = "inputObjetivo"
                        +"Seu principal objetivo com o curso é:"
                    }
                    select {
                        id = "selectObjetivo"
                        name = "objetivo"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Aprender algo novo"
                        }
                        option {
                            value = "2"
                            +"Ter um hobby/me distrair"
                        }
                        option {
                            value = "3"
                            +"Me atualizar para o mercado de trabalho"
                        }
                        option {
                            value = "4"
                            +"Conhecer pessoas novas"
                        }
                        option {
                            value = "5"
                            +"Conhecer mais sobre a área/ sanar minha curiosidade"
                        }
                        option {
                            value = "6"
                            +"Me preparar para provas (vestibulares,  provas da faculdade)"
                        }
                        option {
                            value = "7"
                            +"Me preparar para um intercâmbio"
                        }
                        option {
                            value = "8"
                            +"Outro"
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas") {
                        htmlFor = "inputCursou_share"
                        +"Voce já se inscreveu em algum curso da share?"
                    }
                    select {
                        id = "selectCursouShare"
                        name = "cursou_share"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Sim, e fui chamado"
                        }
                        option {
                            value = "2"
                            +"Não"
                        }
                        option {
                            value = "3"
                            +"Uma vez, e não fui chamado"
                        }
                        option {
                            value = "4"
                            +"Mais de uma vez, e nunca fui chamado."
                        }
                    }
                }

                div("input-field col s12 mb-0") {
                    label("perguntas") {
                        htmlFor = "selectDesistencia"
                        +"Você está ciente de que desistir do curso, sem explicação plausível, impossibilitará o candidato de se inscrever para qualquer outro curso da Share, além de prejudicar sua turma?"
                    }

                    select {
                        id = "selectDesistencia"
                        name = "desistencia"
                        option {
                            disabled = true
                            selected = true
                            value = ""
                        }
                        option {
                            value = "1"
                            +"Sim"
                        }
                        option {
                            value = "2"
                            +"Não"
                        }
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
        script("text/javascript", "/js/materialize.min.js") {}
        script("text/javascript", "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js") {}
        script("text/javascript", "https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js") {}
        script("text/javascript", "/js/selector.js") {}
    }

}
