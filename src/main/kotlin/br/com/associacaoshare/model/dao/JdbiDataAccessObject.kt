package br.com.associacaoshare.model.dao

import br.com.associacaoshare.model.Avaliador
import br.com.associacaoshare.model.Curso
import br.com.associacaoshare.model.Participante
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.*
import org.jdbi.v3.jackson2.Jackson2Config
import org.jdbi.v3.jackson2.Jackson2Plugin
import org.jdbi.v3.postgres.PostgresPlugin
import java.time.LocalDate
import java.time.OffsetDateTime

class JdbiDataAccessObject(url: String) : DataAccessObject {
    val jdbi = Jdbi.create(url)
            .installPlugin(PostgresPlugin())
            .installPlugin(Jackson2Plugin())
            .installPlugin(KotlinPlugin())
            .apply { getConfig(Jackson2Config::class.java).mapper.registerKotlinModule() }

    init {
        jdbi.useHandleUnchecked {
            it.execute("""
                CREATE TABLE IF NOT EXISTS sisins_avaliador(
                    id SERIAL PRIMARY KEY,
                    username TEXT NOT NULL,
                    senha TEXT NOT NULL,
                    nome TEXT NOT NULL
                )
                """.trimIndent())

            it.execute("""
                CREATE TABLE IF NOT EXISTS sisins_curso(
                    id SERIAL PRIMARY KEY,
                    nome TEXT NOT NULL,
                    categoria TEXT NOT NULL,
                    horario TEXT NOT NULL,
                    pergunta1 TEXT,
                    pergunta2 TEXT,
                    pergunta3 TEXT,
                    pergunta4 TEXT,
                    pergunta5 TEXT,
                    pergunta6 TEXT,
                    alternativa11 TEXT,
                    alternativa12 TEXT,
                    alternativa13 TEXT,
                    alternativa14 TEXT,
                    alternativa15 TEXT,
                    alternativa21 TEXT,
                    alternativa22 TEXT,
                    alternativa23 TEXT,
                    alternativa24 TEXT,
                    alternativa25 TEXT,
                    alternativa31 TEXT,
                    alternativa32 TEXT,
                    alternativa33 TEXT,
                    alternativa34 TEXT,
                    alternativa35 TEXT,
                    alternativa41 TEXT,
                    alternativa42 TEXT,
                    alternativa43 TEXT,
                    alternativa44 TEXT,
                    alternativa45 TEXT,
                    alternativa51 TEXT,
                    alternativa52 TEXT,
                    alternativa53 TEXT,
                    alternativa54 TEXT,
                    alternativa55 TEXT,
                    alternativa61 TEXT,
                    alternativa62 TEXT,
                    alternativa63 TEXT,
                    alternativa64 TEXT,
                    alternativa65 TEXT
                )
                """.trimIndent())

            it.execute("""
                CREATE TABLE IF NOT EXISTS sisins_participante(
                    id SERIAL PRIMARY KEY,
                    categoria INT NOT NULL,
                    nome TEXT NOT NULL,
                    data_nascimento TIMESTAMP NOT NULL,
                    telefone TEXT NOT NULL,
                    email TEXT NOT NULL,
                    senha TEXT NOT NULL,
                    tipo_sem_vinculo INT NOT NULL,
                    vinculo_ufscar INT NOT NULL,
                    escola TEXT NOT NULL,
                    edital INT NOT NULL,
                    onde_conheceu INT NOT NULL,
                    esteve_ufscar INT NOT NULL,
                    local_aulas INT NOT NULL,
                    disponibilidade TEXT NOT NULL,
                    objetivo TEXT NOT NULL,
                    cursou_share INT NOT NULL,
                    desistencia INT NOT NULL,
                    redacao_entrada TEXT NOT NULL,
                    
                    curso1_id INT REFERENCES sisins_curso(id),
                    data_inscricao_c1 TIMESTAMP,
                    resposta1_c1 INT,
                    resposta2_c1 INT,
                    resposta3_c1 INT,
                    resposta4_c1 INT,
                    resposta5_c1 INT,
                    resposta6_c1 INT,
                    avaliador_id_c1 INT INT REFERENCES sisins_avaliador(id),
                    resultado_c1 INT,
                    
                    curso2_id INT INT REFERENCES sisins_curso(id),
                    data_inscricao_c2 TIMESTAMP,
                    resposta1_c2 INT,
                    resposta2_c2 INT,
                    resposta3_c2 INT,
                    resposta4_c2 INT,
                    resposta5_c2 INT,
                    resposta6_c2 INT,
                    avaliador_id_c2 INT INT REFERENCES sisins_avaliador(id),
                    resultado_c2 INT
                )
                """.trimIndent())


            if (it.createQuery("SELECT COUNT(id) FROM sisins_avaliador").mapTo<Int>().one() < 1) {
                val adminId = insertAvaliador("admin", "admin", "Avaliador1")
            }
        }
    }

