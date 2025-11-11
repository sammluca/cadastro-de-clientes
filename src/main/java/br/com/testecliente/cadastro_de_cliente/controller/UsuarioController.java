package br.com.testecliente.cadastro_de_cliente.controller;

import br.com.testecliente.cadastro_de_cliente.business.UsuarioService;
import br.com.testecliente.cadastro_de_cliente.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/post-user")
    public ResponseEntity<Void> salverUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar-id")
    public ResponseEntity<Usuario> buscarUsuarioporId(@RequestParam Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }
    @GetMapping("/buscar-email")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping("/delet-por-id")
    public ResponseEntity<Void> deletarUsuarioporId(@RequestParam Integer id){
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delet-por-email")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/put")
    public ResponseEntity<Void> atualizarUsuarioId(@RequestParam Integer id,
                                                    @RequestBody Usuario usuario){
        usuarioService.atualizaUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
