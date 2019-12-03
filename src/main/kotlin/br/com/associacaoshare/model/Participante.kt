package br.com.associacaoshare.model

import java.time.LocalDate

data class Participante(
    val id: String?,
    var categoria: Int?,
    var nome: String,
    var data_nascimento: LocalDate,
    var telefone: String,
    var email: String,
    var senha: String,
    var vinculo_ufscar: Int? = -1,
    var escola: String?,
    var tipo_sem_vinculo: Int? = -1,
    var esteve_ufscar: Int,
    var disponibilidade: String,
    var objetivo: Int? = -1,
    var cursou_share: Int?,
    var redacao_entrada: String,
    var onde_conheceu: Int?,

    var curso1_id: Int?,
    var data_inscricao_c1: LocalDate?,
    var resposta1_c1: Int?,
    var resposta2_c1: Int?,
    var resposta3_c1: Int?,
    var resposta4_c1: Int?,
    var resposta5_c1: Int?,
    var resposta6_c1: Int?,
    var avaliador_id_c1: Int?,
    var data_avaliacao_c1: LocalDate?,
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
    var data_avaliacao_c2: LocalDate?,
    var resultado_c2: Int? = -1
);