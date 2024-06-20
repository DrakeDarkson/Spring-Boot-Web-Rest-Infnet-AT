package al.infnet.edu.br.assessment.repository;

import al.infnet.edu.br.assessment.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findUsuarioByNome(String nome);
}
