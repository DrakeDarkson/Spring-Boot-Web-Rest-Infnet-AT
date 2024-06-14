package al.infnet.edu.br.assessment.controller;

import al.infnet.edu.br.assessment.exception.ResourceNotFoundException;
import al.infnet.edu.br.assessment.model.Funcionario;
import al.infnet.edu.br.assessment.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found with id " + id));
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found with id " + id));

        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setEndereco(funcionarioDetails.getEndereco());
        funcionario.setTelefone(funcionarioDetails.getTelefone());
        funcionario.setEmail(funcionarioDetails.getEmail());
        funcionario.setDataNascimento(funcionarioDetails.getDataNascimento());

        Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found with id " + id));

        funcionarioRepository.delete(funcionario);
        return ResponseEntity.noContent().build();
    }
}
