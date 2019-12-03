package br.com.associacaoshare.view.adm

import br.com.associacaoshare.view.base.HtmlBuilderView
import io.javalin.http.Context
import kotlinx.html.*

class CandidatoProvaView : HtmlBuilderView() {
    override fun HTML.render(ctx: Context) {
        head {
            title("Inscrição Share")

            link(rel = "icon", href = "/img/globo.png")
            meta(charset = "utf-8")

            link("https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            link(type = "text/css", rel = "stylesheet", href = "/css/materialize.min.css")
            link(type = "text/css", rel = "stylesheet", href = "../css/candidato_prova.css")

            meta("viewport", "width=device-width, initial-scale=1.0")

            link(href = "https://fonts.googleapis.com/icon?family=Material+Icons", rel = "stylesheet")
            meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
        }

        body {
            header { header() }
            main { main() }
            scripts()
        }
    }

    private fun HEADER.header() {
        nav(classes = "nav-wrapper transparent") {
            div(classes = "container") {
                a(href = "cursos.html", classes = "brand-logo") {
                    img(classes = "imagem_logo", alt = "Logo da Share", src = "/img/globo.png")
                }
                a(href = "", classes = "sidenav-trigger") {
                    attributes["data-target"] = "mobile-menu"
                    i(classes = "material-icons") { +"menu" }
                }
                val links = dao.allLinks()

                ul(classes = "right hide-on-med-and-down") {
                    for (link in links) {
                        li { a(classes = "link_menu", href = link.href) { +link.nome } }
                    }
                }
                ul(classes = "sidenav lighten-2") {
                    id = "mobile-menu"

                    for (link in links) {
                        li { a(href = link.href) { +link.nome } }
                    }
                }
            }
        }
    }

    private fun MAIN.main() {
        h3("João Victor Montefusco")

        h4{+"Aluno"}
        article {
            p{
                b{+"Categoria:"}
                br { +" Pessoas com vínculo com a UFSCar." }
            }
            p{
                b{+"Vínculo:"}
                br { +" Aluno da Graduação" }
            }
            p{
                b { +"Data de nascimento:" }
                br { +" 20/10/1997" }
            }
            p{
                b { +"Telefone:" }
                br { +" 15)996073387" }
            }
            p{
                b { +"Email:" }
                br { +" joaovmontefusco@gmail.com" }
            }
        }

        h4{+"Inscrição"}
        article {
            p{
                b { +"Esteve antes na UFSCar:" }
                br { +" Sim" }
            }
            p{
                b { +"Ciente de que as aulas acontecem na UFSCar Sorocaba:" }
                br { +" Sim" }
            }
            p{
                b { +"Disponibilidade de tempo:" }
                br { +" Tranquilo" }
            }
            p{
                b { +"Objetivo com o curso:" }
                br { +" Aprender algo novo" }
            }
            p{
                b { +"Inscrição e outros cursos da Share:" }
                br { +" Sim, e fui chamado." }
            }
            p{
                b { +"Ciência das consequências da desistências do curso:" }
                br { +" Sim" }
            }
            p{
                b { +"Texte de por quê gostaria de fazer um curso na Share:" }
                br {
                            +"Lorem, ipsum dolor sit amet consectetur adipisicing elit. "
                            +"Dolores quibusdam soluta nam veniam qui voluptate eveniet "
                            +"inventore eos sint magnam non nemo, exercitationem, impedit "
                            +"magni tempora eum est dolorem enim."
                }
            }
            p{
                b { +"Leitura do edital:" }
                br { +" Sim" }
            }
            p{
                b { +"Por onde conheceu a Share:" }
                br { +" Recomendação" }
            }
        }

        h4{+"Prova"}

        article {
            p{
                b { +"1-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
            p{
                b { +"2-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
            p{
                b { +"3-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
            p{
                b { +"4-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
            p{
                b { +"5-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
            p{
                b { +"6-Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." }
                br { +" Alternativa" }
            }
        }

        form( classes = "botoes"){
            a( classes = "botao waves-effect waves-light green btn-large"){
                +"Aprovar"
            }
            a( classes = "botao waves-effect waves-light yellow btn-large"){
                +"Lista de espera"
            }
            a( classes = "botao waves-effect waves-light blue btn-large"){
                +"Desistência"
            }
            a( classes = "botao waves-effect waves-light red btn-large"){
                +"Reprovar"
            }

            label("check"){
                input("checkbox")
                span{+"Continuar avaliando"}
            }
        }
    }

    private fun BODY.scripts() {
        script(src = "/js/materialize.min.js") {}
        script {
            unsafe {
                +"""
                document.addEventListener('DOMContentLoaded', function() {
                    var elems = document.querySelectorAll('.sidenav');
                    var instances = M.Sidenav.init(elems, options);
                });
            """.trimIndent()
            }
        }
    }

}