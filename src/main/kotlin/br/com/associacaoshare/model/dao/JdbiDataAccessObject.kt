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
                    hash TEXT NOT NULL,
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
                    hash TEXT NOT NULL,
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
                    
                    curso1_id INT,
                    data_inscricao_c1 TIMESTAMP,
                    resposta1_c1 INT,
                    resposta2_c1 INT,
                    resposta3_c1 INT,
                    resposta4_c1 INT,
                    resposta5_c1 INT,
                    resposta6_c1 INT,
                    avaliador_id_c1 INT,
                    resultado_c1 INT,
                    
                    curso2_id INT,
                    data_inscricao_c2 TIMESTAMP,
                    resposta1_c2 INT,
                    resposta2_c2 INT,
                    resposta3_c2 INT,
                    resposta4_c2 INT,
                    resposta5_c2 INT,
                    resposta6_c2 INT,
                    avaliador_id_c2 INT,
                    resultado_c2 INT
                )
                """.trimIndent())

            it.execute("""
                CREATE TABLE IF NOT EXISTS sisins_inscricoes(
                    id INT,
                    open INT
                )
                """.trimIndent())

            it.execute("""
                CREATE OR REPLACE FUNCTION verificaEmail() RETURNS trigger AS ${"\$"}verificaEmail$
                BEGIN
                IF EXISTS (SELECT 1 FROM sisins_participante WHERE email = NEW.email AND id != NEW.id) THEN
                RAISE EXCEPTION 'O e-mail % já está cadastrado', NEW.email;
                RETURN NULL;
                END IF;
    
                RETURN NEW;
                END;
                ${"\$"}verificaEmail$ LANGUAGE plpgsql;
    
                DROP TRIGGER IF EXISTS verificaEmail ON sisins_participante;
                CREATE TRIGGER verificaEmail BEFORE INSERT OR UPDATE ON sisins_participante
                FOR EACH ROW EXECUTE PROCEDURE verificaEmail();
            """.trimIndent())

            /*if (it.createQuery("SELECT COUNT(id) FROM sisins_avaliador").mapTo<Int>().one() < 1) {
                val adminId = insertAvaliador("admin", "admin", "Avaliador1")
            }*/

            if (it.createQuery("SELECT COUNT(open) FROM sisins_inscricoes").mapTo<Int>().one() < 1) {
                insertInterruptor()
            }
        }
    }

    override fun getAvaliador(id: Int): Avaliador? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT id, username, hash, nome FROM pagini_usuario JOIN pagini_pessoa ON pagini_usuario.pessoaid = pagini_pessoa.id WHERE id = :id")
                    .bind("id", id)
                    .mapTo<Avaliador>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun getAvaliadorbyUsername(user: String): Avaliador? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT id, username, hash, nome FROM pagini_usuario JOIN pagini_pessoa ON pagini_usuario.pessoaid = pagini_pessoa.id WHERE username = :user")
                    .bind("user", user)
                    .mapTo<Avaliador>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun getCurso(id: Int?): Curso? {
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

    override fun getParticipantebyEmail(email: String): Participante? {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_participante WHERE email = :email")
                    .bind("email", email)
                    .mapTo<Participante>()
                    .findOne()
                    .orElse(null)
        }
    }

    override fun getParticipantesbyCurso(curso: Int): List<Participante> {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT * FROM sisins_participante WHERE (curso1_id = :id OR curso2_id = :id)")
                    .bind("id", curso)
                    .mapTo<Participante>()
                    .list()
        }.sortedBy { it.nome }
    }

    override fun getInterruptor(): Int {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT open FROM sisins_inscricoes WHERE (id = 1)")
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun countParticipante(): Int {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT COUNT(id) FROM sisins_participante")
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun countParticipantebyCurso(curso: Int): Int {
        return jdbi.withHandleUnchecked {
            it.createQuery("SELECT COUNT(id) FROM sisins_participante WHERE (curso1_id = :id OR curso2_id = :id)")
                    .bind("id", curso)
                    .mapTo<Int>()
                    .one()
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

    override fun insertInterruptor() {

        jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_inscricoes (id, open) VALUES (1, 0)")
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun insertAvaliador(username: String, password: String, nome: String): Avaliador {
        val hash = DataAccessObject.hashPassword(password)

        val id = jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_avaliador (username, hash, nome) VALUES (:u, :h, :nome)")
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

    override fun insertCurso(respostasPack: Map<String, List<String>>): Curso {
        val respostas: Map<String, String> = respostasPack.mapValues { (key, value) -> (value[0]) }
        val nome: String by respostas
        val categoria: String by respostas
        val horario: String by respostas

        val pergunta1: String? = ""
        val pergunta2: String? = ""
        val pergunta3: String? = ""
        val pergunta4: String? = ""
        val pergunta5: String? = ""
        val pergunta6: String? = ""

        val alternativa11: String? = ""
        val alternativa12: String? = ""
        val alternativa13: String? = ""
        val alternativa14: String? = ""
        val alternativa15: String? = ""
        val alternativa21: String? = ""
        val alternativa22: String? = ""
        val alternativa23: String? = ""
        val alternativa24: String? = ""
        val alternativa25: String? = ""
        val alternativa31: String? = ""
        val alternativa32: String? = ""
        val alternativa33: String? = ""
        val alternativa34: String? = ""
        val alternativa35: String? = ""
        val alternativa41: String? = ""
        val alternativa42: String? = ""
        val alternativa43: String? = ""
        val alternativa44: String? = ""
        val alternativa45: String? = ""
        val alternativa51: String? = ""
        val alternativa52: String? = ""
        val alternativa53: String? = ""
        val alternativa54: String? = ""
        val alternativa55: String? = ""
        val alternativa61: String? = ""
        val alternativa62: String? = ""
        val alternativa63: String? = ""
        val alternativa64: String? = ""
        val alternativa65: String? = ""


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
            it.createUpdate("INSERT INTO sisins_participante (categoria, nome, data_nascimento, telefone, email, hash, tipo_sem_vinculo, vinculo_ufscar, escola, edital, onde_conheceu, esteve_ufscar, local_aulas, disponibilidade, objetivo, cursou_share, desistencia, redacao_entrada, curso1_id, data_inscricao_c1, resposta1_c1, resposta2_c1, resposta3_c1, resposta4_c1, resposta5_c1, resposta6_c1, avaliador_id_c1, resultado_c1, curso2_id, data_inscricao_c2, resposta1_c2, resposta2_c2, resposta3_c2, resposta4_c2, resposta5_c2, resposta6_c2, avaliador_id_c2, resultado_c2) VALUES (:c, :nome, :d, :tel, :email, :senha, :tipo_sem_vinculo, :vinculo_ufscar, :escola, :edital, :onde_conheceu, :esteve_ufscar, :local_aulas, :disponibilidade, :objetivo, :cursou_share, :desistencia, :redacao_entrada, :curso1_id, :data_inscricao_c1, :resposta1_c1, :resposta2_c1, :resposta3_c1, :resposta4_c1, :resposta5_c1, :resposta6_c1, :avaliador_id_c1, :resultado_c1, :curso2_id, :data_inscricao_c2, :resposta1_c2, :resposta2_c2, :resposta3_c2, :resposta4_c2, :resposta5_c2, :resposta6_c2, :avaliador_id_c2, :resultado_c2)")
                    .bind("c", categoria)
                    .bind("nome", nome)
                    .bind("d", data_nascimento)
                    .bind("tel", telefone)
                    .bind("email", email)
                    .bind("senha", hash)
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

    override fun insertParticipante(respostasPack: Map<String, List<String>>): Participante {
        val respostas: Map<String, String> = respostasPack.mapValues { (key, value) -> (value[0]) }
        val categoria: String by respostas
        val categoriaInt: Int = categoria.toInt()
        val nome: String by respostas
        val data_nascimento: String by respostas
        val dataNascimentoLD = LocalDate.parse(data_nascimento)
        val telefone: String by respostas
        val email: String by respostas
        val password: String by respostas
        val tipo_sem_vinculo: String by respostas
        val tipoSemVinculoInt: Int = tipo_sem_vinculo.toInt()
        val vinculo_ufscar: String by respostas
        val vinculoUfscarInt: Int = vinculo_ufscar.toInt()
        val escola: String by respostas
        val edital: String by respostas
        val editalInt: Int = edital.toInt()
        val onde_conheceu: String by respostas
        val ondeConheceuInt: Int = onde_conheceu.toInt()
        val esteve_ufscar: String by respostas
        val esteveUfscarInt: Int = esteve_ufscar.toInt()
        val local_aulas: String by respostas
        val localAulasInt: Int = local_aulas.toInt()
        val disponibilidade: String by respostas
        val objetivo: String by respostas
        val objetivoInt: Int = objetivo.toInt()
        val cursou_share: String by respostas
        val cursouShareInt: Int = cursou_share.toInt()
        val desistencia: String by respostas
        val desistenciaInt: Int = desistencia.toInt()
        val redacao_entrada: String by respostas

        val curso1_id: Int? = null
        val data_inscricao_c1: LocalDate? = null
        val resposta1_c1: Int? = null
        val resposta2_c1: Int? = null
        val resposta3_c1: Int? = null
        val resposta4_c1: Int? = null
        val resposta5_c1: Int? = null
        val resposta6_c1: Int? = null
        val avaliador_id_c1: Int? = null
        val resultado_c1: Int? = -1

        val curso2_id: Int? = null
        val data_inscricao_c2: LocalDate? = null
        val resposta1_c2: Int? = null
        val resposta2_c2: Int? = null
        val resposta3_c2: Int? = null
        val resposta4_c2: Int? = null
        val resposta5_c2: Int? = null
        val resposta6_c2: Int? = null
        val avaliador_id_c2: Int? = null
        val resultado_c2: Int? = -1


        val hash = DataAccessObject.hashPassword(password)

        val id = jdbi.withHandleUnchecked {
            it.createUpdate("INSERT INTO sisins_participante (categoria, nome, data_nascimento, telefone, email, hash, tipo_sem_vinculo, vinculo_ufscar, escola, edital, onde_conheceu, esteve_ufscar, local_aulas, disponibilidade, objetivo, cursou_share, desistencia, redacao_entrada, curso1_id, data_inscricao_c1, resposta1_c1, resposta2_c1, resposta3_c1, resposta4_c1, resposta5_c1, resposta6_c1, avaliador_id_c1, resultado_c1, curso2_id, data_inscricao_c2, resposta1_c2, resposta2_c2, resposta3_c2, resposta4_c2, resposta5_c2, resposta6_c2, avaliador_id_c2, resultado_c2) VALUES (:c, :nome, :d, :tel, :email, :hash, :tipo_sem_vinculo, :vinculo_ufscar, :escola, :edital, :onde_conheceu, :esteve_ufscar, :local_aulas, :disponibilidade, :objetivo, :cursou_share, :desistencia, :redacao_entrada, :curso1_id, :data_inscricao_c1, :resposta1_c1, :resposta2_c1, :resposta3_c1, :resposta4_c1, :resposta5_c1, :resposta6_c1, :avaliador_id_c1, :resultado_c1, :curso2_id, :data_inscricao_c2, :resposta1_c2, :resposta2_c2, :resposta3_c2, :resposta4_c2, :resposta5_c2, :resposta6_c2, :avaliador_id_c2, :resultado_c2)")
                    .bind("c", categoriaInt)
                    .bind("nome", if (nome.isNullOrEmpty()) null else nome)
                    .bind("d", dataNascimentoLD)
                    .bind("tel", if (telefone.isNullOrEmpty()) null else telefone)
                    .bind("email", if (email.isNullOrEmpty()) null else email)
                    .bind("hash", if (password.isNullOrEmpty()) null else hash)
                    .bind("tipo_sem_vinculo", tipoSemVinculoInt)
                    .bind("vinculo_ufscar", vinculoUfscarInt)
                    .bind("escola", if (escola.isNullOrEmpty()) null else escola)
                    .bind("edital", editalInt)
                    .bind("onde_conheceu", ondeConheceuInt)
                    .bind("esteve_ufscar", esteveUfscarInt)
                    .bind("local_aulas", localAulasInt)
                    .bind("disponibilidade", if (disponibilidade.isNullOrEmpty()) null else disponibilidade)
                    .bind("objetivo", objetivoInt)
                    .bind("cursou_share", cursouShareInt)
                    .bind("desistencia", desistenciaInt)
                    .bind("redacao_entrada", if (redacao_entrada.isNullOrEmpty()) null else redacao_entrada)
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

        return Participante(id, categoriaInt, nome, dataNascimentoLD, telefone, email, hash, tipoSemVinculoInt, vinculoUfscarInt, escola, editalInt, ondeConheceuInt, esteveUfscarInt, localAulasInt, disponibilidade, objetivoInt, cursouShareInt, desistenciaInt, redacao_entrada, curso1_id, data_inscricao_c1, resposta1_c1, resposta2_c1, resposta3_c1, resposta4_c1, resposta5_c1, resposta6_c1, avaliador_id_c1, resultado_c1, curso2_id, data_inscricao_c2, resposta1_c2, resposta2_c2, resposta3_c2, resposta4_c2, resposta5_c2, resposta6_c2, avaliador_id_c2, resultado_c2)
    }

    override fun updateAvaliacaoParticipante(participante: Participante, c1Id: Int?, c2Id: Int?) {
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_participante SET curso1_id = :c1 OR curso2_id = :c2 WHERE id = :idPart")
                    .bind("c1", c1Id)
                    .bind("c2", c2Id)
                    .bind("idPart", participante.id)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun updateCurso1inParticipante(participante: Participante, id: Int?) {
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_participante SET curso1_id = :c1 WHERE id = :idPart")
                    .bind("c1", id)
                    .bind("idPart", participante.id)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun updateCurso2inParticipante(participante: Participante, id: Int?) {
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_participante SET curso2_id = :c2 WHERE id = :idPart")
                    .bind("c2", id)
                    .bind("idPart", participante.id)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun updateProva1inParticipante(participante: Participante ) {
        jdbi.useHandleUnchecked {
            it.createUpdate("""
                UPDATE sisins_participante SET
                    resposta1_c1 = :resposta1_c1,
                    resposta2_c1 = :resposta2_c1,
                    resposta3_c1 = :resposta3_c1,
                    resposta4_c1 = :resposta4_c1,
                    resposta5_c1 = :resposta5_c1,
                    resposta6_c1 = :resposta6_c1
                WHERE id = :id
                """.trimIndent())
                    .bindKotlin(participante)
                    .execute()
        }
    }

    override fun updateProva2inParticipante(participante: Participante ) {
        jdbi.useHandleUnchecked {
            it.createUpdate("""
                UPDATE sisins_participante SET
                    resposta1_c2 = :resposta1_c2,
                    resposta2_c2 = :resposta2_c2,
                    resposta3_c2 = :resposta3_c2,
                    resposta4_c2 = :resposta4_c2,
                    resposta5_c2 = :resposta5_c2,
                    resposta6_c2 = :resposta6_c2
                WHERE id = :id
                """.trimIndent())
                    .bindKotlin(participante)
                    .execute()
        }
    }

    override fun updateResultado1(idParticipante: Int, valor: Int){
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_participante SET resultado_c1 = :v WHERE id = :idPart")
                    .bind("v", valor)
                    .bind("idPart", idParticipante)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
    }

    override fun updateResultado2(idParticipante: Int, valor: Int){
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_participante SET resultado_c2 = :v WHERE id = :idPart")
                    .bind("v", valor)
                    .bind("idPart", idParticipante)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
        }
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

    override fun updateInterruptor(valor: Int) {
        jdbi.useHandleUnchecked {
            it.createUpdate("UPDATE sisins_inscricoes SET open = :v WHERE id = '1'")
                    .bind("v", valor)
                    .executeAndReturnGeneratedKeys()
                    .mapTo<Int>()
                    .one()
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