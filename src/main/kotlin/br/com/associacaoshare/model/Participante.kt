package br.com.associacaoshare.model

import br.com.associacaoshare.model.dao.DataAccessObject
import java.time.LocalDate

data class Participante(
    val id: Int,
    var categoria: Int,
    var nome: String,
    var data_nascimento: LocalDate,
    var telefone: String,
    var email: String,
    var hash: String,
    var tipo_sem_vinculo: Int,
    var vinculo_ufscar: Int,
    var escola: String,
    var esteve_ufscar: Int,
    var edital: Int,
    var onde_conheceu: Int,
    var local_aulas: Int,
    var disponibilidade: String,
    var objetivo: Int,
    var cursou_share: Int,
    var desistencia: Int,
    var redacao_entrada: String,

    var curso1_id: Int?,
    var data_inscricao_c1: LocalDate?,
    var resposta1_c1: Int?,
    var resposta2_c1: Int?,
    var resposta3_c1: Int?,
    var resposta4_c1: Int?,
    var resposta5_c1: Int?,
    var resposta6_c1: Int?,
    var avaliador_id_c1: Int?,
    var resultado_c1: Int? = -1,

    var curso2_id: Int?,
    var data_inscricao_c2: LocalDate?,
    var resposta1_c2: Int?,
    var resposta2_c2: Int?,
    var resposta3_c2: Int?,
    var resposta4_c2: Int?,
    var resposta5_c2: Int?,
    var resposta6_c2: Int?,
    var avaliador_id_c2: Int?,
    var resultado_c2: Int? = -1
) {
    fun hashPassword(password: String) {
        hash = DataAccessObject.hashPassword(password)
    }
}