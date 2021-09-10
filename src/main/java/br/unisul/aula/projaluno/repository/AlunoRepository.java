package br.unisul.aula.projaluno.repository;

import br.unisul.aula.projaluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findFirstByNome(String nome);
}
