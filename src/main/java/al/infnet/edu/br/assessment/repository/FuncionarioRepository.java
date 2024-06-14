package al.infnet.edu.br.assessment.repository;

import al.infnet.edu.br.assessment.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
