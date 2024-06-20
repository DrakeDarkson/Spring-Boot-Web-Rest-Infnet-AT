package al.infnet.edu.br.assessment.Service;

import al.infnet.edu.br.assessment.model.Usuario;
import al.infnet.edu.br.assessment.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não cadastrado");
        }
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNome())
                .password(usuario.getSenha())
                .roles(usuario.getPapel())
                .build();
    }
}

