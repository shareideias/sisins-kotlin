package br.com.associacaoshare.view.alunos

import br.com.associacaoshare.view.base.SisInsAlunoView
import io.javalin.http.Context
import kotlinx.html.*

class EdicaoView : SisInsAlunoView() {
    override val pageTitle = "Edição"

    override fun BODY.renderBody(ctx: Context) {
        img("Logo da Share", "../img/share-logo.png", "logo")
        h3 { +"Edição" }
        form(method = FormMethod.post) {
            div("container") {
                div {
                    id = "parte1"
                    parte1()
                }
                div("hide") {
                    id = "parte2"
                    parte2()
                }
                div("hide") {
                    id = "parte21"
                    parte21()
                }
                div("hide") {
                    id = "parte22"
                    parte22()
                }
                div("hide") {
                    id = "parte23"
                    parte23()
                }
                div("hide") {
                    id = "parte2F"
                    parte2F()
                }
                div("hide") {
                    id = "parte3"
                    parte3()
                }
                div("hide") {
                    id = "parte4"
                    parte4()
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

    private fun DIV.parte1() {
        div("input-field") {
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
        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte1Proximo"
            +"Próximo"
        }
    }

    private fun DIV.parte2() {
        div("input-field") {
            label {
                htmlFor = "inputNome"
                +"Nome completo"
            }
            input(InputType.text, classes = "validate") {
                id = "inputNome"
                name = "nome"
            }
        }
        div("input-field") {
            label {
                htmlFor = "inputDataNasc"
                +"Data de nascimento"
            }
            input(InputType.text, classes = "datepicker") {
                id = "inputDataNasc"
            }
        }
        div("input-field") {
            label {
                htmlFor = "inputTelefone"
                +"DDD + telefone"
            }
            input(InputType.tel, classes = "validate") {
                id = "inputTelefone"
            }
        }
        div("input-field") {
            label {
                htmlFor = "inputEmail"
                +"Email"
            }
            input(InputType.email, classes = "validate") {
                id = "inputEmail"
            }
        }
        div("input-field") {
            label {
                htmlFor = "inputPassword"
                +"Senha"
            }
            input(InputType.password, classes = "validate") {
                id = "inputPassword"
            }
        }
    }

    private fun DIV.parte21() {
        div("input-field") {
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
    }

    private fun DIV.parte22() {
        div("input-field") {
            label {
                +"Escola em que estuda e cidade"
                htmlFor = "inputEscola"
            }
            input(InputType.text, classes = "validate") {
                id = "inputEscola"
                name = "escola"
            }
        }
    }

    private fun DIV.parte23() {
        div("input-field") {
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
    }

    private fun DIV.parte2F() {
        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte2Voltar"
            +"Voltar"
        }
        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte2Proximo"
            +"Próximo"
        }
    }

    private fun DIV.parte3() {
        div("input-field") {
            label {
                htmlFor = "selectEsteveUfscar"
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

        div("input-field") {
            label {
                htmlFor = "inputDisponibilidade"
                +"Como voce descreveria a sua disponibilidade de tempo atualmente?"
            }
            textArea(classes = "materialize-textarea") {
                id = "inputDisponibilidade"
                name = "disponibilidade"
            }
        }

        div("input-field") {
            label {
                htmlFor = "selectObjetivo"
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

        div("input-field") {
            label {
                htmlFor = "selectCursouShare"
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

        label {
            htmlFor = "checkboxLocalAulas"
            checkBoxInput {
                id = "checkboxLocalAulas"
                name = "checkLocalAulas"
                required = true
            }
            +"Eu estou ciente de que as aulas da Share acontecem na UFSCar Sorocaba, próximo à Salto de Pirapora."
        }

        label {
            htmlFor = "checkboxDesistencia"
            checkBoxInput {
                id = "checkboxDesistencia"
                name = "checkDesistencia"
                required = true
            }

            +"Eu estou ciente de que desistir do curso, sem explicação plausível, "
            +"me impossibilitará de se inscrever para qualquer outro curso da Share, além de prejudicar minha turma."
        }

        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte3Voltar"
            +"Voltar"
        }
        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte3Proximo"
            +"Próximo"
        }
    }

    private fun DIV.parte4() {
        div("input-field") {
            label {
                +"Por onde conheceu a Share?"
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

        div("input-field") {
            h6 {
                +"Para finalizar, pedimos para que você escreva entre 5 e 10 "
                +"linhas por que gostaria de fazer um curso na Share. Lembre-se, esse é um "
                +"dos critérios mais importantes para ser selecionado (exceto: curso português)."
            }
            textArea(classes = "materialize-textarea") {
                name = "redacao_entrada"
            }
        }

        label {
            htmlFor = "checkboxEdital"
            checkBoxInput {
                id = "checkboxEdital"
                name = "checkEdital"
                required = true
            }

            +"Li o edital e estou ciente dos termos do processo seletivo."
        }

        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte4Voltar"
            +"Voltar"
        }
        button(type = ButtonType.button, classes = "waves-effect waves-light btn") {
            id = "btnParte4Cadastrar"
            +"Cadastrar"
        }
    }
}