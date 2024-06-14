package al.infnet.edu.br.assessment.controller;

import al.infnet.edu.br.assessment.repository.FuncionarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FuncionarioController.class)
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Test
    void shouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/api/funcionarios"))
                .andExpect(status().isOk());
    }
}
