package al.infnet.edu.br.assessment.controller;

import al.infnet.edu.br.assessment.exception.ResourceNotFoundException;
import al.infnet.edu.br.assessment.model.Departamento;
import al.infnet.edu.br.assessment.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento not found with id " + id));
        return ResponseEntity.ok(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamentoDetails) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento not found with id " + id));

        departamento.setNome(departamentoDetails.getNome());
        departamento.setLocal(departamentoDetails.getLocal());

        Departamento updatedDepartamento = departamentoRepository.save(departamento);
        return ResponseEntity.ok(updatedDepartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento not found with id " + id));

        departamentoRepository.delete(departamento);
        return ResponseEntity.noContent().build();
    }
}
