package br.com.testecliente.cadastro_de_cliente.entitys.repository;

import br.com.testecliente.cadastro_de_cliente.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(Integer id);

    @Transactional
    void deleteByEmail(String email);

    @Transactional
    void deleteById(Integer id);

}