    override fun getAvaliador(id: Int): Avaliador? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_avaliador WHERE id = :id")
                    .bind("id", id)
                    .mapTo<Avaliador>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun getCurso(id: Int): Curso? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_curso WHERE id = :id")
                    .bind("id", id)
                    .mapTo<Curso>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun getParticipante(id: Int): Participante? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_participante WHERE id = :id")
                    .bind("id", id)
                    .mapTo<Participante>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun allAvaliador(): List<Avaliador> {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_avaliador")
                    .mapTo<Avaliador>()
                    .list()
        }.sortedBy { it.id }
    }

    override fun allCurso(): List<Curso> {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_curso")
                    .mapTo<Curso>()
                    .list()
        }.sortedBy { it.nome }
    }

    override fun allParticipante(): List<Participante> {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_participante")
                    .mapTo<Participante>()
                    .list()
        }.sortedBy { it.nome }
    }

    override fun insertAvaliador(username: String, password: String, nome: String): Avaliador {
        val hash = DataAccessObject.hashPassword(password)

        val id = jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_curso (username, hash, nome) VALUES (:u, :h, :nome)")
                    .bind("u", username)
                    .bind("h", hash)
                    .bind("nome", nome)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }

        return Avaliador(id, username, hash, nome)
    }

    override fun insertCurso(nome: String, categoria: String, horario: String, pergunta1: String, pergunta2: String, pergunta3: String, pergunta4: String, pergunta5: String, pergunta6: String, alternativa11: String, alternativa12: String, alternativa13: String, alternativa14: String, alternativa15: String, alternativa21: String, alternativa22: String, alternativa23: String, alternativa24: String, alternativa25: String, alternativa31: String, alternativa32: String, alternativa33: String, alternativa34: String, alternativa35: String, alternativa41: String, alternativa42: String, alternativa43: String, alternativa44: String, alternativa45: String, alternativa51: String, alternativa52: String, alternativa53: String, alternativa54: String, alternativa55: String, alternativa61: String, alternativa62: String, alternativa63: String, alternativa64: String, alternativa65: String): Curso {
        val id = jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_curso (nome, categoria, horario, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5, pergunta6, alternativa11, alternativa12, alternativa13, alternativa14, alternativa15, alternativa21, alternativa22, alternativa23, alternativa24, alternativa25, alternativa31, alternativa32, alternativa33, alternativa34, alternativa35, alternativa41, alternativa42, alternativa43, alternativa44, alternativa45, alternativa51, alternativa52, alternativa53, alternativa54, alternativa55, alternativa61, alternativa62, alternativa63, alternativa64, alternativa65) VALUES (:nome, :c, :hr, :pergunta1, :pergunta2, :pergunta3, :pergunta4, :pergunta5, :pergunta6, :alternativa11, :alternativa12, :alternativa13, :alternativa14, :alternativa15, :alternativa21, :alternativa22, :alternativa23, :alternativa24, :alternativa25, :alternativa31, :alternativa32, :alternativa33, :alternativa34, :alternativa35, :alternativa41, :alternativa42, :alternativa43, :alternativa44, :alternativa45, :alternativa51, :alternativa52, :alternativa53, :alternativa54, :alternativa55, :alternativa61, :alternativa62, :alternativa63, :alternativa64, :alternativa65)")
                    .bind("nome", nome)
                    .bind("c", categoria)
                    .bind("hr", horario)
                    .bind("pergunta1", pergunta1)
                    .bind("pergunta2", pergunta2)
                    .bind("pergunta3", pergunta3)
                    .bind("pergunta4", pergunta4)
                    .bind("pergunta5", pergunta5)
                    .bind("pergunta6", pergunta6)
                    .bind("alternativa11", alternativa11)
                    .bind("alternativa12", alternativa12)
                    .bind("alternativa13", alternativa13)
                    .bind("alternativa14", alternativa14)
                    .bind("alternativa15", alternativa15)
                    .bind("alternativa21", alternativa21)
                    .bind("alternativa22", alternativa22)
                    .bind("alternativa23", alternativa23)
                    .bind("alternativa24", alternativa24)
                    .bind("alternativa25", alternativa25)
                    .bind("alternativa31", alternativa31)
                    .bind("alternativa32", alternativa32)
                    .bind("alternativa33", alternativa33)
                    .bind("alternativa34", alternativa34)
                    .bind("alternativa35", alternativa35)
                    .bind("alternativa41", alternativa41)
                    .bind("alternativa42", alternativa42)
                    .bind("alternativa43", alternativa43)
                    .bind("alternativa44", alternativa44)
                    .bind("alternativa45", alternativa45)
                    .bind("alternativa51", alternativa51)
                    .bind("alternativa52", alternativa52)
                    .bind("alternativa53", alternativa53)
                    .bind("alternativa54", alternativa54)
                    .bind("alternativa55", alternativa55)
                    .bind("alternativa61", alternativa61)
                    .bind("alternativa62", alternativa62)
                    .bind("alternativa63", alternativa63)
                    .bind("alternativa64", alternativa64)
                    .bind("alternativa65", alternativa65)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }

        return Curso(id, nome, categoria, horario, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5, pergunta6, alternativa11, alternativa12, alternativa13, alternativa14, alternativa15, alternativa21, alternativa22, alternativa23, alternativa24, alternativa25, alternativa31, alternativa32, alternativa33, alternativa34, alternativa35, alternativa41, alternativa42, alternativa43, alternativa44, alternativa45, alternativa51, alternativa52, alternativa53, alternativa54, alternativa55, alternativa61, alternativa62, alternativa63, alternativa64, alternativa65)
    }

    override fun insertParticipante(categoria: Int, nome: String, data_nascimento: LocalDate, telefone: String, email: String, password: String, tipo_sem_vinculo: Int, vinculo_ufscar: Int, escola: String, edital: Int, onde_conheceu: Int, esteve_ufscar: Int, local_aulas: Int, disponibilidade: String, objetivo: Int, cursou_share: Int, desistencia: Int, redacao_entrada: String, curso1_id: Int, data_inscricao_c1: LocalDate, resposta1_c1: Int, resposta2_c1: Int, resposta3_c1: Int, resposta4_c1: Int, resposta5_c1: Int, resposta6_c1: Int, avaliador_id_c1: Int, resultado_c1: Int, curso2_id: Int, data_inscricao_c2: LocalDate, resposta1_c2: Int, resposta2_c2: Int, resposta3_c2: Int, resposta4_c2: Int, resposta5_c2: Int, resposta6_c2: Int, avaliador_id_c2: Int, resultado_c2: Int): Participante {
        val hash = DataAccessObject.hashPassword(password)

        val id = jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_participante (categoria, nome, data_nascimento, telefone, email, hash, tipo_sem_vinculo, vinculo_ufscar, escola, edital, onde_conheceu, esteve_ufscar, local_aulas, disponibilidade, objetivo, cursou_share, desistencia, redacao_entrada, curso1_id, data_inscricao_c1, resposta1_c1, resposta2_c1, resposta3_c1, resposta4_c1, resposta5_c1, resposta6_c1, avaliador_id_c1, resultado_c1, curso2_id, data_inscricao_c2, resposta1_c2, resposta2_c2, resposta3_c2, resposta4_c2, resposta5_c2, resposta6_c2, avaliador_id_c2, resultado_c2) VALUES (:c, :nome, :d, :tel, :email, :h, :tipo_sem_vinculo, :vinculo_ufscar, :escola, :edital, :onde_conheceu, :esteve_ufscar, :local_aulas, :disponibilidade, :objetivo, :cursou_share, :desistencia, :redacao_entrada, :curso1_id, :data_inscricao_c1, :resposta1_c1, :resposta2_c1, :resposta3_c1, :resposta4_c1, :resposta5_c1, :resposta6_c1, :avaliador_id_c1, :resultado_c1, :curso2_id, :data_inscricao_c2, :resposta1_c2, :resposta2_c2, :resposta3_c2, :resposta4_c2, :resposta5_c2, :resposta6_c2, :avaliador_id_c2, :resultado_c2)")
                    .bind("c", categoria)
                    .bind("nome", nome)
                    .bind("d", data_nascimento)
                    .bind("tel", telefone)
                    .bind("email", email)
                    .bind("h", hash)
                    .bind("tipo_sem_vinculo", tipo_sem_vinculo)
                    .bind("vinculo_ufscar", vinculo_ufscar)
                    .bind("escola", escola)
                    .bind("edital", edital)
                    .bind("onde_conheceu", onde_conheceu)
                    .bind("esteve_ufscar", esteve_ufscar)
                    .bind("local_aulas", local_aulas)
                    .bind("disponibilidade", disponibilidade)
                    .bind("objetivo", objetivo)
                    .bind("cursou_share", cursou_share)
                    .bind("desistencia", desistencia)
                    .bind("redacao_entrada", redacao_entrada)
                    .bind("curso1_id", curso1_id)
                    .bind("data_inscricao_c1", OffsetDateTime.now())
                    .bind("resposta1_c1", resposta1_c1)
                    .bind("resposta2_c1", resposta2_c1)
                    .bind("resposta3_c1", resposta3_c1)
                    .bind("resposta4_c1", resposta4_c1)
                    .bind("resposta5_c1", resposta5_c1)
                    .bind("resposta6_c1", resposta6_c1)
                    .bind("avaliador_id_c1", avaliador_id_c1)
                    .bind("resultado_c1", resultado_c1)
                    .bind("curso2_id", curso2_id)
                    .bind("data_inscricao_c2", OffsetDateTime.now())
                    .bind("resposta1_c2", resposta1_c2)
                    .bind("resposta2_c2", resposta2_c2)
                    .bind("resposta3_c2", resposta3_c2)
                    .bind("resposta4_c2", resposta4_c2)
                    .bind("resposta5_c2", resposta5_c2)
                    .bind("resposta6_c2", resposta6_c2)
                    .bind("avaliador_id_c2", avaliador_id_c2)
                    .bind("resultado_c2", resultado_c2)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }

        return Participante(id, categoria, nome, data_nascimento, telefone, email, hash, tipo_sem_vinculo, vinculo_ufscar, escola, edital, onde_conheceu, esteve_ufscar, local_aulas, disponibilidade, objetivo, cursou_share, desistencia, redacao_entrada, curso1_id, data_inscricao_c1, resposta1_c1, resposta2_c1, resposta3_c1, resposta4_c1, resposta5_c1, resposta6_c1, avaliador_id_c1, resultado_c1, curso2_id, data_inscricao_c2, resposta1_c2, resposta2_c2, resposta3_c2, resposta4_c2, resposta5_c2, resposta6_c2, avaliador_id_c2, resultado_c2)
    }

    override fun updateAvaliador(avaliador: Avaliador) {
        jdbi.useHandleUnchecked {
            it.createUpdate("""
                UPDATE sisins_avaliador SET 
                    username = :username,
                    hash = :hash,
                    nome = :nome
                WHERE id = :id
                """.trimIndent())
                    .bindKotlin(avaliador)
                    .execute()
        }
    }

    override fun updateCurso(curso: Curso) {
        jdbi.useHandleUnchecked {
            it.createUpdate("""
                UPDATE sisins_curso SET 
                    nome = :nome,
                    categoria = :categoria,
                    horario = :horario,
                    pergunta1 = :pergunta1,
                    pergunta2 = :pergunta2,
                    pergunta3 = :pergunta3,
                    pergunta4 = :pergunta4,
                    pergunta5 = :pergunta5,
                    pergunta6 = :pergunta6,
                    alternativa11 = :alternativa11,
                    alternativa12 = :alternativa12,
                    alternativa13 = :alternativa13,
                    alternativa14 = :alternativa14,
                    alternativa15 = :alternativa15,
                    alternativa21 = :alternativa21,
                    alternativa22 = :alternativa22,
                    alternativa23 = :alternativa23,
                    alternativa24 = :alternativa24,
                    alternativa25 = :alternativa25,
                    alternativa31 = :alternativa31,
                    alternativa32 = :alternativa32,
                    alternativa33 = :alternativa33,
                    alternativa34 = :alternativa34,
                    alternativa35 = :alternativa35,
                    alternativa41 = :alternativa41,
                    alternativa42 = :alternativa42,
                    alternativa43 = :alternativa43,
                    alternativa44 = :alternativa44,
                    alternativa45 = :alternativa45,
                    alternativa51 = :alternativa51,
                    alternativa52 = :alternativa52,
                    alternativa53 = :alternativa53,
                    alternativa54 = :alternativa54,
                    alternativa55 = :alternativa55,
                    alternativa61 = :alternativa61,
                    alternativa62 = :alternativa62,
                    alternativa63 = :alternativa63,
                    alternativa64 = :alternativa64,
                    alternativa65 = :alternativa65
                WHERE id = :id
                """.trimIndent())
                    .bindKotlin(curso)
                    .execute()
        }
    }

    override fun updateParticipante(participante: Participante) {
        jdbi.useHandleUnchecked {
            it.createUpdate("""
                UPDATE sisins_participante SET
                    categoria = :categoria,
                    nome = :nome,
                    data_nascimento = :data_nascimento,
                    telefone = :telefone,
                    email = :email,
                    hash = :hash,
                    tipo_sem_vinculo = :tipo_sem_vinculo,
                    vinculo_ufscar = :vinculo_ufscar,
                    escola = :escola,
                    esteve_ufscar = :esteve_ufscar,
                    edital = :edital,
                    onde_conheceu = :onde_conheceu,
                    local_aulas = :local_aulas,
                    disponibilidade = :disponibilidade,
                    objetivo = :objetivo,
                    cursou_share = :cursou_share,
                    desistencia = :desistencia,
                    redacao_entrada = :redacao_entrada,
                    curso1_id = :curso1_id,
                    data_inscricao_c1 = :data_inscricao_c1,
                    resposta1_c1 = :resposta1_c1,
                    resposta2_c1 = :resposta2_c1,
                    resposta3_c1 = :resposta3_c1,
                    resposta4_c1 = :resposta4_c1,
                    resposta5_c1 = :resposta5_c1,
                    resposta6_c1 = :resposta6_c1,
                    avaliador_id_c1 = :avaliador_id_c1,
                    resultado_c1 = :resultado_c1,                    
                    curso2_id = :curso2_id,
                    data_inscricao_c2 = :data_inscricao_c2,
                    resposta1_c2 = :resposta1_c2,
                    resposta2_c2 = :resposta2_c2,
                    resposta3_c2 = :resposta3_c2,
                    resposta4_c2 = :resposta4_c2,
                    resposta5_c2 = :resposta5_c2,
                    resposta6_c2 = :resposta6_c2,
                    avaliador_id_c2 = :avaliador_id_c2,
                    resultado_c2 = :resultado_c2
                WHERE id = :id
                """.trimIndent())
                    .bindKotlin(participante)
                    .execute()
        }
    }

    override fun removeAvaliador(id: Int) {
        jdbi.useHandleUnchecked {
            it.execute("DELETE FROM sisins_avaliador WHERE id = ?", id)
        }
    }

    override fun removeCurso(id: Int) {
        jdbi.useHandleUnchecked {
            it.execute("DELETE FROM sisins_curso WHERE id = ?", id)
        }
    }

    override fun removeParticipante(id: Int) {
        jdbi.useHandleUnchecked {
            it.execute("DELETE FROM sisins_participante WHERE id = ?", id)
        }
    }
}