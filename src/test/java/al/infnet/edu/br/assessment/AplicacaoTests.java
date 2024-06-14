package al.infnet.edu.br.assessment;

import al.infnet.edu.br.assessment.controller.FuncionarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AplicacaoTests {

    @Autowired
    private FuncionarioController funcionarioController;

    @Test
    void contextLoads() {
        assertThat(funcionarioController).isNotNull();
    }
}
