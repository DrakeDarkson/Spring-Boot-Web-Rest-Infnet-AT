package al.infnet.edu.br.assessment.controller;

import al.infnet.edu.br.assessment.model.Usuario;
import al.infnet.edu.br.assessment.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(@PathVariable String id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNome(usuarioDetails.getNome());
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioDetails.getSenha()));
            usuario.setPapel(usuarioDetails.getPapel());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @DeleteMapping("/usuarios/{id}")
    public String deleteUsuario(@PathVariable String id) {
        usuarioRepository.deleteById(id);
        return "Usuário removido com sucesso";
    }
}
