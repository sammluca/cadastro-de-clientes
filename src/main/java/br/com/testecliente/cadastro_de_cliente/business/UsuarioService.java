package br.com.testecliente.cadastro_de_cliente.business;

import br.com.testecliente.cadastro_de_cliente.entitys.Usuario;
import br.com.testecliente.cadastro_de_cliente.entitys.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public Usuario buscarUsuarioPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void deletarUsuarioPorId(Integer id){
        repository.deleteById(id);
    }

    public void atualizaUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorId(id);
        Usuario usuarioAtualizado = usuario.builder()
                .email(usuario.getEmail() != null ? usuarioEntity.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuarioEntity.getNome() :
                        usuario.getNome())
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }
}

