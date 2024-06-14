package al.infnet.edu.br.assessment.repository;

import al.infnet.edu.br.assessment.model.Funcionario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Test
    void testSaveFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("John Doe");
        funcionario.setEmail("john.doe@example.com");

        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        assertThat(savedFuncionario.getId()).isNotNull();
    }
}
