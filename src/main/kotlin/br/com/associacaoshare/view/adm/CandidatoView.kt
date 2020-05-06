package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.HtmlBuilderView
import br.com.associacaoshare.view.base.SisInsAdmView
import io.javalin.http.Context
import kotlinx.html.*

class CandidatoView : SisInsAdmView() {
    override val pageTitle: String = "Candidato"

    override fun MAIN.renderMain(ctx: Context) {
        h3("João Victor Montefusco")

        h4 { +"Aluno" }
        article {
            p {
                b { +"Categoria:" }
                br { +" Pessoas com vínculo com a UFSCar." }
            }
            p {
                b { +"Vínculo:" }
                br { +" Aluno da Graduação" }
            }
            p {
                b { +"Data de nascimento:" }
                br { +" 20/10/1997" }
            }
            p {
                b { +"Telefone:" }
                br { +" 15)996073387" }
            }
            p {
                b { +"Email:" }
                br { +" joaovmontefusco@gmail.com" }
            }
        }

        h4 { +"Inscrição" }
        article {
            p {
                b { +"Esteve antes na UFSCar:" }
                br { +" Sim" }
            }
            p {
                b { +"Disponibilidade de tempo:" }
                br { +" Tranquilo" }
            }
            p {
                b { +"Objetivo com o curso:" }
                br { +" Aprender algo novo" }
            }
            p {
                b { +"Inscrição e outros cursos da Share:" }
                br { +" Sim, e fui chamado." }
            }
            p {
                b { +"Texte de por quê gostaria de fazer um curso na Share:" }
                br {
                    +"Lorem, ipsum dolor sit amet consectetur adipisicing elit. "
                    +"Dolores quibusdam soluta nam veniam qui voluptate eveniet "
                    +"inventore eos sint magnam non nemo, exercitationem, impedit "
                    +"magni tempora eum est dolorem enim."
                }
            }
            p {
                b { +"Por onde conheceu a Share:" }
                br { +" Recomendação" }
            }
        }

        form(classes = "botoes") {
            a(classes = "botao waves-effect waves-light green btn-large") {
                +"Aprovar"
            }
            a(classes = "botao waves-effect waves-light yellow btn-large") {
                +"Lista de espera"
            }
            a(classes = "botao waves-effect waves-light blue btn-large") {
                +"Desistência"
            }
            a(classes = "botao waves-effect waves-light red btn-large") {
                +"Reprovar"
            }

        }
    }
}
