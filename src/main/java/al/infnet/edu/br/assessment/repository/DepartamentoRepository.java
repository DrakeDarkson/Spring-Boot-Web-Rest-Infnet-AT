package al.infnet.edu.br.assessment.repository;

import al.infnet.edu.br.assessment.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
